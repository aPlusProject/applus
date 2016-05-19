package edu.aplus.service;

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

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import edu.aplus.model.Client;
import edu.aplus.model.Employee;

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
	            int idEmployee = Integer.parseInt(dis.readUTF());
	            System.out.println("id de l'employee : "+idEmployee);
	            Employee employee = new Employee();
	            ArrayList<Client> arrayClient = employee.getAllClients(false, idEmployee);
	            employee.setAllClients(arrayClient);
	            
	            System.out.println("Elaboration de l'output");
	            
	            
	            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("C:\\Users\\asus\\git\\under\\AplusClient\\arrayclient.tmp"));
	            System.out.println("creation du fichier temp");
	            //sck.getOutputStream();
	            //DataOutputStream dos = new DataOutputStream(os) ;
	            //os.writeObject(employee);
	            System.out.println(employee.getAllClients(false, idEmployee).get(0).getLastName());

	            GsonBuilder builder = new GsonBuilder();
	            System.out.println("gson builder");
	            Gson gson = builder.create();
	            System.out.println("builder created");
	            String json = gson.toJson(employee);
	            System.out.println("convert to json done");
	            
	            System.out.println("jsoninzation done");
	            os.writeUTF(json);
	            System.out.println("writing done");
	            
	        }catch(IOException exc) {
	             Logger.global.log(Level.SEVERE,"serveur",exc);
	        }
		}
		
	}
	
	public static void main(String[] arg0) throws IOException, ClassNotFoundException, SQLException{
		AllClientExpose serveur = new AllClientExpose(3002);
		serveur.lauch();
	}
}
