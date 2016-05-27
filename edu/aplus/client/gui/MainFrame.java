package edu.aplus.client.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.ui.RefineryUtilities;

import edu.aplus.client.panel.ArrayIndicatorsPanel;
import edu.aplus.client.panel.ChartsBarIndicatorPanel;
import edu.aplus.client.panel.ChartsLineIndicatorPanel;
import edu.aplus.client.panel.FilterIndicatorsPanel;
import edu.aplus.client.panel.MainPanel;

import java.awt.GridLayout;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Calendar;


/**
 * 
 * @author Vyach
 * 
 *  Main Frame that regroup all panel for the use of the app
 *
 */
public class MainFrame extends JFrame {

	private MainPanel mainPanel;
	private FilterIndicatorsPanel indicatorsPanel;
	private ArrayIndicatorsPanel arrayPanel;
	
	private ChartsBarIndicatorPanel chartsBarIndicPanel;
	private ChartsLineIndicatorPanel chartsLineIndicPanel;
	
	private static JMenuBar menubar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					
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
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(50, 50, 1000, 1000);
		getContentPane().setLayout(new GridBagLayout());
		setSize(1200, 650);
		setPreferredSize(new Dimension(1200, 650));
		mainPanel = new MainPanel();
		
		/*GridBagConstraints gbc_mainPanel = new GridBagConstraints();
		gbc_mainPanel.weighty = 0.1;
		gbc_mainPanel.weightx = 0.1;*/
		getContentPane().add(mainPanel);
		
		final GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.1;
		c.weighty = 0.1;
		
		
		mainPanel.setActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("test");
				//remove(mainPanel);
				mainPanel.setVisible(false);
				
				
				
				JMenu indicatorMenu = new JMenu("Indicateurs");
				JMenuItem openIndicator = new JMenuItem("Acceder");
				
				// point on filterIndicator view when we clique on the button
				openIndicator.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						System.out.println("test Indicator");
						
						remove(mainPanel);
						remove(arrayPanel);
						remove(indicatorsPanel);
						remove(chartsBarIndicPanel);
						remove(chartsLineIndicPanel);
						
						
						arrayPanel = new ArrayIndicatorsPanel();
						
						//reaffect the needed panels
						indicatorsPanel = new FilterIndicatorsPanel(arrayPanel.getJTableObject(), arrayPanel.getSorterObject());
						c.gridx = 0;
						getContentPane().add(arrayPanel, c);
						pack();
						c.gridx = 1;
						getContentPane().add(indicatorsPanel, c);
						pack();
						repaint();
						
					}
					
				});
				indicatorMenu.add(openIndicator);
				
				JMenu chartsMenu = new JMenu("Graphiques");
				JMenuItem openCharts = new JMenuItem("Acceder");
				
				// point on chartes Indicator view when we clique on the button
				openCharts.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						System.out.println("test charts");
						
						remove(mainPanel);
						remove(arrayPanel);
						remove(indicatorsPanel);
						remove(chartsBarIndicPanel);
						remove(chartsLineIndicPanel);
						
						
						int currentYear = Calendar.getInstance().get(Calendar.YEAR);
						System.out.println(currentYear);
						try {
							chartsBarIndicPanel = new ChartsBarIndicatorPanel(currentYear);
							chartsLineIndicPanel = new ChartsLineIndicatorPanel();
							c.gridx = 0;
							c.gridy = 0;
							remove(mainPanel);
							getContentPane().add(chartsBarIndicPanel);
							
							pack();
							c.gridx = 1;
							getContentPane().add(chartsLineIndicPanel);
							pack();
							repaint();
							
							
						} catch (ClassNotFoundException | SQLException e1) {
							
							e1.printStackTrace();
						}
						
					}
					
				});
				chartsMenu.add(openCharts);
				
				JMenuBar newMenubar = new JMenuBar();
				newMenubar.add(indicatorMenu);
				newMenubar.add(chartsMenu);
				
				setJMenuBar(newMenubar);
				
				arrayPanel = new ArrayIndicatorsPanel();
				
				indicatorsPanel = new FilterIndicatorsPanel(arrayPanel.getJTableObject(), arrayPanel.getSorterObject());
				try {
					chartsBarIndicPanel = new ChartsBarIndicatorPanel(2016);
					chartsLineIndicPanel = new ChartsLineIndicatorPanel();
					
					chartsBarIndicPanel.setVisible(false);
					chartsLineIndicPanel.setVisible(false);
					
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				
				c.gridx = 0;
				getContentPane().add(arrayPanel, c);
				pack();
				c.gridx = 1;
				getContentPane().add(indicatorsPanel, c);
				repaint();
				
		        setVisible(true);
				
				
				
			}
			
		});
	}

}
