package p2p;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
  public static void main(String[] args) {
    Scanner teclado = new Scanner(System.in);

    try {
      System.out.println("INFORME A PORTA PARA O SEU SERVIDOR P2P: ");
      int portaServidor = teclado.nextInt();
      teclado.nextLine();
      new Servidor(portaServidor).start();

      System.out.println("DESEJA CONECTAR A OUTRO CLIENTE? (S/N): ");

      if (teclado.nextLine().equalsIgnoreCase("s")) {
        System.out.println("INFORME O IP DO OUTRO CLIENTE: ");
        String ip = teclado.nextLine();
        System.out.println("INFORME A PORTA DO OUTRO CLIENTE: ");
        int porta = teclado.nextInt();
        teclado.nextLine();

        try (
          Socket cliente = new Socket(ip, porta);
          PrintWriter saida = new PrintWriter(cliente.getOutputStream(), true);
        ) {
          System.out.println("CONECTADO AO CLIENTE " + ip + ":" + porta);
          while (true) {
            System.out.println("DIGITE SUA MENSAGEM: ");
            String mensagem = teclado.nextLine();
            saida.println(mensagem);
          }
        }
      } else {
        System.out.println("EXECUÇÃO ENCERRADA ...");
        teclado.close();
      }
    } catch (Exception e) {
      System.out.println("HOUVE UMA EXCESSÃO DURANTE A EXECUÇÃO DO CLIENTE: \n" + e.getMessage());
    }
  }
}
