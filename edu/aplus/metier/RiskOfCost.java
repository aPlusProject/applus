package edu.aplus.metier;

import java.awt.ItemSelectable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import edu.aplus.model.Client;
import edu.aplus.db.ConnectionPool;
import edu.aplus.metier.ChooseLoanType;


public class RiskOfCost extends JFrame {

	/* Cette classe permet de définir le niveau de risque. Ce niveau est défini à partir de l'age et du ration salaire/charge */





	ChooseLoanType clt;
	Client client;
	private float debtRatio;


	public RiskOfCost (){

		setBounds(100, 100, 600, 400);
		setTitle ("Niveau de risque");
		getContentPane().setLayout(null);
		JLabel choose = new JLabel("Veuillez choisir le type de prêt: ");
		choose.setBounds(145,150,200,22);
		getContentPane().add(choose);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		debtRatio = Integer.parseInt(client.getSalary())/Integer.parseInt(client.getCharge());

		//1ere tranche: de 18 à 50 ans

		if (client.getAge() >= 18 && client.getAge() < 50){

			


		}
		//2eme tranche: de 50 à 70 ans

		if (client.getAge() >= 50 && client.getAge() < 70){




		}
		//3eme tranche: > 70ans

		if (client.getAge() >= 70){




		}



		ConnectionPool conn = new ConnectionPool();
		try {
			conn.makeStack();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//Connection connexion = conn.getConnection();

		try {
			ResultSet rs;
			PreparedStatement ps ;
			Connection co = conn.getConnection();
			String query = "UPDATE LOAN_TYPE SET RATE = ? WHERE LOAN_NAME = ?";
			System.out.println(query);
			ps = co.prepareStatement(query);

			//ps.setString(1, champ.getText());
			//ps.executeUpdate();
			rs = ps.executeQuery();



		} catch (SQLException e) {
			e.printStackTrace();
		}
		PreparedStatement ps;



	}


	
}