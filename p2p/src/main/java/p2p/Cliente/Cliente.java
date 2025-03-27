package p2p.Cliente;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
  public static void main(String[] args) {

    // int porta = Integer.parseInt(args[0]);
    // String endereco = "127.0.0.1";

    try (
      Socket cliente = new Socket("127.0.0.1", 8080);
      ServerSocket servidor = new ServerSocket(8080);
      Scanner teclado = new Scanner(System.in);
      Scanner chegada = new Scanner(cliente.getInputStream());
      PrintStream saida = new PrintStream(cliente.getOutputStream());
    ) {
      
      String mensagem = "";

      do {
        
        System.out.println("Digite sua mensagem aqui: ");
        mensagem = teclado.nextLine();
        saida.println(mensagem);

        String resposta = chegada.nextLine();
        System.out.println("A RESPOSTA PARA A MENSAGEM (" + mensagem + ") É: \n" + resposta);

      } while (mensagem.length() != 0);

      cliente.close();

    } catch (Exception e) {
      System.out.println("HOUVE UM PROBLEMA DE EXCESSAO: " + e.getMessage());
    }
    
  }

}
