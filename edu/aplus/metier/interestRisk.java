package edu.aplus.metier;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import edu.aplus.model.Client;
import edu.aplus.model.Rate;
import edu.aplus.metier.ChooseLoanType;
import edu.aplus.metier.CalculateRate;

public class interestRisk {

	private String typeLoan;
	private Rate rate;
	private Client client;

	 
	public interestRisk(int salary, int restantVivre, int debtRatio, int etatSant) {
		// setters
	}

	/**
	 * This method is used to show the risks according the different parameters
	 * 
	 * @param typeLoan
	 * 
	 * @return str
	 * str = list of the risks
	 */
	public String Risk() {

		String setRisk = "";
		int salary = Integer.parseInt(client.getSalary());
		int restantVivre = Integer.parseInt(client.getSalary())-Integer.parseInt(client.getCharge());
		int debtRatio = Integer.parseInt(client.getCharge())/Integer.parseInt(client.getSalary());
		int etatSante= 0;

		// LOAN HOME
		// FIRST INDICATOR : SITUATION FINANCIERE
		// SECOND INDICATOR : 


		/* First will be the client who is under 25 years old & having salary under 24000euros, he's young
		 *  and probably student so bank counselor
		 * has to maintain him as a client at long term in the bank
		 */


		if ((client.getAge() > 18 && client.getAge() <= 25) && salary < 24000) { // CLIENT BETWEEN 18 N 25 HAVING UNDER 24000 OF SALARY
			if(debtRatio >= 30 && restantVivre < 800) // debtRatio more than 30 & restantVivre under 800 euros
				setRisk = "(Liste des risques ici)"; // increase rate_interest otherwise loss of bank
			else if(debtRatio < 30 && restantVivre < 800) //good debtRation but badRestantVivre
				switch(etatSante){ // look at Health state
				case 0:// Good health
					setRisk= "(Liste risques)"; // Bank wont increase interest
					break;
				case 1: // Sick person
					setRisk= "(Liste risques)"; // Bank will increase
					break;
				}
			else if(debtRatio >= 30 && restantVivre >= 800) // bad DebtRatio & good RestantVivre
				setRisk= "(Liste risques)"; // increase interest
			else
				setRisk= "(Liste risques)"; //GOOD profile , decrease interest to maintain client

		}

		/* second will be client or prospect having salary between 24000 & 45000
		 * 
		 */


		else if ((client.getAge() > 18 && client.getAge() <= 25) && (salary >= 24000 && salary < 45000)) { // CLIENT BETWEEN 18 N 25 HAVING UNDER 24000 OF SALARY
			if(debtRatio >= 30 && restantVivre < 800) // debtRatio more than 30 & restantVivre under 800 euros
				setRisk = "(Liste des risques ici)"; // increase rate_interest otherwise loss of bank
			else if(debtRatio < 30 && restantVivre < 800) //good debtRation but badRestantVivre
				switch(etatSante){ // look at Health state
				case 0:// Good health
					setRisk= "(Liste risques)"; // Bank wont increase interest
					break;
				case 1: // Sick person
					setRisk= "(Liste risques)"; // Bank will increase
					break;
				}
			else if(debtRatio >= 30 && restantVivre >= 800) // bad DebtRatio & good RestantVivre
				setRisk= "(Liste risques)"; // increase interest
			else
				setRisk= "(Liste risques)"; //GOOD profile , decrease interest to maintain client

		}

		/* I think that it's rare to find young people not older than 25 who earn more than 45k euros
		 * So for that branch, its finished
		 * 
		 * Now its gonna be client or prospect being between 25 & 50 years old;
		 */


		else if ((client.getAge() > 25 && client.getAge() <= 50) && (salary < 24000)) { // CLIENT BETWEEN 25 N 50 HAVING UNDER 24000 OF SALARY
			if(debtRatio >= 30 && restantVivre < 800) // bad debtRatio & restantVivre under 800euros
				setRisk = "(Liste des risques ici)"; // increase rate_interest otherwise loss of bank
			else if(debtRatio < 30 && restantVivre < 800) //good debtRatio but badRestantVivre
				switch(etatSante){ // look at Health state
				case 0:// Good health
					setRisk= "(Liste risques)"; // Bank wont increase interest
					break;
				case 1: // Sick person
					setRisk= "(Liste risques)"; // Bank will increase
					break;
				}
			else if(debtRatio >= 30 && restantVivre >= 800) // bad DebtRatio & good RestantVivre
				setRisk= "(Liste risques)"; // increase interest
			else
				setRisk= "(Liste risques)"; //GOOD profile , decrease interest to maintain client

		}

		/* client 
		 * being between 25 & 50 and having good salary
		 */

		else if ((client.getAge() > 25 && client.getAge() <= 50) && (salary >= 24000) && (salary <= 45000)) { // CLIENT BETWEEN 25 N 50 HAVING UNDER 24000 OF SALARY
			if(debtRatio >= 30 && restantVivre < 800) // bad debtRatio & restantVivre under 800euros
				setRisk = "(Liste des risques ici)"; // increase rate_interest otherwise loss of bank
			else if(debtRatio < 30 && restantVivre < 800) //good debtRatio but badRestantVivre
				switch(etatSante){ // look at Health state
				case 0:// Good health
					setRisk= "(Liste risques)"; // Bank wont increase interest
					break;
				case 1: // Sick person
					setRisk= "(Liste risques)"; // Bank will increase
					break;
				}
			else if(debtRatio >= 30 && restantVivre >= 800) // bad DebtRatio & good RestantVivre
				setRisk= "(Liste risques)"; // increase interest
			else
				setRisk= "(Liste risques)"; //GOOD profile , decrease interest to maintain client

		}

		/* client being between 25 & 50
		 * having salary between 45 & 70k euros
		 */
		else if ((client.getAge() > 25 && client.getAge() <= 50) && (salary >= 45000) && (salary <= 70000)) { // CLIENT BETWEEN 25 N 50 HAVING UNDER 24000 OF SALARY
			if(debtRatio >= 30 && restantVivre < 800) // bad debtRatio & restantVivre under 800euros
				setRisk = "(Liste des risques ici)"; // increase rate_interest otherwise loss of bank
			else if(debtRatio < 30 && restantVivre < 800) //good debtRatio but badRestantVivre
				switch(etatSante){ // look at Health state
				case 0:// Good health
					setRisk= "(Liste risques)"; // Bank wont increase interest
					break;
				case 1: // Sick person
					setRisk= "(Liste risques)"; // Bank will increase
					break;
				}
			else if(debtRatio >= 30 && restantVivre >= 800) // bad DebtRatio & good RestantVivre
				setRisk= "(Liste risques)"; // increase interest
			else
				setRisk= "(Liste risques)"; //GOOD profile , decrease interest to maintain client

		}
		/* client being between 25 & 50
		 * having salary > 70k euros
		 */
		else if ((client.getAge() > 25 && client.getAge() <= 50) && salary >= 70000) { // CLIENT BETWEEN 25 N 50 HAVING UNDER 24000 OF SALARY
			if(debtRatio >= 30 && restantVivre < 800) // bad debtRatio & restantVivre under 800euros
				setRisk = "(Liste des risques ici)"; // increase rate_interest otherwise loss of bank
			else if(debtRatio < 30 && restantVivre < 800) //good debtRatio but badRestantVivre
				switch(etatSante){ // look at Health state
				case 0:// Good health
					setRisk= "(Liste risques)"; // Bank wont increase interest
					break;
				case 1: // Sick person
					setRisk= "(Liste risques)"; // Bank will increase
					break;
				}
			else if(debtRatio >= 30 && restantVivre >= 800) // bad DebtRatio & good RestantVivre
				setRisk= "(Liste risques)"; // increase interest
			else
				setRisk= "(Liste risques)"; //GOOD profile , decrease interest to maintain client

		}
		/* now (50,65)
		 * 
		 */

		else if ((client.getAge() > 50 && client.getAge() <= 65) && salary < 30000) { // CLIENT BETWEEN 25 N 50 HAVING UNDER 24000 OF SALARY
			if(debtRatio >= 30 && restantVivre < 800) // bad debtRatio & restantVivre under 800euros
				setRisk = "(Liste des risques ici)"; // increase rate_interest otherwise loss of bank
			else if(debtRatio < 30 && restantVivre < 800) //good debtRatio but badRestantVivre
				switch(etatSante){ // look at Health state
				case 0:// Good health
					setRisk= "(Liste risques)"; // Bank wont increase interest
					break;
				case 1: // Sick person
					setRisk= "(Liste risques)"; // Bank will increase
					break;
				}
			else if(debtRatio >= 30 && restantVivre >= 800) // bad DebtRatio & good RestantVivre
				setRisk= "(Liste risques)"; // increase interest
			else
				setRisk= "(Liste risques)"; //GOOD profile , decrease interest to maintain client

		}
		// salary > 30000
		else if ((client.getAge() > 50 && client.getAge() <= 65) && salary >= 30000) { // CLIENT BETWEEN 25 N 50 HAVING UNDER 24000 OF SALARY
			if(debtRatio >= 30 && restantVivre < 800) // bad debtRatio & restantVivre under 800euros
				setRisk = "(Liste des risques ici)"; // increase rate_interest otherwise loss of bank
			else if(debtRatio < 30 && restantVivre < 800) //good debtRatio but badRestantVivre
				switch(etatSante){ // look at Health state
				case 0:// Good health
					setRisk= "(Liste risques)"; // Bank wont increase interest
					break;
				case 1: // Sick person
					setRisk= "(Liste risques)"; // Bank will increase
					break;
				}
			else if(debtRatio >= 30 && restantVivre >= 800) // bad DebtRatio & good RestantVivre
				setRisk= "(Liste risques)"; // increase interest
			else
				setRisk= "(Liste risques)"; //GOOD profile , decrease interest to maintain client

		}

		else if (client.getAge() >65) { // CLIENT in "retraite" 
			if(debtRatio >= 30 && restantVivre < 800) // bad debtRatio & restantVivre under 800euros
				setRisk = "(Liste des risques ici)"; // increase rate_interest otherwise loss of bank
			else if(debtRatio < 30 && restantVivre < 800) //good debtRatio but badRestantVivre
				switch(etatSante){ // look at Health state
				case 0:// Good health
					setRisk= "(Liste risques)"; // Bank wont increase interest
					break;
				case 1: // Sick person
					setRisk= "(Liste risques)"; // Bank will increase
					break;
				}
			else if(debtRatio >= 30 && restantVivre >= 800) // bad DebtRatio & good RestantVivre
				setRisk= "(Liste risques)"; // increase interest
			else
				setRisk= "(Liste risques)"; //GOOD profile , decrease interest to maintain client


		} else{
			setRisk = "Profil non définie";
		}


		return setRisk;
	}

}