package com.test.assignment_28nov;

import java.util.Scanner;

public class Reverse_string {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the string to be reversed");
		String s = sc.nextLine();
		char[] r = s.toCharArray();
		for(int i = r.length - 1; i>=0 ; i--){
			System.out.print(r[i]);
		}
	}
}
