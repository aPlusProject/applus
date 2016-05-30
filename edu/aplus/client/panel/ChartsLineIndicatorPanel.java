package edu.aplus.client.panel;

import java.sql.SQLException;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;

import edu.aplus.service.ChartsIndicatorExpose;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

public class ChartsLineIndicatorPanel extends JPanel {

	/**
	 * Create the panel.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public ChartsLineIndicatorPanel() throws ClassNotFoundException, SQLException {
		
		ChartsIndicatorExpose cIndic = new ChartsIndicatorExpose();
		
		CategoryDataset datasetLine = cIndic.createDatasetForIncrementalLine();
		
		JFreeChart lineChart = ChartFactory.createLineChart(
		         "Nombres de demandes de prêts au cours des ans",
		         "Années","Demandes de prêts",
		         datasetLine,
		         PlotOrientation.VERTICAL,
		         true,true,false);
		
		
		
		ChartPanel chartPanel = new ChartPanel( lineChart );
		chartPanel.setMouseZoomable(true);
		chartPanel.setMinimumDrawWidth(10);
		chartPanel.setMinimumDrawHeight(10);
		//FlowLayout flowLayout = (FlowLayout) chartPanel.getLayout();
		chartPanel.setPreferredSize(new Dimension(900, 600));
		
		
		
		chartPanel.setLayout(new BorderLayout());
		chartPanel.setPreferredSize(new Dimension(900, 600));
		
		add(chartPanel);

	}

}
