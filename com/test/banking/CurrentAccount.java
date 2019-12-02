package com.test.banking;

public class CurrentAccount extends Account{

	private int noOfTransactionPerMonth;

	
	
	float calculateInterest() {
		if(getNoOfTransactionPerMonth()<8) {
			return (float) ((getBalance()*getNoOfYears()*3)/100);
		}else {
		return 0;
	}}
	
	public int getNoOfTransactionPerMonth() {
		return noOfTransactionPerMonth;
	}
	public void setNoOfTransactionPerMonth(int noOfTransactionPerMonth) {
		this.noOfTransactionPerMonth = noOfTransactionPerMonth;
	}

	@Override
	void withdrawl(float amount) {
		if(amount>getBalance()) {
			System.out.println("Balance is not enough");
		}else {
			setBalance(getBalance()-amount);
			System.out.println("New balance is "+getBalance());
			noOfTransactionPerMonth++;
		}
	}

	@Override
	void deposit(float amount) {
		setBalance(amount+getBalance());
		System.out.println("New balance is "+getBalance());
		noOfTransactionPerMonth++;
	}

	@Override
	void showBalance(Account acc) {
		System.out.println("Balance for Account Number "+acc.getAccNo()+" is "+acc.getBalance());		
	}

	@Override
	void transfer(Account toAcc, Account fromAcc, float amount) {
		if(fromAcc.getBalance()<amount) {
			System.out.println("Insufficient Funds");
		}else {
			fromAcc.setBalance(fromAcc.getBalance()-amount);
			toAcc.setBalance(toAcc.getBalance()+amount);
			System.out.println("New balance in account name "+toAcc.getAccName()+" is "+toAcc.getBalance()+" and in account name "+ fromAcc.getAccName()+" is "+ fromAcc.getBalance());
		}
	}

	public CurrentAccount() {
		super();
	}

	public CurrentAccount(String accNo, String accName, String accType, int noOfYears, double balance) {
		super(accNo, accName, accType, noOfYears, balance);
	}

}
