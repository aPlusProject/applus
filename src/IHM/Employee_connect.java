package IHM;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JButton;

public class Employee_connect extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Employee_connect frame = new Employee_connect();
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
	public Employee_connect() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(null);
		contentPane.setLayout(null);
		
		JLabel lb_Emp_Name = new JLabel("Employee");
		lb_Emp_Name.setBounds(5, 5, 46, 14);
		contentPane.add(lb_Emp_Name);
		
		
		JLabel lb_Emp_addr = new JLabel("Adresse");
		lb_Emp_addr.setBounds(5, 30, 39, 14);
		contentPane.add(lb_Emp_addr);
		
		JLabel lb_Menu = new JLabel("Menu");
		lb_Menu.setBounds(5, 83, 368, 14);
		contentPane.add(lb_Menu);
		
		JButton btnNewButton = new JButton("Simulate");
		btnNewButton.setBounds(60, 83, 89, 23);
		contentPane.add(btnNewButton);
		
	}
}
