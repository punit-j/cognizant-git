package questions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Even_Odd_Number {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number upto which odd even numbers are to be printed");
		int n = sc.nextInt();
		List<Integer> odd_even = new ArrayList<>();
		IntStream.range(1, n).filter(i -> (i%2 == 0)&&(i%4 != 0))
				.forEach(odd_even::add);
		odd_even.forEach(System.out::println);
		
	}

}
