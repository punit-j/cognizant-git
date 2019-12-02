package com.test.banking;

public abstract class Account {
	private String accNo, accName, accType;
	private int noOfYears;
	double balance;
	
	public String getAccNo() {
		return accNo;
	}
	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}
	public String getAccName() {
		return accName;
	}
	public void setAccName(String accName) {
		this.accName = accName;
	}
	public String getAccType() {
		return accType;
	}
	public void setAccType(String accType) {
		this.accType = accType;
	}
	public int getNoOfYears() {
		return noOfYears;
	}
	public void setNoOfYears(int noOfYears) {
		this.noOfYears = noOfYears;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
abstract float calculateInterest();
abstract void withdrawl(float amount);
abstract void deposit(float amount);
abstract void showBalance(Account acc);
abstract void transfer(Account toAcc, Account fromAcc, float amount);

public Account() {
	super();
}
public Account(String accNo, String accName, String accType, int noOfYears, double balance) {
	super();
	this.accNo = accNo;
	this.accName = accName;
	this.accType = accType;
	this.noOfYears = noOfYears;
	this.balance = balance;
}
}
