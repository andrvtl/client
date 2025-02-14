/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author andrvtl
 */
public class Main {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args, Socket socket) {

        // Inizializzazioni stream e scanner per scrittura e lettura Client
        InputStream is;
        Scanner streamIn = null;
        OutputStream os;
        PrintWriter streamOut = null;
        String messaggioIn, messaggioOut;

        try {
            // Inizializza client e connessione
            Client c = new Client("localhost");
            c.connetti("localhost",2000);

            // Crea stream 
            os = socket.getOutputStream();
            streamOut = new PrintWriter(os);
            streamOut.flush();
            
            is = socket.getInputStream();
            streamIn = new Scanner(is);
            
            messaggioIn = streamIn.nextLine();
            System.out.println("Messaggio del server: " + messaggioIn);
            messaggioOut = "Ci sono!";
            streamOut.println(messaggioOut);
            streamOut.flush();
            
            c.chiudi();
            
        } catch (IOException e) {
            throw new RuntimeException(e);
        } 
        finally {
            
        }

    }

}
