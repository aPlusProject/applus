package connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.sql.DataSource;

import edu.model.Employee;


public class lauch {
	
	private static Employee employee;
	
	private static Connection co;
	private static PreparedStatement ps;
	private static Statement stmt;
	private static ResultSet rs;
	private static String query;
	private static DataSource ds;

	public static int simuler(int typePret, int montantPret, int dureePret) {
		
		
		try {
			
			ds = DBConnector.createDataSource();
			co = ds.getConnection();
			query = "INSERT INTO SIMULATION VALUES ('',1,1,?,?,0)";
			ps = co.prepareStatement(query);
			
			ps.setInt(1, typePret);
			ps.setInt(2, montantPret);
			ps.executeQuery();
			
			}catch (Exception ex) {
            ex.printStackTrace();
        }
		
		
		
		
		System.out.println("Calcul en cours...");
		System.out.println("Resultat : \n");
		
		typePret = 0;
		int mensualite = 0;
		double TAUX_INTERET = 1.025;
		int FEES = 400;
		double TAUX_ASSURANCE = 1.00246;
		int nbMois = dureePret * 12;  //calcule le nombre de mois total
		
		
		double sommeTotal = 0;
		sommeTotal = montantPret * TAUX_INTERET;  // + taux d'interet
		sommeTotal*= TAUX_ASSURANCE;              // + taux d'assurance
		sommeTotal += FEES;                       // + frais de dossier
		sommeTotal /= nbMois;                     //  calcule de la mensualite
//		sommeTotal /= 100;
		
		mensualite =  (int) sommeTotal;
		
		
		return mensualite;
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		int FEES = 400;
		double TAUX_INTERET = 1.025;
		double TAUX_ASSURANCE = 1.00246;
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Choisir le type de pret 1/immobiler  2/classique");
		int typePret = s.nextInt();
		
		System.out.println("Montant : ");
		int montant = s.nextInt();
		
		System.out.println("Duree du pret (en annee) : ");
		int duree = s.nextInt();
		int mensualite = simuler(typePret, montant, duree);
		
		double sommeTotal = montant * TAUX_INTERET;  // + taux d'interet
		sommeTotal *= TAUX_ASSURANCE;              // + taux d'assurance
		sommeTotal += FEES;
		
		
		System.out.println("Mensualite : "+mensualite +" euros sur une duree de "+duree+" ans pour un total de "+(int)sommeTotal+" euros");
		System.out.println("Frais de dossier : "+FEES+" | Taux d'interet : "+((TAUX_INTERET - 1)*100)+"% |Taux d'assurance : "+((TAUX_ASSURANCE-1)*100)+" %");
		System.out.println("Une demande de : "+montant+ " euros");

	}

}
