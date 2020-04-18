package com.icorp.DAO;

import java.util.List;

import com.icorp.exception.DeleteFailEx;
import com.icorp.exception.InsersionFailEx;
import com.icorp.exception.RetrieveFailEx;
import com.icorp.exception.UpdateFailEx;
import com.icorp.Entity.Loan;
import com.iorp.Entity.Loan;

public interface LoanDAO {
	
	public Loan addLoanDetails(Loan loan) throws  InsersionFailEx;
	public Loan updateLoanDetails(Loan loan) throws  UpdateFailEx;
	public void deleteLoanDetails(long id) throws DeleteFailEx;
	public Loan getLoanDetails(long id) throws RetrieveFailEx;
	public List<Loan> getLoanDetails();
	
	

}
