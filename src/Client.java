
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author andrvtl
 */
public class Client {

    String nome;
    String colore;
    Socket socket;

    public static final String BLUE = "\u001B[34m";
    public static final String RESET = "\u001B[0m";

    InputStream is;
    Scanner streamIn = null;
    OutputStream os;
    PrintWriter streamOut = null;
    String messaggioIn, messaggioOut;


    public Client(String nome){
        this.nome = nome;

    }

    public Client(String nome, String colore){
        this.nome = nome;
        this.colore = colore;

    }

    public void connetti(String nomeServer, int portaServer){

        try {
            socket = new Socket(nomeServer, portaServer);
            System.out.println("1) Connessione con il server avvenuta");
            System.out.println(BLUE + "Socket client: " + socket.getLocalSocketAddress() + RESET);
            System.out.println("Socket server: " + socket.getRemoteSocketAddress());

        }
        catch(ConnectException ex){
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Errore di connessione, server non in ascolto");
        }
        catch (UnknownHostException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Errore nella risoluzione del nome del server");
        }
        catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Errore nello stabilimento della connessione con il server");
        }

    }


    public void scrivi(){
        try {
            // Crea un oggetto output stream con la socket corrente
            os = socket.getOutputStream();
            streamOut = new PrintWriter(os);
            // Scarica preventivamente
            streamOut.flush();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Errore nell'inizializzazione dello stream di output");
        }

    }

    public void chiudi(){
        if(socket!=null) {
            try {
                socket.close();
                System.out.println("5) Chiusura connessione avvenuta con successo");
            } catch (IOException e) {
                System.err.println("Errore nella chiusura del socket");
            }
        }
        else{
            System.out.println("Errore nella chiusura, socket non instanziato/rilevato");
        }

    }

    public void leggi(){
        try {
            is = socket.getInputStream();
            streamIn = new Scanner(is);
            messaggioIn = streamIn.nextLine();
            System.out.println("Messaggio del server: " + messaggioIn);
            messaggioOut="Eccomi!";
            streamOut.println(messaggioOut);
            streamOut.flush();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Errore nell'inizializzazione dello stream di input");
        }
    }

}
