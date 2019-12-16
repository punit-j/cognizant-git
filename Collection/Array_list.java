import java.util.ArrayList;

public class Array_list {

	public static void main(String[] args) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		System.out.println(al.isEmpty());
		al.add(5);
		al.add(4);
		al.add(3);
		System.out.println(al);
		System.out.println(al.size());
		ArrayList<Integer> al2 = new ArrayList<Integer>();
		al2.add(5);
		al2.add(4);
		System.out.println(al2);
		al.retainAll(al2);
		System.out.println(al.containsAll(al2));
		System.out.println(al);
		System.out.println(al2);
        al.clear();
		System.out.println(al);
		al.add(7);
		al.addAll(1,al2);
		System.out.println(al);
        
		al.remove(1);
		System.out.println(al);

		System.out.println(al.get(1));
		System.out.println(al);
		System.out.println(al.indexOf(4));

	}

}
