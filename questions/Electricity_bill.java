package questions;

import java.util.Scanner;

public class Electricity_bill {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the units consumed");
		int unit = sc.nextInt();
		int price = 0;
		if(unit<100){
			price = unit*10;
	}else if(unit<200){
		price = 100*10 +(unit-100)*20;
	}else {
		price = 100*10 + 200*20 + (unit-200)*30;
	}
		System.out.println("The cost is:"+ price);
}}
