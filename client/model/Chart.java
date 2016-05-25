package client.model;

import org.jfree.ui.RefineryUtilities;

import edu.aplus.gui.LineChart;

public class Chart {

	private String chartName = "";
	private int chartID;
	private LineChart chart;
	
	public Chart(String name){
		chartName = name;
	}

	public void afficher() {
		chart = new LineChart(chartName);

		chart.pack();
		RefineryUtilities.centerFrameOnScreen(chart);
		chart.setVisible(true);
	}

	public void imprimer() {

	}

}
