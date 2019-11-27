package com.test.assignment_22nov;

import java.util.Scanner;

public class Highest_nuum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] num = new int[3];
		System.out.println("Enter the three numbers to find the largest from");
		for(int i =0; i<num.length; i++){
			num[i]=sc.nextInt();	//user input for the 3 numbers in an array
		}
		highestNumber(num);			//highestNumber(num) method call
	}

	private static void highestNumber(int[] num) {/**
	*method to print highest number
	*/
		int x = num[0];	//assigning the first number in the array to a variable
		for(int y=0;y<num.length; y++){
			if(x < num[y])		///checking if the array contains any other number greater than x
				x = num[y];		// assigning the number to x
		}
		System.out.println("largest number is " + x);	/**
		*printing highest number
		*@return null
		*/
	}

}
