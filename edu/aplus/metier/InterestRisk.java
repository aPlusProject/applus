package edu.aplus.metier;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import edu.aplus.model.Client;
import edu.aplus.model.Rate;
import edu.aplus.metier.ChooseLoanType;
import edu.aplus.metier.SetProfileClient2;

/* This class named interestRisk allows to define the risks depending on the profile of the client
 * This assessment of the risks taken by the bank is made by six parameters:
 *  age : age of client
 *  salary : salary per month of client
 *  charge : what the client spends per month
 *  credit : the amount of credit he has to give to other banks if he's contracted credits
 *  status : the type of professional contract if the client works
 *  etatSante: to check if the client is healthy
 *  We will use this class for frameProfile in order to display the list of risks.
 */
public class InterestRisk {

	private String typeLoan;
	private Rate rate;
	SetProfileClient2 fp;
	private int salary;
	private String etatSante ;
	private String status ;
	private int charge;
	private int credit ;
	private int age ;


	//public interestRisk(int salary, String etatSante, String status, int credit, int age, int charge) {
		// setters
		

//	}


	public InterestRisk(int salary, String etatSante, String status, int credit, int age, int charge) {
		this.salary = SetProfileClient2.getSalary();
		this.etatSante = SetProfileClient2.getHealth();
		this.charge=  SetProfileClient2.getCharge();
		this.credit = SetProfileClient2.getCredit();
		this.age = SetProfileClient2.getAge();
		this.status = SetProfileClient2.getStatus();
		// TODO Auto-generated constructor stub
	}


