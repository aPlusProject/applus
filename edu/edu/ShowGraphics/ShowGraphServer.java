package edu.ShowGraphics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class ShowGraphServer extends Thread{

	protected static boolean serverContinue = true;
	protected Socket clientSocket;
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 ServerSocket serverSocket = null; 

		    try { 
		    	//create server socket object
		         serverSocket = new ServerSocket(10008); 
		         System.out.println ("Connection Socket Created");
		         try { 
		        	 //listen indefinitely until receive exit call or program terminates
		              while (serverContinue)
		                 {
		            	  //set time out and wait for client connection
		                  serverSocket.setSoTimeout(10000);
		                  System.out.println ("Waiting for Connection");
		                  try {
		                       new ShowGraphServer (serverSocket.accept()); 
		                      }
		                  catch (SocketTimeoutException ste)
		                      {
		                       System.out.println ("Timeout Occurred");
		                      }
		                 }
		             } 
		         catch (IOException e) 
		             { 
		              System.err.println("Accept failed."); 
		              System.exit(1); 
		             } 
		        } 
		    catch (IOException e) 
		        { 
		         System.err.println("Could not listen on port: 10008."); 
		         System.exit(1); 
		        } 
		    finally
		        {
		         try {
		              System.out.println ("Closing Server Connection Socket");
		              serverSocket.close(); 
		             }
		         catch (IOException e)
		             { 
		              System.err.println("Could not close port: 10008."); 
		              System.exit(1); 
		             } 
		        }
		    
		    
	}
	
	private ShowGraphServer (Socket clientSoc)

	   {
	    clientSocket = clientSoc;
	    start();
	   }
	
	public void run()
	   {
	    System.out.println ("New Communication Thread Started");

	    try { 
	         PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), 
	                                      true); 
	         BufferedReader in = new BufferedReader( 
	                 new InputStreamReader( clientSocket.getInputStream())); 

	         String inputLine; 

	         while ((inputLine = in.readLine()) != null) 
	             { 
	              System.out.println ("Server: " + inputLine); 

	              if (inputLine.equals("?")) 
	                  inputLine = new String ("\"Bye.\" ends Client, " +
	                      "\"End Server.\" ends Server");

	              out.println(inputLine); 

	              if (inputLine.equals("Bye.")) 
	                  break; 

	              if (inputLine.equals("End Server.")) 
	                  serverContinue = false; 
	             } 

	         out.close(); 
	         in.close(); 
	         clientSocket.close(); 
	        } 
	    catch (IOException e) 
	        { 
	         System.err.println("Problem with Communication Server");
	         System.exit(1); 
	        } 
	    }
}
