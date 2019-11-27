package com.test.assignment_22nov;

import java.util.Scanner;

public class Electricity_bill {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the units consumed");
		int unit = sc.nextInt();	//user input for units consumed
		int price = 0;	
		if(unit<100){	/*
		*if-else loop to test the units consumed 
		*and assign price for the same
		*/
			price = unit*5;
	}else if(unit<200){
		price = 100*5 +(unit-100)*10;
	}else {
		price = 100*5 + 200*10 + (unit-200)*20;
	}
		System.out.println("The cost is:"+ price);	//printing the cost of units
}}
