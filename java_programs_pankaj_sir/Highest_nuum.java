package java_programs_pankaj_sir;

import java.util.Scanner;

public class Highest_nuum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] num = new int[3];
		System.out.println("Enter the three numbers to find the largest from");
		for(int i =0; i<num.length; i++){
			num[i]=sc.nextInt();
		}
		highestNumber(num);
	}

	private static void highestNumber(int[] num) {
		int x = num[0];
		for(int y=0;y<num.length; y++){
			if(x < num[y])
				x = num[y];
		}
		System.out.println("largest number is " + x);
	}

}
