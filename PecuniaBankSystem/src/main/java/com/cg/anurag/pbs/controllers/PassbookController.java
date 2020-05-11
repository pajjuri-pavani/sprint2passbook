package com.cg.anurag.pbs.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cg.anurag.pbs.dto.Transaction;
import com.cg.anurag.pbs.dto.Transactions;
import com.cg.anurag.pbs.services.PassbookService;

@RestController
//@CrossOrigin(origins="http://localhost:4200")
public class PassbookController 
{
	@Autowired
	PassbookService ps;
	public void setPs(PassbookService ps) 
	{
		this.ps = ps;
	}
	@GetMapping(value="/accountSummary/accountNo/{accNo}/startDate/{startDate}/endDate/{endDate}",produces= {"application/json","application/xml"})
	public ResponseEntity<Transactions> accountSummary(@PathVariable long accNo,@PathVariable String startDate,@PathVariable String endDate) throws ParseException
	{
		Date sd = new SimpleDateFormat("dd-mm-yyyy").parse(startDate);
		Date ed = new SimpleDateFormat("dd-mm-yyyy").parse(endDate);
		try 
		{
			Transactions t = ps.accountSummary(accNo, sd, ed);
			return new ResponseEntity<>(t,HttpStatus.OK);
		}
		catch(NoSuchElementException e)
		{
			return new ResponseEntity("Account does not exist",HttpStatus.NOT_FOUND);
		}		
	}
	@GetMapping(value="/passbookUpdate/accountNo/{accNo}/lasttransaction/{lastTransaction}",produces= {"application/json","application/xml"})
	public ResponseEntity<Transactions> passbookUpdate(@PathVariable long accNo,@PathVariable int lastTransaction) 
	{
		try
		{
			Transactions ts = ps.passbookUpdate(accNo, lastTransaction);
			return new ResponseEntity<Transactions>(ts,HttpStatus.OK);
		}
		catch(NoSuchElementException e)
		{
			return new ResponseEntity("Account Does not exist",HttpStatus.NOT_FOUND);
		}	
	}
}
