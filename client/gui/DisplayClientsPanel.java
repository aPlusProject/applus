package gui;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DisplayClientsPanel {
	
	private JPanel mainPanel = new JPanel();
	private JButton afficher;
	
	private static final Dimension MAIN_SIZE = new Dimension(400,200);
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {  	
        
        EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
                    JFrame frame = new JFrame("Supprimer un client");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.pack();
                    frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
        
    }
	
	public DisplayClientsPanel() {
		
	}
	
	public JComponent getMainComponent() {
		afficher = new JButton("Afficher");
		return mainPanel;
	}
	
	public void addAfficherBtnActionListener(ActionListener listener) {
	      afficher.addActionListener(listener);
	}

}
