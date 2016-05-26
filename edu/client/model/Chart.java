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

		chart = new LineChart(chartName, this.createDataset());
		chart.pack();
		RefineryUtilities.centerFrameOnScreen(chart);
		chart.setVisible(true);
	}

	private DefaultCategoryDataset createDataset() {
		lineChartDataset = new DefaultCategoryDataset();
		int duree = Integer.parseInt(duration);
		int start = Integer.parseInt(month);
		int total = Integer.parseInt(amount);
		int taux = Integer.parseInt(rate);
		float interet=0;
		float assurance=0;
		int tauxAssurance = Integer.parseInt(rate_insurance);
		for (int i = 0; i < duree * 12; i++) {
			interet = interet+((total/duree*12)*((float)taux/12));
			assurance = assurance+((total/duree*12)*((float)tauxAssurance/12));
			lineChartDataset.addValue(total - (i+1) * total / (duree * 12), "Capital restant", i + 1 + "");
			lineChartDataset.addValue((i+1) * total / (duree * 12), "Capital remboursee", i + 1 + "");
			lineChartDataset.addValue(interet, "Interet", i + 1 + "");
			lineChartDataset.addValue(assurance, "Assurance",
					i + 1 + "");
			

		}
		/*
		 * lineChartDataset.addValue(15, "Capital restant", "1970");
		 * lineChartDataset.addValue(30, "Capital restant", "1980");
		 * lineChartDataset.addValue(60, "Capital restant", "1990");
		 * lineChartDataset.addValue(120, "Capital restant", "2000");
		 * lineChartDataset.addValue(240, "Capital restant", "2010");
		 * lineChartDataset.addValue(300, "Capital restant", "2014");
		 * 
		 * lineChartDataset.addValue(20, "Capital remboursé", "1970");
		 * lineChartDataset.addValue(30, "Capital remboursé", "1980");
		 * lineChartDataset.addValue(50, "Capital remboursé", "1990");
		 * lineChartDataset.addValue(100, "Capital remboursé", "2000");
		 * lineChartDataset.addValue(220, "Capital remboursé", "2010");
		 * lineChartDataset.addValue(320, "Capital remboursé", "2014");
		 * 
		 * lineChartDataset.addValue(20, "Intérêt", "1970");
		 * lineChartDataset.addValue(15, "Intérêt", "1980");
		 * lineChartDataset.addValue(30, "Intérêt", "1990");
		 * lineChartDataset.addValue(100, "Intérêt", "2000");
		 * lineChartDataset.addValue(200, "Intérêt", "2010");
		 * lineChartDataset.addValue(320, "Intérêt", "2014");
		 * 
		 * lineChartDataset.addValue(20, "Assurance", "1970");
		 * lineChartDataset.addValue(15, "Assurance", "1980");
		 * lineChartDataset.addValue(25, "Assurance", "1990");
		 * lineChartDataset.addValue(80, "Assurance", "2000");
		 * lineChartDataset.addValue(120, "Assurance", "2010");
		 * lineChartDataset.addValue(250, "Assurance", "2014");
		 */
		return lineChartDataset;
	}

}
