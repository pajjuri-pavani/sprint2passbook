package com.cg.anurag.pbs.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Accounts 
{
	@Id
	long account_id;
	@Column(name="cust_id")
	int customer_id;
	int branch_id;
	String type;
	String status;
	double balance;

	Date dateOfTrans;
	int no_of_trans;
	double min_balance;
	public Accounts() {}
	public Accounts(long account_id, int customer_id, int branch_id, String type, String status, double balance,
			int no_of_trans, double min_balance) 
	{
		this.account_id = account_id;
		this.customer_id = customer_id;
		this.branch_id = branch_id;
		this.type = type;
		this.status = status;
		this.balance = balance;
		this.no_of_trans = no_of_trans;
		this.min_balance = min_balance;
	}
	public long getAccount_id() {
		return account_id;
	}
	public void setAccount_id(long account_id) {
		this.account_id = account_id;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public int getBranch_id() {
		return branch_id;
	}
	public void setBranch_id(int branch_id) {
		this.branch_id = branch_id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public int getNo_of_trans() {
		return no_of_trans;
	}
	public void setNo_of_trans(int no_of_trans) {
		this.no_of_trans = no_of_trans;
	}
	public double getMin_balance() {
		return min_balance;
	}
	public void setMin_balance(double min_balance) {
		this.min_balance = min_balance;
	}
}
