package edu.aplus.metier;

import edu.aplus.gui.SearchRatePanel2;
import edu.aplus.gui.SetProfileClient2;
import edu.aplus.model.Rate;

public class EvaluateRisk2 {

	private int revenu;
	private String etatSante ;
	private String status ;
	private int charge;
	private int credit ;
	private int age ;
	SearchRatePanel2 srp2;
	SetProfileClient2 spc2;
	Rate rateClass;

	public EvaluateRisk2 (int revenu,String status, int credit,int age, int charge){
		this.revenu = SetProfileClient2.getSalary();
		this.etatSante = SetProfileClient2.getHealth();
		this.status = SetProfileClient2.getStatus();
		this.credit = SetProfileClient2.getCredit();
		this.age = SetProfileClient2.getAge();
		this.charge=  SetProfileClient2.getCharge();

	}


	public String Risk(double rate) {
		String show = null;
		Categories2 categories = new Categories2(revenu,status,credit,age, charge) ;
		float debtRatio =(float) (charge+credit)/revenu*100;
		int restantAVivre = revenu - charge;
		

		if (categories.ExcellentJuniorProfile() || categories.ExcellentMediumProfile() || categories.ExcellentSeniorProfile()) {
			show = "Taux référentiel de la maison-mère:"+rate+"\n"
					+ "Taux d'endettement: "+debtRatio+" %\n"
					+"Restant à vivre: "+restantAVivre+"\n"
					+"Excellent client, nous vous proposons\n comme taux: "+rate+" pour avoir un bénéfice";
			//rateClass.setRateValue(rate);

			rate = rate - 0.1 ;
		}
		
		if (categories.VeryGoodJuniorProfile() || categories.VeryGoodMediumProfile() || categories.VeryGoodSeniorProfile()) {
			show = "Taux référentiel de la maison-mère:"+rate+"\n"
					+ "Taux d'endettement: "+debtRatio+" %\n"
					+"Restant à vivre: "+restantAVivre+"\n"
					+"Excellent client, nous vous proposons\n comme taux: "+rate+" pour avoir un bénéfice";
			//rateClass.setRateValue(rate);

			rate = rate - 0.05 ;


		}
		
		if (categories.GoodJuniorProfile() || categories.GoodMediumProfile() || categories.GoodSeniorProfile()) {
			show = "Taux référentiel de la maison-mère:"+rate+"\n"
					+ "Taux d'endettement: "+debtRatio+" %\n"
					+"Restant à vivre: "+restantAVivre+"\n"
					+"Excellent client, nous vous proposons\n comme taux: "+rate+" pour avoir un bénéfice";
			//rateClass.setRateValue(rate);

			rate = rate - 0 ;


		}

		return show;
	}

}
