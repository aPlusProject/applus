package edu.aplus.gui;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import edu.aplus.business.SimulatorFixedRate;
import edu.aplus.model.Client;
import edu.aplus.model.Loan;
import edu.aplus.model.Rate;
import edu.aplus.service.JsonParser_new;
import edu.client.socket.RateTCPClient;
import edu.client.socket.TCPClient;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class SearchRatePanel2   extends JFrame{

	private static final String Clientid = null;
	private static JComboBox loanType;
	private static JComboBox duration;
	private JPanel panel;
	private JLabel durationL;
	private JLabel salaryL;
	private JLabel chargeL;
	private JLabel creditL;
	private JLabel statusL;
	private JLabel etatSanteL;
	private JLabel ageL;
	private JLabel creditTypeL;
	private JTextField salary;
	private JTextField charge;
	private JTextField credit;
	private JTextField status;
	private JTextField etatSante;
	private JTextField age;
	private JButton bouton;
	private JTextField rateT;
	private JLabel rateL;
	String receivedMsg;
	float rateReceived;

	/* The welcome panel for the director, he will be able to choose a loan type
	 * then he will choose the duration in other to determinate the rate
	 * that corresponds to the both parameters	
	 */

	private String[] listType = {"Pret immobilier","Pret de consommation","Pret professionnel"};
	//private String[] listDuration ; //{"1","2","3","4","5","6"};
	//private String[] listDuration2 = {"25","30"};
	//private String[] listDuration3 = {"5","0"};
	final DefaultComboBoxModel listDuration1 = new DefaultComboBoxModel(new String[]{"7", "10", "15","20", "25", "30"});
	final DefaultComboBoxModel listDuration2 = new DefaultComboBoxModel(new String[]{"7", "10", "15","20", "25", "30"});
	final DefaultComboBoxModel listDuration3 = new DefaultComboBoxModel(new String[]{"1", "2", "3","4", "5", "6"});


	public SearchRatePanel2(final JComboBox loan, final JComboBox durationLoan) {


		this.loanType = loan;
		this.duration = durationLoan;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 220, 400, 300);

		panel = new JPanel();
		panel.setBorder(new EmptyBorder(1, 1, 1, 1));
		setContentPane(panel);
		panel.setLayout(null);

		loanType = new JComboBox(listType);
		loanType.setSelectedIndex(-1);
		loanType.setBounds(150, 60, 200, 20);
		panel.add(loanType);

		duration = new JComboBox();
		duration.setBounds(150, 90, 100, 20);
		panel.add(duration);

		loanType.addActionListener (new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				if ("Pret immobilier".equals(loanType.getSelectedItem()))
					duration.setModel(listDuration1);    
				else if ("Pret de consommation".equals(loanType.getSelectedItem()))
					duration.setModel(listDuration2);    
				else 
					duration.setModel(listDuration3);    
			}});

		ImageIcon im2 = new ImageIcon(SearchRatePanel2.class.getResource("help.png")); 
		Image imBis = im2.getImage(); 
		imBis  = imBis.getScaledInstance(30,30,1);
		JLabel manual = new JLabel( new ImageIcon(imBis));
		manual.setBounds(350, 10, 40, 40);
		panel.add(manual);
		manual.addMouseListener(new MouseAdapter()  
		{  
			public void mouseClicked(MouseEvent e)  
			{  
				if (Desktop.isDesktopSupported()) {
					try {
						File myFile = new File( "/Users/thiathia02/git/applus/edu/aplus/gui/manual.pdf");
						Desktop.getDesktop().open(myFile);
					} catch (IOException ex) {
						// no application registered for PDFs
					}
				}
			}  
		});

		rateL = new JLabel("Choisissez le type et la durée de prêt");
		rateL.setBounds(20,20,350,15);
		panel.add(rateL);

		creditTypeL = new JLabel("Type du crédit  ");
		creditTypeL.setBounds(20, 60, 200, 15);
		panel.add(creditTypeL);



		durationL = new JLabel("Durée(ans)  ");
		durationL.setBounds(20, 90, 200, 15);
		panel.add(durationL);

		//duration = new JComboBox(listDuration);
		//duration.setBounds(150, 90, 100, 20);
		//panel.add(duration);

		bouton = new JButton("Afficher");
		bouton.setBounds(150, 130, 120, 25);
		panel.add(bouton);
		bouton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e){
				System.out.println((String)loanType.getSelectedItem());
				Rate rate = new Rate();

				rate.setLoanName(loanType.getSelectedItem().toString());
				try {
					rate.setDuration(Integer.parseInt(duration.getSelectedItem().toString()));
					receivedMsg  = getRatefromServer(rate);
					Map<String,Object> map = new HashMap<String,Object>();
					Gson gson = new Gson();
					map = (Map<String,Object>) gson.fromJson(receivedMsg, map.getClass());
					double mapgeteRate =	(double) map.get("rate");
					rateReceived = (float) mapgeteRate;
					System.out.println("Le rate est : "+rateReceived);	
					rate.setRateValue(rateReceived);
					SetProfileClient2 frame2 = new SetProfileClient2(rateReceived,rate);
					frame2.setVisible(true);
				} catch (ClassNotFoundException | IOException | InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

		}); 
	}

	/* The main */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchRatePanel2 frame = new SearchRatePanel2(loanType,duration);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/* Method to check the client server and parse the result */
	static String  getRatefromServer(Rate rate) throws UnknownHostException, IOException, ClassNotFoundException, InterruptedException {
		RateTCPClient clientTcp = new RateTCPClient();
		String receivedMsg = clientTcp.sendReceive("calculateRate");
		receivedMsg = clientTcp.sendReceive(JsonParser_new.ObjectToJSonRate(rate));
		return receivedMsg;		
	}	

	/* Getters and setters for the received rate */
	public void setRateReceived(float rateReceived) {
		this.rateReceived = rateReceived;
	}
	public float getRateReceived() {
		return this.rateReceived;
	}

	/*to get the current loanType and duration comboBox */
	public static JComboBox getSelectedLoanType() {
		return SearchRatePanel2.loanType;
	}
	public static JComboBox getSelectedDuration() {
		return SearchRatePanel2.duration;
	}



}