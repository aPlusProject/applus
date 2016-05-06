package socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JLabel;

public class SocketClient {

	private Socket sck;
	private String host;
	private int port;
	
	
	public SocketClient() {
		
	}
	
	public SocketClient(String host, int port) throws UnknownHostException, IOException {
		this.sck = new Socket(host, port);
		this.host = host;
		this.port = port;
	}
	
	public void connectTo(String host, int port) throws UnknownHostException, IOException {
		this.sck = new Socket(host, port);
	}
	
	public Socket getSocket() {
		return this.sck;
	}
	
	public void send(String message) throws IOException {
		OutputStream os = this.sck.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os) ;
        dos.writeUTF(message);
        System.out.println("Client send :"+message);
        
	}
	
	public void receive() throws IOException {
        try {
        	InputStream in = this.sck.getInputStream();
            DataInputStream dis =new DataInputStream(in);
            System.out.println("Client reading...");
            String msg = dis.readUTF() ;
            Logger.global.info("reçu : " +msg);
            System.out.println("Client get message : " +msg);
         } catch(IOException exc) {
            Logger.global.log(Level.SEVERE,"serveur",exc) ;
         }
	}
	
	
}
