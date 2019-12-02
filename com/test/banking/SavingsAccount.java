package com.test.banking;

public class SavingsAccount extends Account {

	private float minBalance = 5000;
	public float getMinBalance() {
		return minBalance;
	}

	public void setMinBalance(float minBalance) {
		this.minBalance = minBalance;
	}

	
	float calculateInterest() {
		double noOfYears = getNoOfYears();
		double balance = getBalance();
	if(getBalance() > getMinBalance()) {
		if(getBalance() > 200000) {
			return (float) ((noOfYears*balance*4)/100);
		}else {
			return (float) ((noOfYears*balance*3.5)/100);
		}
	}else {
		return 0;
	}}

	@Override
	void withdrawl(float amount) {
		if(amount>getBalance()) {
			System.out.println("balance is not enough");
		}else {
			setBalance(getBalance()-amount);
			System.out.println("New balance is "+getBalance());
		}
	}

	@Override
	void deposit(float amount) {
		setBalance(amount+getBalance());
		System.out.println("New balance is "+getBalance());
		
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

	public SavingsAccount() {
		super();
	}

	public SavingsAccount(String accNo, String accName, String accType, int noOfYears, double balance) {
		super(accNo, accName, accType, noOfYears, balance);
	}

}
