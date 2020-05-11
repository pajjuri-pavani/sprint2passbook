package com.cg.anurag.pbs.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.anurag.pbs.dto.Transaction;

@Repository
public interface PassbookDao extends JpaRepository<Transaction,Integer> 
{
	public List<Transaction>  findAllTransByAccId(long accId);
}
