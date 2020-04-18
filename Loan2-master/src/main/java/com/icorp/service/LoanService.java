package com.icorp.service;

import java.util.List;

import com.icorp.exception.DeleteFailEx;
import com.icorp.exception.InsersionFailEx;
import com.icorp.exception.RetrieveFailEx;
import com.icorp.exception.UpdateFailEx;
import com.icorp.Entity.Loan;

public interface LoanService {
	
	public Loan addLoanDetails(Loan loan) throws InsersionFailEx;
	public Loan updateLoanDetails(Loan loan) throws UpdateFailEx;
	public boolean deleteLoanDetails(long id) throws DeleteFailEx;
	public Loan getLoanDetails(long id) throws RetrieveFailEx;
	public List<Loan> getLoanDetails();

}
