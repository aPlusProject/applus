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
import java.text.NumberFormat;

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
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.panel.CrosshairOverlay;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.CombinedDomainXYPlot;
import org.jfree.chart.plot.Crosshair;
import org.jfree.chart.plot.DatasetRenderingOrder;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.renderer.xy.StandardXYItemRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleEdge;

public class BarLineChart extends ApplicationFrame implements ChartMouseListener {
	private JFreeChart chart;
	// private DefaultCategoryDataset lineChartDataset = new
	// DefaultCategoryDataset();
	private final ChartPanel chartPanel;
	private Crosshair xCrosshair;
	private Crosshair yCrosshair;

	public BarLineChart(String chartTitle, DefaultCategoryDataset dataset1, DefaultCategoryDataset dataset2) {
		// TODO Auto-generated constructor stub
		super(chartTitle);

		final CategoryPlot plot = new CategoryPlot();

		// first chart (interet and assurance)
		final CategoryItemRenderer renderer = new BarRenderer();
		// renderer.setLabelGenerator(generator);
		renderer.setItemLabelsVisible(true);
		plot.setDataset(dataset1);
		plot.setRenderer(renderer);
		plot.setRangeAxis(new NumberAxis("Euro"));

		// 2nd chart
		final ValueAxis rangeAxis2 = new NumberAxis("Euro");
		plot.setRangeAxis(1, rangeAxis2);

		plot.setDataset(2, dataset2);
		CategoryItemRenderer renderer2 = new LineAndShapeRenderer();
		plot.setRenderer(2, renderer2);
		plot.mapDatasetToRangeAxis(2, 1);
		plot.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);
		plot.setDomainAxis(new CategoryAxis("Month"));
		plot.getDomainAxis().setCategoryLabelPositions(CategoryLabelPositions.UP_45);

		plot.setOrientation(PlotOrientation.VERTICAL);
		plot.setBackgroundPaint(Color.white);
		plot.setRangeGridlinePaint(Color.lightGray);
		plot.setDomainGridlinesVisible(true);
		plot.setRangeGridlinesVisible(true);

		renderer.setBaseToolTipGenerator(
				new StandardCategoryToolTipGenerator("{0}, {1}, {2}", NumberFormat.getInstance()));

		renderer2.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator());
		renderer.setSeriesStroke(0, new BasicStroke(2.0f, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_ROUND));
	

		chart = new JFreeChart(plot);
		
		// add the chart to a panel...
		chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
	

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

	private void saveAsJPEG() {
		File ChartFile = new File("Chart.jpeg");
		try {
			ChartUtilities.saveChartAsJPEG(ChartFile, chart, 640, 480);
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
