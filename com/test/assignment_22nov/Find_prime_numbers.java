package com.test.assignment_22nov;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Find_prime_numbers {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number to check prime");
		int num = sc.nextInt();	//user input of the number to be checked for prime
		if (primeNumber(num)){	//calling method primeNumber(num) to check if num is a prime number
			System.out.println(num + " is a prime number");	//printing if num is a prime number
		}else{
			System.out.println(num + " is not a prime number");
		}
	}

	private static boolean primeNumber(int num) {/**
	*method to find if given number is prime or not
	*/
		List<Integer> prime_numbers = new ArrayList<>();
		IntStream.range(2, 1000)
		    .filter(n -> prime_numbers.parallelStream().noneMatch(p -> n % p == 0))	/*
		    *filtering integer stream so that it contains only prime number
		    */
		    .forEach(prime_numbers::add);	//adding the integer stream to array list prime_numbers
		return prime_numbers.contains(num);	/**
		*checking if prime_numbers contain the required number
		*@return boolean
		*/
	}

}
