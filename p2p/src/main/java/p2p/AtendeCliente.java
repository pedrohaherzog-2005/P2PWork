package p2p;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class AtendeCliente extends Thread {
    private Socket socket;

    public AtendeCliente(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            String mensagem;
            while ((mensagem = in.readLine()) != null) {
                System.out.println("MENSAGEM RECEBIDA: " + mensagem);
            }
        } catch (IOException e) {
            System.out.println("ERRO AO RECEBER A MENSAGEM: " + e.getMessage());
        }
    }
}
