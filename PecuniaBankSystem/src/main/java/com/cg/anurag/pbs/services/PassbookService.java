package com.cg.anurag.pbs.services;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.anurag.pbs.dao.AccountDao;
import com.cg.anurag.pbs.dao.PassbookDao;
import com.cg.anurag.pbs.dto.Accounts;
import com.cg.anurag.pbs.dto.Transaction;
import com.cg.anurag.pbs.dto.Transactions;

@Service
public class PassbookService 
{
	@Autowired
	PassbookDao pdao;
	@Autowired
	AccountDao adao;
	public void setPdao(PassbookDao pdao)
	{
		this.pdao = pdao;
	}
	public void setAdao(AccountDao adao) 
	{
		this.adao = adao;
	}

	@Transactional
	public Transactions accountSummary(long accId,Date startDate,Date endDate)
	{
			adao.findById(accId).get();
			List<Transaction> list = pdao.findAllTransByAccId(accId);
			List<Transaction> slist = new ArrayList<>();
			for(Transaction t : list)
			{
				if(t.getDateOfTrans().after(startDate)&&t.getDateOfTrans().before(endDate))
					slist.add(t);				
			}
			Transactions t = new Transactions();
			t.setTransactions(slist);
			return t;
	}
	@Transactional
	public Transactions passbookUpdate(long accNo,int lastTransaction) 
	{
		adao.findById(accNo).get();
		List<Transaction> list = pdao.findAllTransByAccId(accNo);
		List<Transaction> slist = new ArrayList<>();
		for(Transaction t : list)
		{
			if(t.getTransId()>lastTransaction)
				slist.add(t);
		}
		Transactions t = new Transactions();
		t.setTransactions(slist);
		return t;
	}
}
