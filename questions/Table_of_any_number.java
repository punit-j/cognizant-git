package questions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Table_of_any_number {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter the number whose table is to be printed");
		int n = sc.nextInt();
		List<Integer> table = new ArrayList<>();
		IntStream.range(1, 11).forEach(i -> table.add(i*n));
		table.forEach(System.out::println);
	}

}
