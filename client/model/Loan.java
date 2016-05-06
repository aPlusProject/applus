package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

public class Loan {
	
	private int id;
	private Client client;
	private Employee counsellor;
	private LoanType loanType;
	private History history;
	private int askedAmount;
	private Date askedDate;    //peut etre le mauvaise importe
	private int decision;  //documenter les valeurs  que peut prendre decision
	private DataSource ds;
	
	
	public Loan(Client client, Employee counsellor, LoanType loanType, History history, int askedAmount,
			Date askedDate, int decision) {
		this.client = client;
		this.counsellor = counsellor;
		this.loanType = loanType;
		this.history = history;
		this.askedAmount = askedAmount;
		this.askedDate = askedDate;
		this.decision = decision;
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



	public LoanType getLoanType() {
		return loanType;
	}



	public void setLoanType(LoanType loanType) {
		this.loanType = loanType;
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
	
	
	
		
	
}
