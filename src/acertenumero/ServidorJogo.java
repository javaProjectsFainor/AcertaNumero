/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acertenumero;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author usuario
 */
public class ServidorJogo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(9001);
        
        while(true) {
            System.out.println("Aguardando Jogador");
            Socket cliente = server.accept();
            Scanner entrada = new Scanner(cliente.getInputStream());
            PrintWriter saida = new PrintWriter(cliente.getOutputStream(), true);
            
            Random random = new Random();
            int number = random.nextInt(101);
            
            int clientValue;
            String msg = "Voce errou!";
            
            do {
                clientValue = entrada.nextInt();
                if(clientValue == number)
                    msg = "Voce acertouuu";
                else if(clientValue < number)
                    msg = "Digite um numero maior";
                else if(clientValue > number)
                    msg = "Digite um numero menor";
                
                saida.println(msg);
            } while(!msg.equals("Voce acertouuu"));

            entrada.close();
            saida.close();
            cliente.close();
        }
            
    }
}
