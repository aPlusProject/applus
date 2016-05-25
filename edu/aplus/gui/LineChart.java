package edu.aplus.gui;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartMouseEvent;
import org.jfree.chart.ChartMouseListener;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.panel.CrosshairOverlay;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.CombinedDomainXYPlot;
import org.jfree.chart.plot.Crosshair;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.renderer.xy.StandardXYItemRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleEdge;

public class LineChart extends ApplicationFrame implements ChartMouseListener {
	private JFreeChart lineChart;
	private DefaultCategoryDataset lineChartDataset = new DefaultCategoryDataset();
	private final ChartPanel chartPanel;
	private Crosshair xCrosshair;
	private Crosshair yCrosshair;

	public LineChart(String chartTitle) {
		// TODO Auto-generated constructor stub
		super(chartTitle);

		lineChart = ChartFactory.createLineChart(chartTitle, "X", "Y", createDataset(),
				PlotOrientation.VERTICAL, true, true, false);
		final CategoryPlot plot = (CategoryPlot) lineChart.getPlot(); 
		plot.setBackgroundPaint(Color.white); 
		plot.setRangeGridlinePaint(Color.lightGray); 
		plot.setDomainGridlinesVisible(true); 
		plot.setRangeGridlinesVisible(true); 

		final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis(); 
		rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits()); 
		rangeAxis.setAutoRangeIncludesZero(true); 

		final LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot.getRenderer(); 
		renderer.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator()); 
		renderer.setSeriesStroke(0, new BasicStroke(2.0f, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_ROUND));
		renderer.setShapesVisible(true);
		
		chartPanel = new ChartPanel(lineChart);
		chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));
		chartPanel.addChartMouseListener(this);


		this.add(chartPanel, BorderLayout.CENTER);

		JPanel buttonPanel = new JPanel();
		JButton printButton = new JButton("Print chart");
		printButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				chartPanel.createChartPrintJob();
			}
		});
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

	@Override
	public void chartMouseClicked(ChartMouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void chartMouseMoved(ChartMouseEvent event) {
		// TODO Auto-generated method stub
		
	}

}
