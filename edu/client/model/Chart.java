package edu.client.model;

import java.io.IOException;
import java.net.UnknownHostException;

import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RefineryUtilities;

import edu.aplus.gui.LineChart;
import edu.client.socket.ChartTCPClient;

public class Chart {

	private String chartName = "";
	// private int chartID;
	private LineChart chart;
	private DefaultCategoryDataset lineChartDataset;
	private DefaultCategoryDataset barChartDataset;
	private String amount;
	private String duration;
	private String rate;
	private String rate_insurance;
	private String year;
	private String month;

	public Chart(String name) {
		chartName = name;
	}

	public Chart(String name, String amount, String duration, String rate, String rate_insurance, String year,
			String month) {
		super();
		this.chartName = name;
		this.amount = amount;
		this.duration = duration;
		this.rate = rate;
		this.rate_insurance = rate_insurance;
		this.year = year;
		this.month = month;
	}

	public void afficher() {

		this.createDataset();
		chart = new LineChart(chartName, lineChartDataset,barChartDataset);
		chart.pack();
		RefineryUtilities.centerFrameOnScreen(chart);
		chart.setVisible(true);
	}

	private void createDataset() {
		barChartDataset = new DefaultCategoryDataset();
		lineChartDataset = new DefaultCategoryDataset();
		int duree = Integer.parseInt(duration);
		//int start = Integer.parseInt(month);
		int total = Integer.parseInt(amount);
		//monthly rate
		float taux = (float)Integer.parseInt(rate)/12;
		float tauxAssurance = (float)Integer.parseInt(rate_insurance)/12;
		
		float interet=0;
		float assurance=0;
		float capitalRestant=total;
		float capitalRembourse=0;
		float mensualite=total/(duree*12);
		
		
		for (int i = 0; i < duree * 12; i++) {
			interet=(capitalRestant*taux)/100;
			mensualite=interet+(total/(duree*12));
			capitalRestant=capitalRestant-mensualite;
			capitalRembourse=capitalRembourse+mensualite;
			assurance=(capitalRestant*tauxAssurance)/100;
			
			barChartDataset.addValue(capitalRestant, "Capital restant", i + 1 + "");
			barChartDataset.addValue(capitalRembourse, "Capital remboursee", i + 1 + "");
			lineChartDataset.addValue(interet, "Interet", i + 1 + "");
			lineChartDataset.addValue(assurance, "Assurance",i + 1 + "");
			
		}

		
	}

}
