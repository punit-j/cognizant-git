package com.test.banking;

/**
 * Contains account details and general functionalities like withdrawal, transfer
 * has abstract method for calculating interest
 * 
 * @author 765337
 */
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

	abstract float calculateInterest() throws MyException; // abstract method for calculating interest

	void withdrawl(float amount) throws MyException { // method to withdraw money from account
		if (amount > getBalance()) {
			throw new MyException("balance is not enough");
		} else {
			setBalance(getBalance() - amount);
			System.out.println("New balance is " + getBalance());
		}
	}

	void deposit(float amount) { // method to deposit money to the account
		setBalance(amount + getBalance());
		System.out.println("New balance is " + getBalance());
	}

	void showBalance(Account acc) { // Shows balance of the account
		System.out.println("Balance for Account Number " + acc.getAccNo() + " is " + acc.getBalance());
	}

	void transfer(Account toAcc, Account fromAcc, float amount) throws MyException { // transfers money from 1 account
																						// to another
		if (fromAcc.getBalance() < amount) {
			throw new MyException("Insufficient Funds");
		} else {
			fromAcc.setBalance(fromAcc.getBalance() - amount);
			toAcc.setBalance(toAcc.getBalance() + amount);
			System.out.println("New balance in account name " + toAcc.getAccName() + " is " + toAcc.getBalance()
					+ " and in account name " + fromAcc.getAccName() + " is " + fromAcc.getBalance());
		}

	}

	public Account() { // Default constructor
		super();
	}

	public Account(String accNo, String accName, String accType, int noOfYears, double balance) { // Parameterized
																									// constructor
		super();
		this.accNo = accNo;
		this.accName = accName;
		this.accType = accType;
		this.noOfYears = noOfYears;
		this.balance = balance;
	}
}
