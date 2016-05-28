package edu.aplus.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.aplus.model.Loan;

public class ArrayIndicatorExpose {
	
	private ArrayList<Loan> listLoans;
	
	
	
	public String[][] getData() throws ClassNotFoundException, SQLException{
		
		Loan loan = new Loan();
		
		listLoans = loan.getLoansListForArrayIndicator();
		
		ArrayList<ArrayList<String>> loanArray = new ArrayList<ArrayList<String>>();
		for(int i = 0; i < listLoans.size(); i++) {
			ArrayList<String> aLoan =  new ArrayList<String>();
			aLoan.add(listLoans.get(i).getLoanTypeLibelle());
			aLoan.add(listLoans.get(i).getAskesAmount()+"");
			aLoan.add(listLoans.get(i).getAskedDuration()+"");
			aLoan.add(listLoans.get(i).getAskedRate()+"");
			aLoan.add(listLoans.get(i).getAskedDate()+"");
			aLoan.add(listLoans.get(i).getDecisionLibelle());
			
			loanArray.add(aLoan);
			
			
		}
		
		ArrayList<ArrayList<String>> finalLoanArray = new ArrayList<ArrayList<String>>();
		for(int i = 0; i < loanArray.size(); i++) {
			finalLoanArray.add(loanArray.get(i));
		}
		
		String[][] data = new String[finalLoanArray.size()][];
        int i = 0;
         for (List<String> next : finalLoanArray) {
        	 data[i++] = next.toArray(new String[next.size()]);
        }
		
		
		return data;
		
	}

}
