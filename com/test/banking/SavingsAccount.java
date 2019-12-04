package com.test.banking;

/**
 * Contains method to calculate interest for savings account having required
 * minimum balance
 * 
 * @author 765337
 *
 */
public class SavingsAccount extends Account {

	private float minBalance = 5000;

	public float getMinBalance() {
		return minBalance;
	}

	public void setMinBalance(float minBalance) {
		this.minBalance = minBalance;
	}

	float calculateInterest() { // Calculates interest
		double noOfYears = getNoOfYears();
		double balance = getBalance();
		if (getBalance() > getMinBalance()) {
			if (getBalance() > 200000) {
				return (float) ((noOfYears * balance * 4) / 100);
			} else {
				return (float) ((noOfYears * balance * 3.5) / 100);
			}
		} else {
			return 0;
		}
	}

	public SavingsAccount() { // Default Constructor
		super();
	}

	public SavingsAccount(String accNo, String accName, String accType, int noOfYears, double balance) { // Constructor
																											// invoking
																											// super
																											// class
																											// constructor
		super(accNo, accName, accType, noOfYears, balance);
	}

}
