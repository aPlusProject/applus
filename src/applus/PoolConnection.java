package applus;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;
	
public class PoolConnection {
	
	private DataSource ds;
	private int AMOUNT = 10;
	private Connection co;
	private Connection[] tab = {null, null, null, null, null, null, null, null, null, null} ;
	
	
	public void makeStack() throws ClassNotFoundException{
		try {
			for(int i=0; i<AMOUNT; i++) {
				ds = DBConnector.createDataSource();
				co = ds.getConnection();
			    tab[i] = co;
			}

		} catch (SQLException ex) {
			
	    System.out.println("SQLException: " + ex.getMessage());
	    System.out.println("SQLState: " + ex.getSQLState());
	    System.out.println("VendorError: " + ex.getErrorCode());
		}

	}
	
	/**
	 * 
	 * @return a connection
	 */
   public Connection getConnection(){
	   co = null;
	   for(int j=0; j < AMOUNT; j++) {
		   if (tab[j] != null) {
			   co = tab[j];
			   tab[j] = null;
		   }
	   }
	   return co;	
    }
   
   /**
    * 
    * @return true if there is no connection in the pool
    */
   public boolean tabIsEmpty(){
	   int j = 0;
	   int x = 0;
	   while(j<AMOUNT){
		   if(tab[j] == null){
			   x++;
		   }
		   j++;
	   }
	   if(x==AMOUNT){
		   return true;
	   }
	   return false;
   }
   
   /**
    * 
    * @param co current connection
    * @return 1 if the connection is put in the pile else 0
    */
   public int closeConnection(Connection co){
	   int i = 0;
	   while(i<AMOUNT){
		   if(tab[i]==null){
			   tab[i]=co;
			   return 1;
	   	}
		   i++;
	   }
	   return 0;
   }
	   

}
