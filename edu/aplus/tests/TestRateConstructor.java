package edu.aplus.tests;

import static org.junit.Assert.*;
import javax.swing.JComboBox;
import org.junit.Test;
import edu.aplus.gui.SearchRatePanel2;
import edu.aplus.model.Rate;

/* JUnits tests to know if the selected items are considered in Rate.java
 * 
 */

public class TestRateConstructor {
	JComboBox loanType;
	JComboBox duration;

	Rate rate = new Rate ();
	SearchRatePanel2 srp= new SearchRatePanel2(loanType,duration);

	@Test
	public void testconstructorLoanName(){
		loanType =SearchRatePanel2.getSelectedLoanType();
		String loanTypeString = loanType.getSelectedItem().toString();
		rate.setLoanName(loanType.getSelectedItem().toString());
		assertEquals(loanTypeString,rate.getLoanName());

	}

	@Test
	public void testconstructorDuration(){
		duration =SearchRatePanel2.getSelectedDuration();
		int durationINT = Integer.parseInt(duration.getSelectedItem().toString());
		rate.setDuration(Integer.parseInt(duration.getSelectedItem().toString()));
		assertEquals(durationINT,rate.getDuration());

	}
}
