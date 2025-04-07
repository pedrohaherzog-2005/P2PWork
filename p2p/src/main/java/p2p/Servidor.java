package p2p;
import java.io.*;
import java.net.*;

public class Servidor extends Thread {
  ServerSocket servidor;

  public Servidor(int porta) throws IOException {
    try {
      servidor = new ServerSocket(porta);
      System.out.println("SERVIDOR RODANDO NA PORTA (" + porta + ")");
    } catch (IOException e) {
      System.out.println("HOUVE UMA EXCESSÃO AO INICIAR O SERVIDOR: " + e.getMessage());
    }
  }

  public void run() {
    try {
      while (true) {
        Socket cliente = servidor.accept();
        new AtendeCliente(cliente).start();
      }
    } catch (IOException e) {
      System.out.println("HOUVE UMA EXCESSSÃO AO ACEITAR O CLIENTE AO SERVIDOR: " + e.getMessage());
    }
  }
}