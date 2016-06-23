package edu.aplus.metier;

import edu.aplus.gui.SearchRatePanel2;
import edu.aplus.gui.SetProfileClient2;
import edu.aplus.model.Rate;

/* This class is for determine the decisions depending on the categories of the client profile
 * not yet completed
 * to be continued
 */

public class EvaluateRisk2 {

	private int revenu;
	private String status ;
	private int charge;
	private int credit ;
	private int age ;
	SearchRatePanel2 srp2;
	SetProfileClient2 spc2;
	Rate rateClass = new Rate();

	public EvaluateRisk2 (int revenu,String status, int credit,int age, int charge){
		this.revenu = SetProfileClient2.getSalary();
		this.status = SetProfileClient2.getStatus();
		this.credit = SetProfileClient2.getCredit();
		this.age = SetProfileClient2.getAge();
		this.charge=  SetProfileClient2.getCharge();

	}
	public final class MyResult {
		private final float newRate;
		private final String comment;

		public MyResult(float newRate, String comment) {
			this.newRate = newRate;
			this.comment = comment;
		}

		public float getNewRate() {
			return newRate;
		}
		public String getComment() {
			return comment;
		}
	}

	public MyResult Risk( float rate) {
		String show = null;
		float newRate = 0;
		Categories2 categories = new Categories2(revenu,status,credit,age, charge) ;
		float debtRatio =(float) (charge+credit)/revenu*100;
		int restantAVivre = revenu - charge;
		if (categories.ExcellentJuniorProfile() || categories.ExcellentMediumProfile() || categories.ExcellentSeniorProfile()) {
			newRate = (float) (rate - 0.1) ;
			rateClass.setRateAgency(newRate);
			show = "Taux référentiel de la maison-mère:" +rate+"\n"
					+"Taux d'endettement:" +debtRatio+" %\n"
					+"Restant à vivre:" +restantAVivre+"\n"
					+ "Les revenus du client sont très confortables et\n "
					+ "ont de fortes chances de se maintenir dans le temps,\n"
					+ "Client porteur d'affaires. Croissance constante\n"
					+ " de la marge d'intérêt de la banque\n"
					+ "Taux préférentiel conseillé: " +newRate+"";
			}

		if (categories.VeryGoodJuniorProfile() || categories.VeryGoodMediumProfile() || categories.VeryGoodSeniorProfile()) {
			newRate = (float) (rate - 0.05) ;
			rateClass.setRateAgency(newRate);
			show = "Taux référentiel de la maison-mère:" +rate+"\n"
					+"Taux d'endettement:" +debtRatio+" %\n"
					+"Restant à vivre:" +restantAVivre+"\n"
					+ "Les revenus du client sont confortables.\n"
					+ "Client porteur d'affaires. Croissance constante\n"
					+ " de la marge d'intérêt de la banque\n"
					+ "Mais statut CDD à prendre en compte, risque non\n"
					+ " négligeable de chomâge\n"
					+ "Taux préférentiel conseillé: " +newRate+"";

		}

		if (categories.GoodJuniorProfile() || categories.GoodMediumProfile() || categories.GoodSeniorProfile()) {
			newRate = (float) (rate + 0) ;
			rateClass.setRateAgency(newRate);
			show = "Taux référentiel de la maison-mère:" +rate+"\n"
					+"Taux d'endettement:" +debtRatio+" %\n"
					+"Restant à vivre:" +restantAVivre+"\n"
					+ "Mais risques de non-support des charges\n" 
					+ "Taux préférentiel conseillé: " +newRate+"";
		}
		if (categories.BadJuniorProfile() || categories.BadMediumProfile() || categories.BadSeniorProfile()) {
			newRate = (float) (rate + 0.05) ;
			rateClass.setRateAgency(newRate);
			show = "Taux référentiel de la maison-mère:" +rate+"\n"
					+"Taux d'endettement:" +debtRatio+" %\n"
					+"Restant à vivre:" +restantAVivre+"\n"
					+ "Mais risques de non-support des charges.\n"
					+ "Le caractère aléatoire du type de contrat(CDD ou\n"
					+ " autoentrepreneur) présage une perte de revenus\n"
					+ "à tout moment\n"
					+ "Taux préférentiel conseillé: " +newRate+"";

		}
		if (categories.VeryBadJuniorProfile() || categories.VeryBadMediumProfile() || categories.VeryBadSeniorProfile()) {
			newRate = (float) (rate + 0.1) ;
			rateClass.setRateAgency(newRate);
			show = "Taux référentiel de la maison-mère:" +rate+"\n"
					+"Taux d'endettement:" +debtRatio+" %\n"
					+"Restant à vivre:" +restantAVivre+"\n"
					+ " Risques de non-support des charges.\n"
					+ "Le caractère aléatoire du type de contrat(CDD ou\n"
					+ " autoentrepreneur) présage une perte de revenus\n"
					+ "à tout moment\n"
					+ "Nécessite de couverture des risques maladie/décès\n"
					+ "Taux préférentiel conseillé: " +newRate+"";
		}
		if (categories.NoLoanJuniorProfile()|| categories.NoLoanMediumProfile() || categories.NoLoanSeniorProfile())
		{
			newRate = 0 ;
			rateClass.setRateAgency(newRate);
			show = "L'absence ou la faiblesse des revenus \n ne permet pas d'accorder un prêt";
		}

		return new MyResult(newRate, show);
	}



}
