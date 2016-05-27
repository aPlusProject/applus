package edu.aplus.client.panel;

import java.sql.SQLException;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;

import edu.aplus.service.ChartsIndicatorExpose;

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
	    chartPanel.setPreferredSize( new java.awt.Dimension( 550 , 310 ) );

		add(chartPanel);

	}

}
