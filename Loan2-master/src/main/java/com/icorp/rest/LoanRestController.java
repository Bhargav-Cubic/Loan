package com.icorp.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.icorp.exception.RetrieveFailEx;
import com.icorp.exception.DeleteFailEx;
import com.icorp.exception.InsersionFailEx;
import com.icorp.exception.UpdateFailEx;
import com.icorp.Entity.Loan;
import com.icorp.service.LoanService;



@RestController
//@RequestMapping("/loan")
public class LoanRestController {
	
	//Logger LOG = Logger.getLogger(LoanRestController.class.getName());
	
	@Autowired(required=true)
	@Qualifier("LoanService")
	private LoanService lservice;
	
	@GetMapping("/{id}")
	public Loan getdetails(@PathVariable("id") long id){
		//LOG.info("getMarketers for " + id);
		try {
			return lservice.getLoanDetails(id);
		} catch (RetrieveFailEx e) {
			
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public ResponseEntity<List<Loan>> alldetails(){
		//LOG.info("get all details");
		List<Loan> list = lservice.getLoanDetails();
		return new ResponseEntity<List<Loan>>(list, HttpStatus.OK);
		
	}
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public Loan editMarketer(@RequestBody Loan loan){
		 try {
			loan = lservice.updateLoanDetails(loan);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return loan;
		
	}
	
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Loan addLoanDetails(@RequestBody Loan loan){
		
	
	    try {
			loan = lservice.addLoanDetails(loan);
			
            
		} catch (Exception e) {
			
			e.printStackTrace();
			//LOG.error("Unable to add details");
			/*response.setData(marketer);
            response.setStatus(-1);
            response.setMessage("Failed: " + e);*/
			
		}
		return loan;
	}
	
	@RequestMapping(value="/delete/{id}",method=RequestMethod.GET)
	public Loan deleteLoanDetails(@PathVariable("id") long id){
		//LOG.info("delete Marketers for " + id);
		try {
			lservice.deleteLoanDetails(id);
		
		} catch (Exception e) {
			e.printStackTrace();
			//LOG.error("Marketer Deleted Failed");
			
		}
		
		return null;
	}
	
	
	
	

}
