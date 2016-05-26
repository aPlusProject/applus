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
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RefineryUtilities;

import edu.aplus.client.service.ChartsIndicator;
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
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public ChartsIndicatorFrame() throws ClassNotFoundException, SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		
		//JFreeChart barChart = ChartFactory.createBarChart("Nombres de demande de prêts par années", "année", "Nombre de demandes", createDataset());
		
		ChartsIndicator cIndic = new ChartsIndicator();
		
		CategoryDataset ds = cIndic.createDatasetForIncrementalLine();
		JFreeChart lineChart = ChartFactory.createLineChart(
		         "Nombres de demandes de prêts au cours des années",
		         "Années","Demandes de prêts",
		         ds,
		         PlotOrientation.VERTICAL,
		         true,true,false);
		         
		      ChartPanel chartPanel = new ChartPanel( lineChart );
		      chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
		      setContentPane( chartPanel );
	}
			

}
