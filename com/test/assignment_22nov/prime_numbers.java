package com.test.assignment_22nov;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class prime_numbers {

	public static void main(String[] args) {
		List<Integer> prime_numbers = new ArrayList<>();
		IntStream.range(2, 100)		//creating a integer stream from 2 to 99
		    .filter(n -> prime_numbers.parallelStream().allMatch(p -> n % p != 0))	/*
		    *filtering the integer stream
		    *it contains only prime numbers
		    */
		    .forEach(prime_numbers::add);		/*
		    *adding the filtered integer stream to array list
		    */
		    prime_numbers.forEach(System.out::println);	// printing the array list
	}

}
