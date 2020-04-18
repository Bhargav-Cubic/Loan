package com.icorp.service;

import java.util.List;

import org.apache.log4j.LogManager;
import org.glassfish.hk2.utilities.reflection.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icorp.exception.DeleteFailEx;
import com.icorp.exception.InsersionFailEx;
import com.icorp.exception.RetrieveFailEx;
import com.icorp.exception.UpdateFailEx;
import com.icorp.DAO.LoanDAO;
import com.icorp.Entity.Loan;

@Service("LoanService")
@Transactional
public class LoanServiceimp implements LoanService {

	//org.apache.log4j.Logger LOG = LogManager.getLogger(LoanServiceimp.class.getName());
	@Autowired(required=true)
	@Qualifier("LoanDAO")
	
	private LoanDAO loandao;
	
	@Transactional
	public Loan addLoanDetails(Loan loan) throws InsersionFailEx {
		//LOG.info("adding details");
		System.out.println("Service is invoked:");
		try{
			loan = loandao.addLoanDetails(loan);
		}catch(Exception e)
		{
			//LOG.error("Unable to  add this");
		}
		return loan;
	}
	@Transactional
	public Loan updateLoanDetails(Loan loan) throws UpdateFailEx {
		//LOG.info("updating Marketers");
		System.out.println("Marketer Service Update invoked:");
		loan = loandao.updateLoanDetails(loan);
		//LOG.debug(" loan updated");
		return loan;		
	}
	@Transactional
	public boolean deleteLoanDetails(long id) throws DeleteFailEx {
		//LOG.info("Deleting details");
		
		try {
			loandao.deleteLoanDetails(id);
		} catch (Exception e) {
			//LOG.error("deleting exception");
			e.printStackTrace();
		}
		
		return false;
	}
	
	public Loan getLoanDetails(long id) throws RetrieveFailEx {
		//LOG.info("Getting details for " +id);
		try
		{
			Loan ln = loandao.getLoanDetails(id);
			//LOG.info("Received  details..." + ln.getName());
			return ln;
		}
		catch(Exception ex)
		{
			//LOG.info("Received details exception..." ,ex);			
		}
		
		return null;
	}

	public List<Loan> getLoanDetails() {
		//LOG.info("Getting details");
		return loandao.getLoanDetails();
	}

}
