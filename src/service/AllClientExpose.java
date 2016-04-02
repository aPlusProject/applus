package service;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AllClientExpose {
	
	private ServerSocket srv;
	private Socket sck;
	private String msg;
	
	public AllClientExpose(int port) throws IOException {
		srv = new ServerSocket(port);
		
	}
	
	public void lauch() {
		System.out.println("Serveur on...");
		while(true) {
			try {
				// double try bug
				this.sck = srv.accept();
				System.out.println("Connection accepted");
	            DataInputStream dis =new DataInputStream(sck.getInputStream());
	            System.out.println(dis.toString());
	            this.msg = dis.readUTF();
	            System.out.println("Serveur get mesage : "+this.msg);
	            
	            OutputStream os = sck.getOutputStream();
	            DataOutputStream dos = new DataOutputStream(os) ;
	            dos.writeUTF(this.msg);
	            System.out.println("Server send "+this.msg);
	            
	        }catch(IOException exc) {
	             Logger.global.log(Level.SEVERE,"serveur",exc);
	        }
		}
		
	}
	
	public static void main(String[] arg0) throws IOException{
		AllClientExpose serveur = new AllClientExpose(143);
		serveur.lauch();
	}
}
