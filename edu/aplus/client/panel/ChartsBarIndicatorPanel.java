package edu.aplus.client.panel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.sql.SQLException;
import java.util.Calendar;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;

import edu.aplus.service.ChartsIndicator;
import java.awt.FlowLayout;
import javax.swing.JComboBox;

public class ChartsBarIndicatorPanel extends JPanel {
	
	
	private JComboBox<Integer> comboBoxYears;

	/**
	 * Create the panel.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public ChartsBarIndicatorPanel(int year) throws ClassNotFoundException, SQLException {
		//setBorder(new EmptyBorder(50, 50, 50, 50));
		//setLayout(new BorderLayout(0, 0));
		//setPreferredSize(new Dimension(5000, 3100));
		
		ChartsIndicator cIndic = new ChartsIndicator();
		
		
		JComboBox<Integer> comboBoxYears = cIndic.getListOfYear();
		
		CategoryDataset datasetBar = cIndic.createDatasetForBarChart(year);
		
		
		JFreeChart barChart = ChartFactory.createBarChart("Nombres de demande de prêts par mois", "Mois", "Nombre de demandes de prêts", datasetBar);
		
		
		ChartPanel chartPanel = new ChartPanel( barChart );
		FlowLayout flowLayout = (FlowLayout) chartPanel.getLayout();
		flowLayout.setHgap(0);
	    chartPanel.setPreferredSize( new java.awt.Dimension( 550 , 310 ) );

		add(chartPanel);
		
	}

}
