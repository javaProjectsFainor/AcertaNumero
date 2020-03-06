/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acertenumero;

import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author usuario
 */
public class ClienteJogo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);
        InetAddress end = InetAddress.getLocalHost();
        Socket s = new Socket(end, 9001);
        Scanner entrada = new Scanner(s.getInputStream());
        PrintWriter saida = new PrintWriter(s.getOutputStream(), true);
        int msg;
        String correct;

        do {
            System.out.println("Digite um número");
            msg = teclado.nextInt();
            saida.println(msg);
            correct = entrada.nextLine();
            System.out.println(correct);            
        } while(!correct.equals("Voce acertouuu"));

        entrada.close();
        saida.close();
        s.close();
    }
    
}
