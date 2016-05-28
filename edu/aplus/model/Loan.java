package edu.aplus.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import edu.aplus.db.ConnectionPool;
import edu.aplus.model.Client;
import edu.aplus.model.Employee;
import edu.aplus.model.History;

public class Loan {

	private int id;
	private Client client;
	private Employee counsellor;
	private static String loanType;
	private History history;
	private int askedAmount;
	private int askedDuration; //durÃ©e en annÃ©e
	private float askedRate; //taux d'intÃªret
	private float askedRateInsurance; //taux d'assurance
	private Date askedDate;    //peut etre le mauvaise importe
	private int decision;  //documenter les valeurs  que peut prendre decision
	private DataSource ds;
	
	
	private String decisionLibelle;
	private String loanTypeLibelle;

	public Loan(Client client, Employee counsellor, String loanType, History history, int askedAmount, 
			int askedDuration, float askedRate, float askedRateInsurance, Date askedDate, int decision) {
		this.client = client;
		this.counsellor = counsellor;
		this.loanType = loanType;
		this.history = history;
		this.askedAmount = askedAmount;
		this.askedDuration = askedDuration;
		this.askedRate = askedRate;
		this.askedRateInsurance = askedRateInsurance;
		this.askedDate = askedDate;
		this.decision = decision;
	}



	public Loan() {
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public Client getClient() {
		return client;
	}



	public void setClient(Client client) {
		this.client = client;
	}



	public Employee getCounsellor() {
		return counsellor;
	}



	public void setCounsellor(Employee counsellor) {
		this.counsellor = counsellor;
	}



	public static String getLoanTypeName(int idTypeLoan) throws ClassNotFoundException, SQLException {

		ConnectionPool pool = new ConnectionPool();
		pool.makeStack();
		Connection co = pool.getConnection();

		PreparedStatement ps;
		ResultSet rs;

		String sql = "SELECT LOAN_NAME FROM LOAN_TYPE WHERE ID_LOAN_TYPE = ?";
		String loanName = "";
		ps = co.prepareStatement(sql);
		ps.setInt(1, idTypeLoan);
		rs = ps.executeQuery();
		while(rs.next()) {
			loanName = rs.getString(1);
		}



		return loanName;
	}
	
	public ArrayList<Loan> getLoansListForArrayIndicator() throws ClassNotFoundException, SQLException {
		
		
		ConnectionPool pool = new ConnectionPool();
		pool.makeStack();
		Connection co = pool.getConnection();
		
		
		PreparedStatement ps;
		ResultSet rs;

		ArrayList<Loan> listLoans = new ArrayList<Loan>();
		
		String sql = "SELECT id_loan_type, asked_amount, asked_duration, asked_rate,  asked_date, decision FROM LOAN";
		ps = co.prepareStatement(sql);
		rs = ps.executeQuery();
		
		
		Loan aLoan = null;
		
		rs = ps.executeQuery();
		while(rs.next()) {
			
			aLoan = new Loan();
			
			aLoan.setLoanTypeLibelle(rs.getInt(1));
			aLoan.setAskedAmount(rs.getInt(2));
			aLoan.setAskedDuration(rs.getInt(3));
			aLoan.setAskedRate(rs.getLong(4));
			aLoan.setAskedDate(rs.getDate(5));
			aLoan.setDecisionLibelle(rs.getInt(6));
			
			
			listLoans.add(aLoan);
			
			
		}
		
		
		
		
		return listLoans;
		
		
		
		
	}



	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}


	public void setLoanTypeLibelle(int idTypeLoan) {
		
		
		if(idTypeLoan == 1) {
			loanTypeLibelle = "immobilier";
		}
		else if(idTypeLoan == 2) {
			loanTypeLibelle = "consommation";
		}
		else if(idTypeLoan == 3) {
			loanTypeLibelle = "professionnel";
		}
		else {
			loanTypeLibelle = "autre";
		}
		
		
	}
	
	public String getLoanTypeLibelle() {
		
		return loanTypeLibelle;
	}
	
	public void setDecisionLibelle(int idDecision) {
		
		if(idDecision == 0) {
			decisionLibelle = "accordé";
		}
		else if(idDecision == 1) {
			decisionLibelle = "refusé";
		}
		else if(idDecision == 2) {
			decisionLibelle = "en cours";
		}
		else {
			decisionLibelle = "refusé";
		}
		
	}
	
	public String getDecisionLibelle() {
		return decisionLibelle;
	}
	

	public History getHistory() {
		return history;
	}



	public void setHistory(History history) {
		this.history = history;
	}



	public int getAskesAmount() {
		return askedAmount;
	}



	public void setAskedAmount(int askedAmount) {
		this.askedAmount = askedAmount;
	}

	public int getAskedDuration() {
		return askedDuration;
	}

	public float getAskedRate() {
		return askedRate;
	}

	public float getAskedRateInsurance() {
		return askedRateInsurance;
	}

	public void setAskedDuration(int askedDuration){
		this.askedDuration = askedDuration;
	}

	public void setAskedRate(float askedRate){
		this.askedRate = askedRate;
	}

	public void setAskedRateInsurance(float askedRateInsurance){
		this.askedRateInsurance = askedRateInsurance;
	}

	public Date getAskedDate() {
		return askedDate;
	}



	public void setAskedDate(Date askedDate) {
		this.askedDate = askedDate;
	}



	public int getDecision() {
		return decision;
	}



	public void setDecision(int decision) {
		this.decision = decision;
	}

	public int getFileFees() {
		//TODO: algo pour determiner le frais de dossier en fonction du pret
		return 0;
	}

	public static void displayLoans(Connection co) throws SQLException {
		String sql = "Select * FROM LOAN";
		PreparedStatement ps = co.prepareStatement(sql);

		ResultSet rs = ps.executeQuery();
		System.out.println("ID LOAN | ASKED AMOUNT | ASKED DATE");
		while(rs.next()) {
			int montant = rs.getInt("asked_amount");
			Date date = rs.getDate("asked_date");
			int idLoan = rs.getInt("id_loan");
			System.out.println(idLoan+"       | "+montant+"        | "+date);

		}
		
		
		
		
		
	}
	
	
	public static void  main(String[] arg0) throws ClassNotFoundException, SQLException {
		
		Loan instance = new Loan();
		
		ArrayList<Loan> list = instance.getLoansListForArrayIndicator();
		
		
		System.out.println("size of the list from table Loan : "+list.size());
	}





}