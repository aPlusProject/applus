package applus;

import java.util.Scanner;

import Model.Client;

public class lauch {

	public static void main(String[] args) {
		
		int FEES = 400;
		
		Scanner s = new Scanner(System.in);
		
		Client client = new Client();
		
		System.out.println("Choisir le type de pret 1/immobiler  2/classique");
		int typePret = s.nextInt();
		
		System.out.println("Montant : ");
		int montant = s.nextInt();
		
		System.out.println("Duree du pret (en annee) : ");
		int duree = s.nextInt();
		int mensualite = client.simuler(typePret, montant, duree);
		
		double sommeTotal = montant * 1.025;  // + taux d'interet
		sommeTotal *= 1.00246;              // + taux d'assurance
		sommeTotal += FEES;
		
		
		System.out.println("Mensualite : "+mensualite +" euros pour un total de "+(int)sommeTotal+" euros");
		System.out.println("Frais de dossier : "+FEES);
		System.out.println("Pour un montant de "+montant+ " sur une duree de "+duree+" ans");

	}

}
