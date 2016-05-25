package client.model;

import org.jfree.ui.RefineryUtilities;

import edu.aplus.gui.LineChart;

public class Chart {

	private String chartName = "";
	private int chartID;
	private LineChart chart;

	public void afficher() {
		chart = new LineChart("Numer of Schools vs years");

		chart.pack();
		RefineryUtilities.centerFrameOnScreen(chart);
		chart.setVisible(true);
	}

	public void imprimer() {

	}

	public void exporter() {
		
	}
}
