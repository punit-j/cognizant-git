import java.util.*;
public class Hashh {

	public static void main(String[] args) {
	  HashMap<String,Integer> map=new HashMap<String,Integer>();
	  print(map);
	  map.put("Vi",10);
	  map.put("K",20);
	  System.out.println("Size of map:"+ map.size());
	  print(map);
	  if(map.containsKey("Vi"))
	  {
		  Integer n=map.get("Vi");
		  System.out.println("Value at this key is :"+n);
		  
	  }
	}
	  public static void print(Map<String,Integer> map)
	  {
		  if(map.isEmpty())
		  {
			  System.out.println("Map is empty");
			  
		  }
		  else
			  System.out.println(map);
	  }

	}


