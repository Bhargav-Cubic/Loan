package com.icorp.DAO;


import java.util.List;
import org.apache.log4j.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.icorp.exception.DeleteFailEx;
import com.icorp.exception.InsersionFailEx;
import com.icorp.exception.RetrieveFailEx;
import com.icorp.exception.UpdateFailEx;
import com.icorp.Entity.Loan;

@Repository("LoanDAO")
@Transactional
public class LoanDAOimp implements LoanDAO{
	
	//Logger LOG = Logger.getLogger(LoanDAOimp.class.getName());
	
	@PersistenceContext
	public EntityManager entityManager;

	@Transactional(readOnly=false)
	public Loan addLoanDetails(Loan loan) throws InsersionFailEx {
		//LOG.info("Adding Details");
		
		try{
			entityManager.persist(loan);
		}catch(Exception e)
		{
			e.printStackTrace();
			//LOG.error("Exception" + e);
			throw new InsersionFailEx("Fail to insert" +e);
		}
		
		return null;
	}
	@Transactional(readOnly=false)
	public Loan updateLoanDetails(Loan loan) throws UpdateFailEx {
		//LOG.info("Updating Details");
		try{
			entityManager.merge(loan);
		}catch(Exception e)
		{
			e.printStackTrace();
			//LOG.error("Updating Exception" + e);
			throw new UpdateFailEx("Fail to Update" +e);
		}
		finally
		{
			System.out.println("Done with updation");
		}		return null;
	}
	@Transactional(readOnly=false)
	public void deleteLoanDetails(long id) throws DeleteFailEx {
		//LOG.info("Deleting Details");
		
		try{
			Loan lid= getLoanDetails(id);
			entityManager.remove(lid);
		}catch(Exception e)
		{
			e.printStackTrace();
			//LOG.error("Deleting Exception" + e);
			throw new DeleteFailEx("Fail to Delete" +e);
		}
		finally
		{
			System.out.println("Done with Deletion");
		}		
	}

	@Transactional(readOnly=true)
	public Loan getLoanDetails(long id) throws RetrieveFailEx {
		String sql = "select loan from Loan loan where loan.id="+id;
		try{
			return (Loan) entityManager.createQuery(sql).getSingleResult();
		}catch(Exception e)
		{
			e.printStackTrace();
			//LOG.error(e.getStackTrace().toString());
			//LOG.error("Exception" +e);
			throw new RetrieveFailEx("Fail to Retrieve" +e);
		}
		finally
		{
			System.out.println("Retrieve is done");
		}		
	}
	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	public List<Loan> getLoanDetails() {
		//LOG.info("Getting list");
		return entityManager.createQuery("select loan from Loan loan").getResultList();
	}

}
