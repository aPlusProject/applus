package edu.aplus.client.panel;

import java.awt.Dimension;
import java.sql.SQLException;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;

import edu.aplus.service.ChartsIndicator;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;

public class ChartsBarIndicatorPanel extends JPanel {
	
	
	
	private JButton btn;
	
	private CategoryDataset datasetBar;
	private ChartsIndicator cIndic;
	
	private ChartPanel chartPanel;
	
	private JFreeChart barChart;

	/**
	 * Create the panel.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public ChartsBarIndicatorPanel(int year) throws ClassNotFoundException, SQLException {
		//setBorder(new EmptyBorder(50, 50, 50, 50));
		//setLayout(new BorderLayout(0, 0));
		//setPreferredSize(new Dimension(5000, 3100));
		
		cIndic = new ChartsIndicator();
		
		datasetBar = cIndic.createDatasetForBarChart(year);
		
		barChart = ChartFactory.createBarChart("Nombres de demande de prêts par mois", "Mois", "Nombre de demandes de prêts", datasetBar);
		
		
		chartPanel = new ChartPanel( barChart );
		
		final JComboBox<Integer> comboBoxYears = cIndic.getListOfYear();
		btn = new JButton("OK");
		
		btn.addActionListener(new ActionListener() {

			

			@Override
			public void actionPerformed(ActionEvent e) {
				
					
					
					try {
						datasetBar = cIndic.createDatasetForBarChart((Integer.parseInt(comboBoxYears.getSelectedItem().toString())));
					} catch (NumberFormatException | ClassNotFoundException | SQLException e1) {
						e1.printStackTrace();
					}
					
					barChart = ChartFactory.createBarChart("Nombres de demande de prêts par mois", "Mois", "Nombre de demandes de prêts", datasetBar);
					
					remove(chartPanel);
					chartPanel = new ChartPanel( barChart );
					chartPanel.setMouseZoomable(true);
					chartPanel.setMinimumDrawWidth(260);
					chartPanel.setMaximumDrawWidth(600);
					chartPanel.setDismissDelay(1000);
					FlowLayout flowLayout = (FlowLayout) chartPanel.getLayout();
					flowLayout.setVgap(0);
					flowLayout.setHgap(0);
				    chartPanel.setPreferredSize( new Dimension(400, 250) );
                    
				    
				    add(chartPanel);
					
					repaint();
					updateUI();
					
					
				
				
			}
			
		});
		
		add(comboBoxYears);
		add(btn);
		
		
		
		
		
		
		
		
		chartPanel.setMouseZoomable(true);
		chartPanel.setMinimumDrawWidth(260);
		chartPanel.setMaximumDrawWidth(600);
		chartPanel.setDismissDelay(1000);
		FlowLayout flowLayout = (FlowLayout) chartPanel.getLayout();
		flowLayout.setVgap(0);
		flowLayout.setHgap(0);
	    chartPanel.setPreferredSize( new Dimension(400, 250) );

	    
	    
		add(chartPanel);
		
	}

}
