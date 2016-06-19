package edu.aplus.metier;
import edu.aplus.gui.SetProfileClient2;

public class Categories2 {

	private int revenu;
	private String etatSante ;
	private String status ;
	private int charge;
	private int credit ;
	private int age ;
	SetProfileClient2 profile;

	public Categories2(int revenu,String status,int credit,int age,int charge){
		this.revenu = revenu;
		this.etatSante = etatSante;
		this.status = status;
		this.credit = credit;
		this.age = age;
		this.charge=  charge;
	}

	public boolean ExcellentMediumProfile(){ // They are excellent client and have good revenues
		float debtRatio =(float) (charge+credit)/revenu*100;
		if(debtRatio <= 30 && (revenu-charge) > 1200){
			if(age >= 30 && age < 60) {
				if(status == "CDI" ){
					if(profile.goodHealthSelected() || profile.badHealthSelected()){
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

	public boolean ExcellentJuniorProfile(){ // They are excellent client and have good revenus and marges
		float debtRatio =(float) (charge+credit)/revenu*100;
		if(debtRatio <= 30 && (revenu-charge) > 800){
			if(age >= 18 && age <= 30) {
				if(status == "CDI" ){
					if(profile.goodHealthSelected() || profile.badHealthSelected()){
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
			if(age > 60) {
				if(status == "CDI" ){
					if(profile.goodHealthSelected()){
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
	
	public boolean VeryGoodJuniorProfile(){

		float debtRatio =(float) (charge+credit)/revenu*100;
		if(debtRatio <= 30 && (revenu-charge) > 800){
			if(age >= 18 && age < 30) {
				if(status == "CDD" ){
					if(profile.goodHealthSelected() || profile.badHealthSelected()){
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
		if(debtRatio <= 30 && (revenu-charge) > 1200){
			if(age >=30 && age < 60) {
				if(status == "CDD" ){
					if(profile.goodHealthSelected() || profile.badHealthSelected()){
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
		if(debtRatio <= 30 && (revenu-charge) > 800){
			if(age > 60) {
				if(status == "CDD" ){
					if(profile.goodHealthSelected()){
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

	
	public boolean GoodJuniorProfile(){ // They sometimes not have wives and kids 

		float debtRatio =(float) (charge+credit)/revenu*100;
		if(debtRatio <= 30 && ((revenu-charge) > 500 && (revenu-charge) <= 800)){
			if(age >= 18 && age < 30) {
				if(status == "CDD" || status == "Autoentrepreneur"){
					if(profile.goodHealthSelected()){
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
		if(debtRatio <= 30 && ((revenu-charge) > 800 && (revenu-charge) <= 1200)){
			if(age >=30 && age < 60) {
				if(status == "CDD" || status == "Autoentrepreneur" ){
					if(profile.goodHealthSelected()){
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
		if(debtRatio <= 30 && ((revenu-charge) > 500 && (revenu-charge) < 800)){
			if(age > 60) {
				if(status == "CDD" || status == "Autoentrepreneur" ){
					if(profile.goodHealthSelected()){
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

	
	public boolean BadJuniorProfile(){ // They sometimes not have wives and kids 

		float debtRatio =(float) (charge+credit)/revenu*100;
		if(debtRatio <= 30 && (revenu-charge) < 500){
			if(age >= 18 && age < 30) {
				if(status == "CDD" || status == "Autoentrepreneur" || status =="CDI"){
					if(profile.goodHealthSelected()){
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
		if(debtRatio <= 30 && (revenu-charge) < 800 ){
			if(age >=30 && age < 60) {
				if(status == "CDD" || status == "Autoentrepreneur" || status == "CDI"){
					if(profile.goodHealthSelected()){
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
		if(debtRatio <= 30 && (revenu-charge) < 500){
			if(age > 60) {
				if(status == "CDD" || status == "Autoentrepreneur" || status =="CDI" ){
					if(profile.goodHealthSelected()){
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