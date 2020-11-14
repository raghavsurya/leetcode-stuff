import java.util.*;

class Program {
	static Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	
 

 public static int getNthFib(int n) {
		if(map.containsKey(n)) {
			return map.get(n);
		}
		
   if(n == 2) {
		 return 1;
	 } else if(n == 1) {
		 return 0;
	 } else {
		 System.out.println("how many times");
		int answer = getNthFib(n-1) + getNthFib(n-2);
		 map.put(n, answer);
	 }
		return map.get(n);
  }

}
