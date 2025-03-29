package p2p.Server;

import java.net.ServerSocket;

public class Server {
  public static void main(String[] args) {
    try (ServerSocket servidor = new ServerSocket(8080)) {

      System.out.println("Porta iniciada: " + servidor);

      while (true) {
        
      }
      
    } catch (Exception e) {
      System.out.println("Exceção no server: " + e.getMessage());
    }
  }
}