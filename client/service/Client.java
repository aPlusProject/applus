package service;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JLabel;



public class Client {
	
	private String nom;
	private String host;
	private int port;
	private Socket sck;
	
	public Client() {
		
	}
	
	public Client(String host, int port) {
		this.host = host;
		this.port = port;
	}
	
	
	public void connect() throws UnknownHostException, IOException {
		this.sck = new Socket(this.host, this.port);
        System.out.println("connected to "+this.host+":"+this.port);
		
	}
	
	public void connectTo(String host, int port) throws UnknownHostException, IOException {
		this.sck = new Socket(host, port);
		System.out.println("connected to "+host+":"+port);
	}
	
	public void envoyer(String message) throws IOException {
		OutputStream os = this.sck.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os) ;
        dos.writeUTF(message);
        System.out.println("Client send :"+message);
        
	}
	
	public void sendJsonFile(String json) throws IOException {
		OutputStream os = this.sck.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os);
        dos.writeUTF(json);
	}
	
	
	public void receive(JLabel label) throws IOException {
        try {
        	InputStream in = this.sck.getInputStream();
            DataInputStream dis =new DataInputStream(in);
            System.out.println("Client reading...");
            String msg = dis.readUTF() ;
            Logger.global.info("reçu : " +msg);
            System.out.println("Client get message : " +msg);
            label.setText(msg);
         } catch(IOException exc) {
            Logger.global.log(Level.SEVERE,"serveur",exc) ;
         }
	}

}
