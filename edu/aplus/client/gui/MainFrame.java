package edu.aplus.client.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.aplus.client.panel.ArrayIndicatorsPanel;
import edu.aplus.client.panel.FilterIndicatorsPanel;
import edu.aplus.client.panel.MainPanel;

import java.awt.GridLayout;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


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
	
	private static JMenuBar menubar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					
					
					
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
		setLayout(new GridBagLayout());
		setSize(950, 600);
		mainPanel = new MainPanel();
		
		getContentPane().add(mainPanel);
		
		final GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		
		
		mainPanel.setActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("test");
				//remove(mainPanel);
				mainPanel.setVisible(false);
				
				
				
				JMenu indicatorMenu = new JMenu("Indicateurs");
				JMenuItem openIndicator = new JMenuItem("Acceder");
				openIndicator.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						System.out.println("test Indicator");
						
						remove(indicatorsPanel);
						
						
						arrayPanel = new ArrayIndicatorsPanel();
						//lui fournir la table de l'autre panel et sorter
						indicatorsPanel = new FilterIndicatorsPanel(arrayPanel.getJTableObject(), arrayPanel.getSorterObject());
						c.gridx = 1;
						getContentPane().add(indicatorsPanel, c);
						validate();
						
					}
					
				});
				indicatorMenu.add(openIndicator);
				
				JMenu chartsMenu = new JMenu("Graphiques");
				JMenuItem openCharts = new JMenuItem("Acceder");
				openCharts.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						System.out.println("test charts");
						
					}
					
				});
				chartsMenu.add(openCharts);
				
				JMenuBar newMenubar = new JMenuBar();
				newMenubar.add(indicatorMenu);
				newMenubar.add(chartsMenu);
				
				setJMenuBar(newMenubar);
				
				arrayPanel = new ArrayIndicatorsPanel();
				
				indicatorsPanel = new FilterIndicatorsPanel(arrayPanel.getJTableObject(), arrayPanel.getSorterObject());
				
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
