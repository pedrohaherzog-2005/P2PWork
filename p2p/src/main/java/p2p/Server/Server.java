package p2p.Server;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
  public static void main(String[] args) {
    try {
      ServerSocket servidor = new ServerSocket(8080);

      System.out.println("Servidor na porta " + servidor.getLocalPort());

      while (true) {
        System.out.println("Esperanco conexão com cliente");
        Socket cliente = servidor.accept();
        System.out.println("Cliente conectado" + cliente.getInetAddress());

        try {
          BufferedReader in = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
          PrintWriter out = new PrintWriter(cliente.getOutputStream(), true);

          String mensagem = in.readLine();
          System.out.println("O cliente recebeu a mensagem " + mensagem);
          out.println("Servidor recebeu a mensagem " + mensagem);

        } catch (Exception e) {
          System.out.println("Erro de comunicação com o cliente " + e.getMessage());
        } finally {
          cliente.close();
        }
      }
      
    } catch (Exception e) {
      System.out.println("Exceção no servidor " + e.getMessage());
    }
  }
}