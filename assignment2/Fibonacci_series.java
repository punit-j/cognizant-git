package assignment2;

import java.util.Scanner;
import java.util.stream.Stream;

public class Fibonacci_series {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the value of numbers to be printed in fibonacci series");
		int n = sc.nextInt();
		printFibonacciSeries(n);
		
	}

	private static void printFibonacciSeries(int size) {
		Stream.iterate(new int[]{0,1,1,2}, t -> new int[]{t[1],t[2],t[3], t[0]+t[1]+t[2]+t[3]})
		.limit(size)
		.map(t -> t[0])
		.forEach(System.out::println);
	}

}