	public String Risk() {


		/*String setRisk = "";
		int salary = Integer.parseInt(client.getSalary());
		int restantVivre = Integer.parseInt(client.getSalary())-Integer.parseInt(client.getCharge());
		int debtRatio = Integer.parseInt(client.getCharge())/Integer.parseInt(client.getSalary());
		int etatSante= 0;*/

		String setRisk = "";
		//int salary-charge = salary-charge;
		//int salary/(charge+credit)*100 = salary/(charge+credit)*100;

		// LOAN HOME
		// FIRST INDICATOR : SITUATION FINANCIERE
		// SECOND INDICATOR : 


		/* First will be the client who is under 25 years old & having salary under 24000euros, he's young
		 *  and probably student so bank counselor
		 * has to maintain him as a client at long term in the bank
		 */


		if ((age > 18 && age <= 25) && salary < 24000) { // CLIENT BETWEEN 18 N 25 HAVING UNDER 24000 OF SALARY
			if((charge+credit)/salary*100 >= 30 && (salary-charge) < 800)// debtRatio more than 30 & restantVivre under 800 euros
				setRisk = "Risques d'endettement"; // increase rate_interest otherwise loss of bank
			else if((charge+credit)/salary*100 < 30 && (salary-charge) < 800) //good debtRation but badRestantVivre
				switch(etatSante){ // look at Health state
				case "bon":// Good health
					setRisk= "Risques moindre d'endettement"; // Bank wont increase interest
					break;
				case "bad": // Sick person
					setRisk= "Risques d'endettement"; // Bank will increase
					break;
				}
			else if(salary/(charge+credit)*100 >= 30 && salary-charge >= 800) // bad DebtRatio & good RestantVivre
				setRisk= "Risques d'endettement"; // increase interest
			else
				setRisk= "Bonnes prévisions de marge"; //GOOD profile , decrease interest to maintain client

		}

		/* second will be client or prospect having salary between 24000 & 45000
		 * 
		 */


		else if ((age > 18 && age <= 25) && (salary >= 24000 && salary < 45000)) { // CLIENT BETWEEN 18 N 25 HAVING UNDER 24000 OF SALARY
			if(salary/(charge+credit)*100 >= 30 && salary-charge < 800) // debtRatio more than 30 & restantVivre under 800 euros
				setRisk = "Risques d'endettement"; // increase rate_interest otherwise loss of bank
			else if(salary/(charge+credit)*100 < 30 && salary-charge < 800) //good debtRation but badRestantVivre
				switch(etatSante){ // look at Health state
				case "bon":// Good health
					setRisk= "Risques moindre d'endettement"; // Bank wont increase interest
					break;
				case "bad": // Sick person
					setRisk= "Risques d'endettement"; // Bank will increase
					break;
				}
			else if(salary/(charge+credit)*100 >= 30 && salary-charge >= 800) // bad DebtRatio & good RestantVivre
				setRisk= "Risques d'endettement"; // increase interest
			else
				setRisk= "Bonnes prévisions de marge"; //GOOD profile , decrease interest to maintain client

		}

		/* I think that it's rare to find young people not older than 25 who earn more than 45k euros
		 * So for that branch, its finished
		 * 
		 * Now its gonna be client or prospect being between 25 & 50 years old;
		 */


		else if ((age > 25 && age <= 50) && (salary < 24000)) { // CLIENT BETWEEN 25 N 50 HAVING UNDER 24000 OF SALARY
			if(salary/(charge+credit)*100 >= 30 && salary-charge < 800) // bad debtRatio & restantVivre under 800euros
				setRisk = "Risques d'endettement"; // increase rate_interest otherwise loss of bank
			else if(salary/(charge+credit)*100 < 30 && salary-charge < 800) //good debtRatio but badRestantVivre
				switch(etatSante){ // look at Health state
				case "bon":// Good health
					setRisk= "Risques moindre d'endettement"; // Bank wont increase interest
					break;
				case "bad": // Sick person
					setRisk= "Risques d'endettement"; // Bank will increase
					break;
				}
			else if(salary/(charge+credit)*100 >= 30 && salary-charge >= 800) // bad DebtRatio & good RestantVivre
				setRisk= "Risques d'endettement"; // increase interest
			else
				setRisk= "Bonnes prévisions de marge"; //GOOD profile , decrease interest to maintain client

		}

		/* client 
		 * being between 25 & 50 and having good salary
		 */

		else if ((age > 25 && age <= 50) && (salary >= 24000) && (salary <= 45000)) { // CLIENT BETWEEN 25 N 50 HAVING UNDER 24000 OF SALARY
			if(salary/(charge+credit)*100 >= 30 && salary-charge < 800) // bad debtRatio & restantVivre under 800euros
				setRisk = "Risques d'endettement"; // increase rate_interest otherwise loss of bank
			else if(salary/(charge+credit)*100 < 30 && salary-charge < 800) //good debtRatio but badRestantVivre
				switch(etatSante){ // look at Health state
				case "bon":// Good health
					setRisk= "Risques moindre d'endettement"; // Bank wont increase interest
					break;
				case "bad": // Sick person
					setRisk= "Risques d'endettement"; // Bank will increase
					break;
				}
			else if(salary/(charge+credit)*100 >= 30 && salary-charge >= 800) // bad DebtRatio & good RestantVivre
				setRisk= "Risques d'endettement)"; // increase interest
			else
				setRisk= "Bonnes prévisions de marge financière"; //GOOD profile , decrease interest to maintain client

		}

		/* client being between 25 & 50
		 * having salary between 45 & 70k euros
		 */
		else if ((age > 25 && age <= 50) && (salary >= 45000) && (salary <= 70000)) { // CLIENT BETWEEN 25 N 50 HAVING UNDER 24000 OF SALARY
			if(salary/(charge+credit)*100 >= 30 && salary-charge < 800) // bad debtRatio & restantVivre under 800euros
				setRisk = "Grosses pertes de la banque"; // increase rate_interest otherwise loss of bank
			else if(salary/(charge+credit)*100 < 30 && salary-charge < 800) //good debtRatio but badRestantVivre
				switch(etatSante){ // look at Health state
				case "bon":// Good health
					setRisk= "La diminution du taux d'intérêt présente un risque à long terme"; // Bank wont increase interest
					break;
				case "bad": // Sick person
					setRisk= "Risque d'endettement"; // Bank will increase
					break;
				}
			else if(salary/(charge+credit)*100 >= 30 && salary-charge >= 800) // bad DebtRatio & good RestantVivre
				setRisk= "Risque d'endettement"; // increase interest
			else
				setRisk= "Bonnes prévisions, la diminution du taux d'intérêt n'influer pas sur la plus-value"; //GOOD profile , decrease interest to maintain client

		}
		/* client being between 25 & 50
		 * having salary > 70k euros
		 */
		else if ((age > 25 && age <= 50) && salary >= 70000) { // CLIENT BETWEEN 25 N 50 HAVING UNDER 24000 OF SALARY
			if(salary/(charge+credit)*100 >= 30 && salary-charge < 800) // bad debtRatio & restantVivre under 800euros
				setRisk = "Risque d'endettement, pertes de l'établissement à prévenir)"; // increase rate_interest otherwise loss of bank
			else if(salary/(charge+credit)*100 < 30 && salary-charge < 800) //good debtRatio but badRestantVivre
				switch(etatSante){ // look at Health state
				case "bon":// Good health
					setRisk= "(Le maintien du taux de la maison-mère permet de prévoir le risque d'endettement avant la terme du prêt)"; // Bank wont increase interest
					break;
				case "bad": // Sick person
					setRisk= "Risque d'endettement de la banque"; // Bank will increase
					break;
				}
			else if(salary/(charge+credit)*100 >= 30 && salary-charge >= 800) // bad DebtRatio & good RestantVivre
				setRisk= "Risque d'endettement de la banque"; // increase interest
			else
				setRisk= "Bonnes prévisions de marge"; //GOOD profile , decrease interest to maintain client

		}
		/* now (50,65)
		 * 
		 */

		else if ((age > 50 && age <= 65) && salary < 30000) { // CLIENT BETWEEN 25 N 50 HAVING UNDER 24000 OF SALARY
			if(salary/(charge+credit)*100 >= 30 && salary-charge < 800) // bad debtRatio & restantVivre under 800euros
				setRisk = "Risques d'endettement"; // increase rate_interest otherwise loss of bank
			else if(salary/(charge+credit)*100 < 30 && salary-charge < 800) //good debtRatio but badRestantVivre
				switch(etatSante){ // look at Health state
				case "bon":// Good health
					setRisk= "Risque moindre d'endettement"; // Bank wont increase interest
					break;
				case "bad": // Sick person
					setRisk= "Risques d'endettement"; // Bank will increase
					break;
				}
			else if(salary/(charge+credit)*100 >= 30 && salary-charge >= 800) // bad DebtRatio & good RestantVivre
				setRisk= "Risques d'endettement"; // increase interest
			else
				setRisk= "Bonnes prévisions de marge"; //GOOD profile , decrease interest to maintain client

		}
		// salary > 30000
		else if ((age > 50 && age <= 65) && salary >= 30000) { // CLIENT BETWEEN 25 N 50 HAVING UNDER 24000 OF SALARY
			if(salary/(charge+credit)*100 >= 30 && salary-charge < 800) // bad debtRatio & restantVivre under 800euros
				setRisk = "Risques d'endettement"; // increase rate_interest otherwise loss of bank
			else if(salary/(charge+credit)*100 < 30 && salary-charge < 800) //good debtRatio but badRestantVivre
				switch(etatSante){ // look at Health state
				case "bon":// Good health
					setRisk= "Risques moindres d'endettement"; // Bank wont increase interest
					break;
				case "bad": // Sick person
					setRisk= "Risques d'endettement"; // Bank will increase
					break;
				}
			else if(salary/(charge+credit)*100 >= 30 && salary-charge >= 800) // bad DebtRatio & good RestantVivre
				setRisk= "Risques d'endettement"; // increase interest
			else
				setRisk= "Bonnes prévisions de marge"; //GOOD profile , decrease interest to maintain client

		}

		else if (age >65) { // CLIENT in "retraite" 
			if(salary/(charge+credit)*100 >= 30 && salary-charge < 800) // bad debtRatio & restantVivre under 800euros
				setRisk = "Risques d'endettement"; // increase rate_interest otherwise loss of bank
			else if(salary/(charge+credit)*100 < 30 && salary-charge < 800) //good debtRatio but badRestantVivre
				switch(etatSante){ // look at Health state
				case "bon":// Good health
					setRisk= "Risques moindres d'endettement"; // Bank wont increase interest
					break;
				case "bad": // Sick person
					setRisk= "Risques d'endettement"; // Bank will increase
					break;
				}
			else if(salary/(charge+credit)*100 >= 30 && salary-charge >= 800) // bad DebtRatio & good RestantVivre
				setRisk= "Risques d'endettement"; // increase interest
			else
				setRisk= "Risques d'endettement"; //GOOD profile , decrease interest to maintain client


		} else{
			setRisk = "Cas non traité";
		}


		return setRisk;
	}

}