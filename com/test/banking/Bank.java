package com.test.banking;

import java.util.Scanner;

/**
 * Contains main method Takes input from user and does the required
 * functionality
 * 
 * @author 765337
 *
 */
public class Bank {

	public static void main(String[] args) throws MyException {
		Account account = enterDetails(); // to enter details of the account
		executeCommand(account); // to execute any command

	}

	private static void executeCommand(Account account) throws MyException {
		Scanner sc = new Scanner(System.in);
		System.out.println("What do you want to do(withdrawl/deposit/show balance/transfer/calculate interest)"); // User
																													// input
																													// for
																													// command
																													// to
																													// be
																													// executed
		String command = sc.next();

		if (command.equals("calculate")) { // to calculate interest
			System.out.println("The Interest for " + account.getAccName() + " of account type " + account.getAccType()
					+ " is " + account.calculateInterest());
		}

		if (command.equals("withdrawl")) { // for withdrawal
			System.out.println("Enter the amount"); // Enter the amount
			float amount = sc.nextFloat();
			account.withdrawl(amount);
		}

		if (command.equals("deposit")) { // to deposit money
			System.out.println("Enter the amount"); // Enter the amount
			float amount = sc.nextFloat();
			account.deposit(amount);
		}

		if (command.equals("show")) { // To show balance
			account.showBalance(account);
		}

		if (command.equals("transfer")) { // To transfer funds from 1 account to another
			System.out.println("Enter the amount"); // Enter the amount
			float amount = sc.nextFloat();
			System.out.println("Enter Account Number to transfer to"); // user input for the account to which funds are
																		// to be transfered
			String accNo2 = sc.next();
			System.out.println("Enter Account Name");
			String accName2 = sc.next();
			System.out.println("Enter Balance");
			int balance2 = sc.nextInt();
			SavingsAccount toAcc = new SavingsAccount(accNo2, accName2, account.getAccType(), 0, balance2);

			account.transfer(toAcc, account, amount);
		}

	}

	private static Account enterDetails() throws MyException { // to enter details of the account
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Account Type(saving/current)"); // Details of the account to be entered
		String accType = sc.next();
		System.out.println("Enter Account Number");
		String accNo = sc.next();
		System.out.println("Enter Account Name");
		String accName = sc.next();
		System.out.println("Enter Number of Years");
		int noOfYears = sc.nextInt();
		System.out.println("Enter Balance");
		int balance = sc.nextInt();

		Account sa = new SavingsAccount();
		Account ca = new CurrentAccount();
		if (accType.equals("saving")) { // Saving the details of savings account

			sa.setAccType(accType);
			sa.setAccNo(accNo);
			sa.setBalance(balance);
			sa.setNoOfYears(noOfYears);
			sa.setAccName(accName);
			return sa;
		} else if ("current".equals(accType)) { // Saving the details of the current account

			ca.setAccType(accType);
			ca.setAccNo(accNo);
			ca.setBalance(balance);
			ca.setNoOfYears(noOfYears);
			ca.setAccName(accName);
			return ca;
		} else {
			throw new MyException("Wrong Entries"); // throws exception
		}
	}
}
