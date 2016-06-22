package edu.aplus.metier;
import edu.aplus.gui.SetProfileClient2;

/* This class is useful for the calculation of the rate
 * By separating on categories, we can classify the client depending on his profile
 * And then we will have the good rate for the bank not to lose money
 * Those categories depend on some parameters like
 * (salary, age, charge, credit, etc...)
 * The calculation made are: debtRatio and the current amount of money that the client has after putting out the charges
 * It's divided by 3 age group :
 * 1: The junior : between 18 and 30 : they are student or have just started working, the maximum of them don't have kids yet 
 * 2 : The medium : between 30 and 60 : they are workers and likely to have charges because they mostly have family to food, cars,home etc.
 * 3 : The senior : older than 60 : they are not far from the retirement. The lend may be risked because their health is more risky
 */

public class Categories2 {

	private int revenu;
	private String status ;
	private int charge;
	private int credit ;
	private int age ;
	SetProfileClient2 SetProfileClient2;
	boolean goodHealth = edu.aplus.gui.SetProfileClient2.goodHealthSelected();
	boolean badHealth = edu.aplus.gui.SetProfileClient2.badHealthSelected();


	public Categories2(int revenu,String status,int credit,int age,int charge){
		this.revenu = revenu;
		this.status = status;
		this.credit = credit;
		this.age = age;
		this.charge=  charge;
	}
	
	/* Excellent profiles:
	 */
	public boolean ExcellentJuniorProfile(){ // They are excellent client and have good revenus and marges
		float debtRatio =(float) (charge+credit)/revenu*100;
		if(debtRatio <= 30 && (revenu-charge) > 800){
			if(age >= 18 && age <= 30) {
				if(status == "CDI" ){
					if(goodHealth && badHealth){
						System.out.println("cat nok ");
						return true;
					}
					return true;
				}
				return true;
			} 
			return true;
		}
		return false;
	}

	public boolean ExcellentMediumProfile(){ // They are excellent client and have good revenues
		float debtRatio =(float) (charge+credit)/revenu*100;
		if(debtRatio <= 30 && (revenu-charge) > 1200){
			if(age >= 30 && age < 55) {
				if(status == "CDI" ){
					if(goodHealth || badHealth){
						System.out.println("cat nok ");
						return true;
					}
					return true;
				}
				return true;
			} 
			return true;
		}
		return false;

	}

	public boolean ExcellentSeniorProfile(){ // They have no more kids to food so less charges ...

		float debtRatio =(float) (charge+credit)/revenu*100;
		if(debtRatio <= 30 && (revenu-charge) > 800){
			if(age > 55) {
				if(status == "CDI" ){
					if(goodHealth){
						System.out.println("AGER");
						return true;
					}
					return true;
				}
				return true;
			}
			return true;
		}
		return false;
	}
	/* **************************************************** */

	/* Very good profile : rate is decreased to 0,05 */
	public boolean VeryGoodJuniorProfile(){

		float debtRatio =(float) (charge+credit)/revenu*100;
		if(debtRatio <= 30 && ((revenu-charge) >= 600 && (revenu-charge) < 800)){
			if(age >= 18 && age < 30) {
				if(status == "CDD" ){
					if(goodHealth || badHealth){
						System.out.println("AGER");
						return true;
					}
					return true;
				}
				return true;
			}
			return true;
		}
		return false;
	}

	public boolean VeryGoodMediumProfile(){

		float debtRatio =(float) (charge+credit)/revenu*100;
		if(debtRatio <= 30 && ((revenu-charge) >= 800 && (revenu-charge) < 1200)){
			if(age >=30 && age < 55) {
				if(status == "CDD" ){
					if(goodHealth || badHealth){
						System.out.println("AGER");
						return true;
					}
					return true;
				}
				return true;
			}
			return true;
		}
		return false;
	}

	public boolean VeryGoodSeniorProfile(){

		float debtRatio =(float) (charge+credit)/revenu*100;
		if(debtRatio <= 30 && ((revenu-charge) >= 600 && (revenu-charge) < 800)){
			if(age > 55) {
				if(status == "CDD" ){
					if(goodHealth){
						System.out.println("AGER");
						return true;
					}
					return true;
				}
				return true;
			}
			return true;
		}
		return false;
	}

	/* **************************************************** */

