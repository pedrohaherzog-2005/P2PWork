package p2p;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Server extends Thread {
  ServerSocket server;

  public Server(int porta) throws IOException {
    server = new ServerSocket(porta);
    System.out.println("Servidor rodando" + porta);
  }

  public void run() {
    try {
      while (true) {
        Socket cliente = server.accept();
        new ClienteHandler(cliente).start();
      }
    } catch (IOException e) {
      System.out.println("Erro ao aceitar conexão: " + e.getMessage());
    }
  }
}