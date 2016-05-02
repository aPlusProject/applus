package ShowGraphics;

import java.awt.BorderLayout;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class GraphType extends JFrame{
	
	private JPanel mainpanel;

	public GraphType() throws HeadlessException {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(100, 100, 300, 600);
		this.mainpanel = new JPanel();
		this.mainpanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.mainpanel.setLayout(new BorderLayout(0,0));
		this.setContentPane(mainpanel);
	}
	

}
