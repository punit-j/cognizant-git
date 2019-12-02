package com.test.banking;

import java.util.Scanner;

public class Bank {

	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		System.out.println("Enter Account Type(saving/current)");
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
		if(accType.equals("saving")) {
			
			sa.setAccType(accType);
			sa.setAccNo(accNo);
			sa.setBalance(balance);
			sa.setNoOfYears(noOfYears);
			sa.setAccName(accName);
			System.out.println("The Interest for "+sa.getAccName()+" of account type "+sa.getAccType()+" is "+sa.calculateInterest());
		}else if("current".equals(accType)) {
		
			ca.setAccType(accType);
			ca.setAccNo(accNo);
			ca.setBalance(balance);
			ca.setNoOfYears(noOfYears);
			ca.setAccName(accName);
			System.out.println("The Interest for "+ca.getAccName()+" of account type "+ca.getAccType()+" is "+ca.calculateInterest());
		}else {
			System.out.println("Wrong Entries");
		}

		System.out.println("What do you want to do(withdrawl/deposit/show balance/transfer)");
		String command = sc.next();
		
		System.out.println("Enter the amount");
		float amount = sc.nextFloat();
		
		if(command.equals("withdrawl")) {
			if(accType.equals("saving")) {
				sa.withdrawl(amount);
			}else {
				ca.withdrawl(amount);
			}
		}
		
		if(command.equals("deposit")) {
			if(accType.equals("saving")) {
				sa.deposit(amount);
			}else {
				ca.deposit(amount);
			}
	}
		
		if(command.equals("show")) {
			if(accType.equals("saving")) {
				sa.showBalance(sa);;
			}else {
				ca.showBalance(ca);
			}
		}
		
		if(command.equals("transfer")) {
			
			
			System.out.println("Enter Account Number to transfer to");
			String accNo2 = sc.next();
			System.out.println("Enter Account Name");
			String accName2 = sc.next();
			System.out.println("Enter Balance");
			int balance2 = sc.nextInt();
			SavingsAccount toAcc = new SavingsAccount(accNo2, accName2, accType, 0, balance2);
			
			sa.transfer(toAcc, sa, amount);
		}

}}
