package service;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.Client;
import model.Employee;

public class AllClientExpose {
	
	private ServerSocket srv;
	private Socket sck;
	private String msg;
	
	public AllClientExpose(int port) throws IOException {
		srv = new ServerSocket(port);
		
	}
	
	public void lauch() throws ClassNotFoundException, SQLException {
		System.out.println("Serveur on...");
		while(true) {
			try {
				// double try bug
				this.sck = srv.accept();
				System.out.println("Connection accepted");
	            DataInputStream dis =new DataInputStream(sck.getInputStream());
	            System.out.println(dis.toString());
	            int idClient = Integer.parseInt(dis.readUTF());
	            System.out.println("idClient : "+idClient);
	            Employee employee = new Employee();
	            ArrayList<Client> arrayClient = employee.getAllClients(false, idClient);
	            
	            System.out.println(arrayClient.get(1).getLastName());
	            System.out.println("after get");
	            
	            
	            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("C:\\Users\\asus\\git\\under\\AplusClient\\arrayclient.tmp"));//sck.getOutputStream();
	            //DataOutputStream dos = new DataOutputStream(os) ;
	            //os.writeObject(employee);
	            os.writeObject(arrayClient);
	            System.out.println("Server send "+arrayClient);
	            
	        }catch(IOException exc) {
	             Logger.global.log(Level.SEVERE,"serveur",exc);
	        }
		}
		
	}
	
	public static void main(String[] arg0) throws IOException, ClassNotFoundException, SQLException{
		AllClientExpose serveur = new AllClientExpose(180);
		serveur.lauch();
	}
}
