package p2p.AtendeCliente;

import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class AtendeCliente extends Thread {
  Socket cliente;

  public AtendeCliente(Socket cliente) {
    this.cliente = cliente;
  }

  public void run() {
    System.out.println("O cliente foi conectado com a thread (" + this.getId() + ");");
    System.out.println("Endereço do cliente: " + cliente.getInetAddress() + ";");

    Scanner teclado = new Scanner(System.in);
    Scanner chegada;
    InputStreamReader fluxoDados;

    try {
      
      chegada = new Scanner(cliente.getInputStream());
      PrintStream saida = new PrintStream(cliente.getOutputStream());

      while (chegada.hasNextLine()) {
        String mensagem = chegada.nextLine();
        System.out.println("A MENSAGEM RECEBIDA DO CLIENTE (" + this.getId() + ") É: " + mensagem);

        String resposta = "Mensagem recebida: " + mensagem;
        saida.println(resposta);
        System.out.println("A RESPOSTA PARA A MENSAGEM (" + mensagem + ") É: \n" + resposta);
        System.out.println("--------------------------------------------------");
      }

    } catch (Exception e) {
      System.out.println("HOUVE UM PROBLEMA DE EXCESSAO: " + e.getMessage());
    }
  }
}
