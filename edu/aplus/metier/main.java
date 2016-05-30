package edu.aplus.metier;

import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.aplus.db.ConnectionPool;
import edu.aplus.metier.*;
import javax.sql.DataSource;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import edu.aplus.metier.ChooseLoanType;
import edu.aplus.model.Rate;

import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


/* To launch my GUI 
 * 
 */
public class main {
	
	
	public static void main( String[] args) throws Exception  {

		ChooseLoanType clt = new ChooseLoanType();

	}	}
