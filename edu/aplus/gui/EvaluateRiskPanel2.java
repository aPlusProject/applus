package edu.aplus.gui;

import edu.aplus.metier.EvaluateRisk2;
import edu.aplus.metier.InterestRisk;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;


public class EvaluateRiskPanel2  extends JFrame {
EvaluateRiskPanel2 (){
     JRadioButton good;
     JRadioButton bad ;
     	good = new JRadioButton("Bon");
		bad = new JRadioButton("Mauvais");
		ButtonGroup health = new ButtonGroup();
		health.add(good);
		health.add(bad);
		good.setSelected(true);
		good.setBounds(150, 200, 150, 20);
		bad.setBounds(200, 200, 150, 20);
		this.add(good);
		this.add(bad);
		this.setVisible(true);
 }
public static void main(String args[]){
   EvaluateRiskPanel2 j = new EvaluateRiskPanel2();
}

}
