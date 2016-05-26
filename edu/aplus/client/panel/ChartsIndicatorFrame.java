package edu.aplus.client.panel;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.sql.DataSource;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RefineryUtilities;

import edu.aplus.db.DBConnector;

public class ChartsIndicatorFrame extends JFrame {

	private JPanel contentPane;
	
	private JFreeChart freeChart;
	private ChartPanel chartPanel;

	/**
	 * Launch the application.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		/*EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChartsIndicatorFrame frame = new ChartsIndicatorFrame();
					RefineryUtilities.centerFrameOnScreen( frame );
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});*/
		
		ChartsIndicatorFrame instance = new ChartsIndicatorFrame();
		
		instance.getAmountOfLoansByMonth(2016);
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
		
		JFreeChart barChart = ChartFactory.createBarChart("Nombres de demande de prêts par années", "année", "Nombre de demandes", createDataset());
		JFreeChart lineChart = ChartFactory.createLineChart(
		         "Nombres de demande de prêts par années",
		         "Années","Demandes de prêts",
		         createDataset(),
		         PlotOrientation.VERTICAL,
		         true,true,false);
		         
		      ChartPanel chartPanel = new ChartPanel( barChart );
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
	 *  @param year > 0
	 *  
	 *  @return ArrayList<Integer> number of loans for each month
	 *  january = arraylist.get(0) and december = arraylist.get(11)
	 *  
	 */
	public ArrayList<Integer> getAmountOfLoansByMonth(int year) throws ClassNotFoundException, SQLException {
				
		ArrayList<Integer> listLoanByYear = new ArrayList<Integer>();
		for(int i = 1; i <= 12; i++) {
			
			String sql = "SELECT COUNT(*) FROM LOAN "
					+ "WHERE EXTRACT (YEAR FROM ASKED_DATE) = ? "
					+ "AND EXTRACT (MONTH FROM ASKED_DATE) = ?";
			
			DataSource ds = DBConnector.createDataSource();
	        Connection co = ds.getConnection();
	        
	        PreparedStatement ps = co.prepareStatement(sql);
	        ps.setInt(1, year);
	        ps.setInt(2, i);
	        
	        ResultSet rs = ps.executeQuery();
	        while(rs.next()) { 
	        	listLoanByYear.add(rs.getInt(1));
	        }
	        
	        System.out.println("mois no"+listLoanByYear.size()+" : "+listLoanByYear.get(i-1)+" demandes");
			
		}
			
		
		return listLoanByYear;
	}
	
	public int getLoanAmountInAYear(int year) throws SQLException, ClassNotFoundException {
		
		int loanAmount = 0;
		
		
		DataSource ds = DBConnector.createDataSource();
        Connection co = ds.getConnection();
        
        String sql = "SELECT COUNT(*) FROM LOAN WHERE "
				+ "EXTRACT (YEAR FROM ASKED_DATE) = ?";
        
        PreparedStatement ps = co.prepareStatement(sql);
        ps.setInt(1, year);
        
        ResultSet rs = ps.executeQuery();
        while(rs.next()) { 
        	loanAmount = rs.getInt(1);
        }
		co.close();
		
		
		return loanAmount;
	}
	
	
	public ArrayList<Integer> getLoanAmountForEachYear() throws ClassNotFoundException, SQLException {
		
		ArrayList<Integer> listLoanEachYear = new ArrayList<Integer>();
		
		//get the current year for the the boucle
		int year = Calendar.getInstance().get(Calendar.YEAR);
		//add the amount of loan for each year until this current year
		for(int i=2000; i <= year; i++) {
			listLoanEachYear.add(this.getLoanAmountInAYear(i));
			System.out.println("année no"+listLoanEachYear.size()+" : "+listLoanEachYear.get(i-2000)+" demandes");
		}
		
		
		return listLoanEachYear;
		
	}
	
	

}
