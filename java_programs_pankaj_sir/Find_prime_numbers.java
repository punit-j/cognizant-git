package java_programs_pankaj_sir;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Find_prime_numbers {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number to check prime");
		int num = sc.nextInt();
		if (primeNumber(num)){
			System.out.println(num + " is a prime number");
		}else{
			System.out.println(num + " is not a prime number");
		}
	}

	private static boolean primeNumber(int num) {
		List<Integer> prime_numbers = new ArrayList<>();
		IntStream.range(2, 1000)
		    .filter(n -> prime_numbers.parallelStream().noneMatch(p -> n % p == 0))
		    .forEach(prime_numbers::add);
		return prime_numbers.contains(num);
	}

}
