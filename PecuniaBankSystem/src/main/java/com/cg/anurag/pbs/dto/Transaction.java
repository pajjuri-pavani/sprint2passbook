package com.cg.anurag.pbs.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "data")
@XmlRootElement
public class Transaction 
{
	@Id
	@Column(name="trans_id")
	private int transId;
	@Column(name="account_id")
	private long accId;
	@Column(name="type")
	private String type;
	@Column(name="amount")
	private double amount;
	@Column(name="cheque_id")
	private int chequeId;
	@Column(name="date_of_trans")
	private Date dateOfTrans;
	public Transaction() 
	{
	}
	public Transaction(int transId, long accId, String type, double amount, int chequeId, Date dateOfTrans) 
	{
		this.transId = transId;
		this.accId = accId;
		this.type = type;
		this.amount = amount;
		this.chequeId = chequeId;
		this.dateOfTrans = dateOfTrans;
	}
	public int getTransId() {
		return transId;
	}
	public void setTransId(int transId) {
		this.transId = transId;
	}
	public long getAccId() {
		return accId;
	}
	public void setAccId(long accId) {
		this.accId = accId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getChequeId() {
		return chequeId;
	}
	public void setChequeId(int chequeId) {
		this.chequeId = chequeId;
	}
	public Date getDateOfTrans() {
		return dateOfTrans;
	}
	public void setDateOfTrans(Date dateOfTrans) {
		this.dateOfTrans = dateOfTrans;
	}
}
