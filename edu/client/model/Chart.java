package edu.client.model;

import java.io.IOException;
import java.net.UnknownHostException;

import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RefineryUtilities;

import edu.aplus.gui.LineChart;
import edu.client.socket.ChartTCPClient;

public class Chart {

	private String chartName = "";
	//private int chartID;
	private LineChart chart;
	private DefaultCategoryDataset lineChartDataset;
	
	public Chart(String name){
		chartName = name;
	}

	public void afficher() {
		
		chart = new LineChart(chartName,this.createDataset());

		chart.pack();
		RefineryUtilities.centerFrameOnScreen(chart);
		chart.setVisible(true);
		
		try {
			ChartTCPClient clientSocket = new ChartTCPClient("LineChart");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private DefaultCategoryDataset createDataset(){
		lineChartDataset = new DefaultCategoryDataset();
		lineChartDataset.addValue(15, "Capital restant", "1970");
		lineChartDataset.addValue(30, "Capital restant", "1980");
		lineChartDataset.addValue(60, "Capital restant", "1990");
		lineChartDataset.addValue(120, "Capital restant", "2000");
		lineChartDataset.addValue(240, "Capital restant", "2010");
		lineChartDataset.addValue(300, "Capital restant", "2014");
		
		lineChartDataset.addValue(20, "Capital remboursé", "1970");
		lineChartDataset.addValue(30, "Capital remboursé", "1980");
		lineChartDataset.addValue(50, "Capital remboursé", "1990");
		lineChartDataset.addValue(100, "Capital remboursé", "2000");
		lineChartDataset.addValue(220, "Capital remboursé", "2010");
		lineChartDataset.addValue(320, "Capital remboursé", "2014");
		
		lineChartDataset.addValue(20, "Intérêt", "1970");
		lineChartDataset.addValue(15, "Intérêt", "1980");
		lineChartDataset.addValue(30, "Intérêt", "1990");
		lineChartDataset.addValue(100, "Intérêt", "2000");
		lineChartDataset.addValue(200, "Intérêt", "2010");
		lineChartDataset.addValue(320, "Intérêt", "2014");
		
		lineChartDataset.addValue(20, "Assurance", "1970");
		lineChartDataset.addValue(15, "Assurance", "1980");
		lineChartDataset.addValue(25, "Assurance", "1990");
		lineChartDataset.addValue(80, "Assurance", "2000");
		lineChartDataset.addValue(120, "Assurance", "2010");
		lineChartDataset.addValue(250, "Assurance", "2014");
		return lineChartDataset;
	}

}
