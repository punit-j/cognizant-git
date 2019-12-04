package com.test.banking;

/**
 * Contains method to calculate interest for current account
 * 
 * @author 765337
 *
 */
public class CurrentAccount extends Account {

	private int noOfTransactionPerMonth;

	float calculateInterest() throws MyException { // Calculates Interest
		if (getNoOfTransactionPerMonth() < 8) {
			return (float) ((getBalance() * getNoOfYears() * 3) / 100);
		} else {
			throw new MyException("Max. transaction limit reached, so no interest can be calculated");
		}
	}

	public int getNoOfTransactionPerMonth() {
		return noOfTransactionPerMonth;
	}

	public void setNoOfTransactionPerMonth(int noOfTransactionPerMonth) {
		this.noOfTransactionPerMonth = noOfTransactionPerMonth;
	}

	@Override
	void withdrawl(float amount) throws MyException { // Withdrawal for current account
		if (amount > getBalance()) {
			throw new MyException("Balance is not enough");
		} else {
			setBalance(getBalance() - amount);
			System.out.println("New balance is " + getBalance());
			noOfTransactionPerMonth++;
		}
	}

	@Override
	void deposit(float amount) { // Deposit for current account
		setBalance(amount + getBalance());
		System.out.println("New balance is " + getBalance());
		noOfTransactionPerMonth++;
	}

	void transfer(Account toAcc, Account fromAcc, float amount) throws MyException { // transfers money from 1 account
		// to another for current account
		if (fromAcc.getBalance() < amount) {
			throw new MyException("Insufficient Funds");
		} else {
			fromAcc.setBalance(fromAcc.getBalance() - amount);
			toAcc.setBalance(toAcc.getBalance() + amount);
			System.out.println("New balance in account name " + toAcc.getAccName() + " is " + toAcc.getBalance()
					+ " and in account name " + fromAcc.getAccName() + " is " + fromAcc.getBalance());
			noOfTransactionPerMonth++;
		}

	}

	public CurrentAccount() { // Default Constructor
		super();
	}

	public CurrentAccount(String accNo, String accName, String accType, int noOfYears, double balance) { // Constructor
																											// invoking
																											// super
																											// class
																											// constructor
		super(accNo, accName, accType, noOfYears, balance);
	}

}
