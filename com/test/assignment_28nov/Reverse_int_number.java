package com.test.assignment_28nov;

import java.util.Scanner;

public class Reverse_int_number {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number to be reversed");
		int n = sc.nextInt();
		printReverseInt(n);
	}

	private static void printReverseInt(int n) {
		int x = 0;
		for(int i=0 ; i<=100; i++){
			x = x*10 + n%10;
			n = n/10;
			if(n==0){
				break;
			}
		}
		System.out.println("Reversed number: "+x);
	}

}
