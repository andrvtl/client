/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author andrvtl
 */
public class Main {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {

        // Inizializzazioni stream e scanner per scrittura e lettura Client
        InputStream is;
        Scanner streamIn = null;
        OutputStream os;
        PrintWriter streamOut = null;

        Client c = new Client("localhost");
        c.connetti("localhost",2000);
        c.chiudi();

    }

}
