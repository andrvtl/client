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
    public static void main(String[] args) {

        Client c = new Client("localhost");
        c.connetti("localhost", 2000);
        c.leggi();
        c.scrivi();
        c.chiudi();
    }

}
