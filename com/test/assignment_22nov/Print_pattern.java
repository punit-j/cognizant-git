package com.test.assignment_22nov;

public class Print_pattern {

	public static void main(String[] args) {
		int temp = 4;
		for(int i = 0; i < temp; i++){	//outer loop for number of lines to be printed
			for(int y = 0; y<=i; y++){	//inner loop to print the asterix in the required fashion
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
