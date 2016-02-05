package IHM;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class Connection_menu extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_ID;
	private JLabel lblPassword;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Connection_menu frame = new Connection_menu();
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
	public Connection_menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBankName = new JLabel("Bank name");
		lblBankName.setBounds(172, 11, 76, 14);
		contentPane.add(lblBankName);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(81, 77, 46, 14);
		contentPane.add(lblId);
		
		textField_ID = new JTextField();
		textField_ID.setBounds(162, 74, 86, 20);
		contentPane.add(textField_ID);
		
		lblPassword = new JLabel("Password");
		lblPassword.setBounds(81, 131, 46, 14);
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(162, 128, 86, 20);
		contentPane.add(passwordField);
		
		
		
	}
}
