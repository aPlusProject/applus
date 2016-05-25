package edu.aplus.gui;

import java.io.File;
import java.io.IOException;

import javax.swing.JButton;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

public class LineChart extends ApplicationFrame {
	private JFreeChart lineChart;

	public LineChart(String chartTitle) {
		// TODO Auto-generated constructor stub
		super(chartTitle);
		lineChart = ChartFactory.createLineChart(chartTitle, "Years", "Number of Schools", createDataset(),
				PlotOrientation.VERTICAL, true, true, false);

		ChartPanel chartPanel = new ChartPanel(lineChart);
		chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));
		setContentPane(chartPanel);
		
		
	}

	private DefaultCategoryDataset createDataset() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.addValue(15, "schools", "1970");
		dataset.addValue(30, "schools", "1980");
		dataset.addValue(60, "schools", "1990");
		dataset.addValue(120, "schools", "2000");
		dataset.addValue(240, "schools", "2010");
		dataset.addValue(300, "schools", "2014");
		return dataset;
	}
	
	private void saveAsJPEG(){
		File lineChartFile = new File( "LineChart.jpeg" ); 
	    try {
			ChartUtilities.saveChartAsJPEG(lineChartFile ,lineChart, 640 ,480);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
