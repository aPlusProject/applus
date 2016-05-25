package edu.aplus.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

public class LineChart extends ApplicationFrame {
	private JFreeChart lineChart;
	private DefaultCategoryDataset lineChartDataset = new DefaultCategoryDataset();

	public LineChart(String chartTitle) {
		// TODO Auto-generated constructor stub
		super(chartTitle);
		
		lineChart = ChartFactory.createLineChart(chartTitle, "Years", "Number of Schools", lineChartDataset,
				PlotOrientation.VERTICAL, true, true, false);

		ChartPanel chartPanel = new ChartPanel(lineChart);
		chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));
		this.add(chartPanel,BorderLayout.CENTER);
		
		JPanel buttonPanel = new JPanel();
        JButton printButton = new JButton("Print");
        buttonPanel.add(printButton);
        
        JButton exportButton = new JButton("Export to JPEG");
        exportButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				saveAsJPEG();
			}
		});
        buttonPanel.add(exportButton);
        
        this.add(buttonPanel, BorderLayout.SOUTH);

		
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

	private void saveAsJPEG() {
		File lineChartFile = new File("LineChart.jpeg");
		try {
			ChartUtilities.saveChartAsJPEG(lineChartFile, lineChart, 640, 480);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