	/* Good profile : rate won't change */
	public boolean GoodJuniorProfile(){ // They sometimes not have wives and kids 

		float debtRatio =(float) (charge+credit)/revenu*100;
		if(debtRatio > 30 && (revenu-charge) > 600){
			if(age >= 18 && age < 30) {
				if(status == "CDI"){
					if(goodHealth){
						System.out.println("AGER");
						return true;
					}
					return true;
				}
				return true;
			}
			return true;
		}
		return false;
	}

	public boolean GoodMediumProfile(){ // They have lot of charges, cant take risk

		float debtRatio =(float) (charge+credit)/revenu*100;
		if(debtRatio > 30 && (revenu-charge) > 800){
			if(age >=30 && age < 55) {
				if(status == "CDI"){
					if(goodHealth){
						System.out.println("AGER");
						return true;
					}
					return true;
				}
				return true;
			}
			return true;
		}
		return false;
	}

	public boolean GoodSeniorProfile(){

		float debtRatio =(float) (charge+credit)/revenu*100;
		if(debtRatio > 30 && (revenu-charge) > 600){
			if(age > 55) {
				if(status == "CDI" ){
					if(goodHealth){
						System.out.println("AGER");
						return true;
					}
					return true;
				}
				return true;
			}
			return true;
		}
		return false;
	}

	/* **************************************************** */
	/* Rate will increase to 0,05 */

	public boolean BadJuniorProfile(){ // They sometimes not have wives and kids 

		float debtRatio =(float) (charge+credit)/revenu*100;
		if(debtRatio > 30 && (revenu-charge) >= 600){
			if(age >= 18 && age < 30) {
				if(status == "CDD" || status == "Autoentrepreneur"){
					if(goodHealth){
						System.out.println("AGER");
						return true;
					}
					return true;
				}
				return true;
			}
			return true;
		}
		return false;
	}

	public boolean BadMediumProfile(){ // They have lot of charges, cant take risk

		float debtRatio =(float) (charge+credit)/revenu*100;
		if(debtRatio > 30 && (revenu-charge) >= 800 ){
			if(age >=30 && age < 55) {
				if(status == "CDD" || status == "Autoentrepreneur"){
					if(goodHealth){
						System.out.println("AGER");
						return true;
					}
					return true;
				}
				return true;
			}
			return true;
		}
		return false;
	}

	public boolean BadSeniorProfile(){

		float debtRatio =(float) (charge+credit)/revenu*100;
		if(debtRatio > 30 && (revenu-charge) >= 600){
			if(age > 55) {
				if(status == "CDD" || status == "Autoentrepreneur"){
					if(goodHealth){
						System.out.println("AGER");
						return true;
					}
					return true;
				}
				return true;
			}
			return true;
		}
		return false;
	}
	/* *********************************** */
	/* VeryBad profile increase rate to 0,1 */
	
	public boolean VeryBadJuniorProfile(){ // They sometimes not have wives and kids 

		float debtRatio =(float) (charge+credit)/revenu*100;
		if(debtRatio > 30 && (revenu-charge) < 600){
			if(age >= 18 && age < 30) {
				if(status == "CDD" || status == "Autoentrepreneur"|| status == "CDI"){
					if(goodHealth){
						System.out.println("AGER");
						return true;
					}
					return true;
				}
				return true;
			}
			return true;
		}
		return false;
	}

	public boolean VeryBadMediumProfile(){ // They have lot of charges, cant take risk

		float debtRatio =(float) (charge+credit)/revenu*100;
		if(debtRatio > 30 && (revenu-charge) < 800 ){
			if(age >=30 && age < 55) {
				if(status == "CDD" || status == "Autoentrepreneur"|| status == "CDI"){
					if(goodHealth){
						System.out.println("AGER");
						return true;
					}
					return true;
				}
				return true;
			}
			return true;
		}
		return false;
	}

	public boolean VeryBadSeniorProfile(){

		float debtRatio =(float) (charge+credit)/revenu*100;
		if(debtRatio > 30 && (revenu-charge) < 600){
			if(age > 55) {
				if(status == "CDD" || status == "Autoentrepreneur"|| status == "CDI"){
					if(goodHealth){
						System.out.println("AGER");
						return true;
					}
					return true;
				}
				return true;
			}
			return true;
		}
		return false;
	}
}