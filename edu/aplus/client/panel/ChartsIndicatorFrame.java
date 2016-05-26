package edu.aplus.client.panel;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RefineryUtilities;

public class ChartsIndicatorFrame extends JFrame {

	private JPanel contentPane;
	
	private JFreeChart freeChart;
	private ChartPanel chartPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChartsIndicatorFrame frame = new ChartsIndicatorFrame();
					RefineryUtilities.centerFrameOnScreen( frame );
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ChartsIndicatorFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		
		
		JFreeChart lineChart = ChartFactory.createLineChart(
		         "Nombres de demande de prêts par années",
		         "Années","Demandes de prêts",
		         createDataset(),
		         PlotOrientation.VERTICAL,
		         true,true,false);
		         
		      ChartPanel chartPanel = new ChartPanel( lineChart );
		      chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
		      setContentPane( chartPanel );
	}
	
	private DefaultCategoryDataset createDataset( )
	   {
	      DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
	      dataset.addValue( 2657 , "Nombres de demandes" , "2000" );
	      dataset.addValue( 5896 , "Nombres de demandes" , "2001" );
	      dataset.addValue( 6523 , "Nombres de demandes" ,  "2002" );
	      dataset.addValue( 7562 , "Nombres de demandes" , "2003" );
	      dataset.addValue( 9624 , "Nombres de demandes" , "2004" );
	      dataset.addValue( 1056 , "Nombres de demandes" , "2005" );
	      dataset.addValue( 1345 , "Nombres de demandes" , "2006" );
	      dataset.addValue( 1753 , "Nombres de demandes" , "2007" );
	      dataset.addValue( 1654 , "Nombres de demandes" , "2008" );
	      dataset.addValue( 2530 , "Nombres de demandes" , "2009" );
	      dataset.addValue( 2375 , "Nombres de demandes" , "2010" );
	      dataset.addValue( 3624 , "Nombres de demandes" , "2011" );
	      dataset.addValue( 4521 , "Nombres de demandes" , "2012" );
	      dataset.addValue( 2015 , "Nombres de demandes" , "2013" );
	      dataset.addValue( 2536 , "Nombres de demandes" , "2014" );
	      dataset.addValue( 2845 , "Nombres de demandes" , "2015" );
	      dataset.addValue( 2456 , "Nombres de demandes" , "2016" );
	      return dataset;
	   }
	
	
	/**
	 * 
	 * @param years > 0 
	 * @param month [0,12] if month== 0: month ignored
	 * @return the amount of loans by years and month
	 */
	public int getAmountOfLoansByTime(int years, int month) {
		
		int amountOfLoans = 0;
		
		String sql = "";
		
		if(month == 0) {
			
			sql = "SELECT COUNT(*) FROM LOAN WHERE "
					+ "EXTRACT (YEAR FROM ASKED_DATE) = ?";
			
			
		}
		
		
		return amountOfLoans;
	}
	
	

}
