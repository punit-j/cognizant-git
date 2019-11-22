package questions;
import java.util.stream.Stream;
public class fibonacci_series {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int size = 50;
		Stream.iterate(new int[]{0,1}, t -> new int[]{t[1], t[0]+t[1]})
		.limit(size)
		.map(t -> t[0])
		.forEach(System.out::println);
	}

}
