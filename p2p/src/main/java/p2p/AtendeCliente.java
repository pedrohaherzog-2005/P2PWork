package p2p;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class AtendeCliente extends Thread {
    private Socket cliente;

    public AtendeCliente(Socket cliente) {
        this.cliente = cliente;
    }

    public void run() {
        try (BufferedReader entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()))) {
            String mensagem;
            while ((mensagem = entrada.readLine()) != null) {
                System.out.println("MENSAGEM RECEBIDA: " + mensagem);
            }
        } catch (IOException e) {
            System.out.println("HOUVE UMA EXCESSÃO AO RECEBER DADOS DO CLIENTE: " + e.getMessage());
        }
    }
}
