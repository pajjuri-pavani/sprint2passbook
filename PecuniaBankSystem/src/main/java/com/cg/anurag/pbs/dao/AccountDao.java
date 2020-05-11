package com.cg.anurag.pbs.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.anurag.pbs.dto.Accounts;

@Repository
public interface AccountDao extends JpaRepository<Accounts,Long>
{

}
