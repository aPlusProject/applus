package edu.aplus.ShowGraphics;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class GraphType extends JFrame{
	
	private JPanel mainpanel;

	public GraphType() throws HeadlessException {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Choose your chart type.");
		this.setBounds(100, 100, 300, 200);
		this.mainpanel = new JPanel();
		this.mainpanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.mainpanel.setLayout(new BorderLayout(0,0));
		
		JPanel buttonPanel = new JPanel(new GridLayout(3, 1));
		Border borderSelection = BorderFactory.createTitledBorder("Sélection");
		buttonPanel.setBorder(borderSelection);
		
		JButton columnChart = new JButton("Column chart");
		//columnChart.setBounds(10, 10, 120, 30);
		buttonPanel.add(columnChart);
		
		JButton lineChart = new JButton("Line chart");
		//lineChart.setBounds(10, 50, 120, 30);
		buttonPanel.add(lineChart);
		
		JButton pieChart = new JButton("Pie chart");
		//pieChart.setBounds(10, 110, 120, 30);
		buttonPanel.add(pieChart);
		
		mainpanel.add(buttonPanel);
		
		this.setContentPane(mainpanel);
		
	}
	

}
