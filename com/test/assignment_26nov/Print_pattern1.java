package com.test.assignment_26nov;

public class Print_pattern1 {

	public static void main(String[] args) {
		int temp = 5;
		for(int i = 1; i <= temp; i++){	//outer loop for number of lines having pattern in ascending order to be printed
			for(int j = temp-i; j>1; j--){	//inner loop to insert the required spaces
				System.out.print(" ");
			}
			for(int y = 1; y<=i; y++){	//inner loop to print the asterix in the ascending order
				System.out.print("* ");	// prints asterix
			}
			System.out.println();	//inserts new line
		}
	      for (int i = temp-1; i >= 1; i--){	//outer loop for number of lines having pattern in descending order to be printed
	    	  for(int j = temp-i; j>1; j--){	//inner loop to insert the required spaces
					System.out.print(" ");
				} 
	    	  for (int j = 1; j <= i; j++){	//inner loop to print the asterix in the descending order
	                System.out.print("* ");	//prints asterix
	            }	
	         System.out.println();	//inserts new line
	        }
	}

}
