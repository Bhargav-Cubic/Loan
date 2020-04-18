/*package loantest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.runner.RunWith;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.icorp.Entity.Loan;
import com.icorp.service.LoanService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext.xml" })
public class Testloan {
	
	@Autowired(required = true)
	@Qualifier("LoanService")
	LoanService ls;
	
	@Test
	public void addLoanDetails() {
		Loan m = new Loan(5, "ss", 7, 7, 7);
		
		try {
			Loan mrktr = ls.addLoanDetails(m);
			assertFalse(mrktr == null);
		} catch (Exception e) {

			e.printStackTrace();
			//assertFalse(true);
			
			System.out.println("stupidsssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss");
		} 
	}
	
	
	@Test
	public void deleteLoanDetails() {
		try {
			boolean m;
			m=ls.deleteLoanDetails(3);
			//assertTrue(m);
		} catch (Exception e) {
			System.out.println("stupidsssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss");

			e.printStackTrace();
		}
	}
	

}
*/