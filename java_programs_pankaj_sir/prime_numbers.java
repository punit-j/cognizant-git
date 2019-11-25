package java_programs_pankaj_sir;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class prime_numbers {

	public static void main(String[] args) {
		List<Integer> prime_numbers = new ArrayList<>();
		IntStream.range(2, 100)
		    .filter(n -> prime_numbers.parallelStream().allMatch(p -> n % p != 0))
		    .forEach(prime_numbers::add);
		    prime_numbers.forEach(System.out::println);
	}

}
