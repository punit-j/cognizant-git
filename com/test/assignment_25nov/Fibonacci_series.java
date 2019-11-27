package com.test.assignment_25nov;

import java.util.Scanner;
import java.util.stream.Stream;

public class Fibonacci_series {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the value of numbers to be printed in fibonacci series");
		int n = sc.nextInt();	//user input for limiting the numbers to be printed
		printFibonacciSeries(n);
		
	}

	private static void printFibonacciSeries(int size) {/**
	*to print fibonacci series
	*/
		Stream.iterate(new int[]{0,1,1,2}, t -> new int[]{t[1],t[2],t[3], t[0]+t[1]+t[2]+t[3]})/*
		*iterating the stream having array to he required array containing last element as the sum
		*/
		.limit(size)//limiting the number of the arrays formed
		.map(t -> t[0])//mapping the fist element of the array to a single element
		.forEach(System.out::println);	/**
		*printing the stream formed
		*@return null
		*/
	}

}
