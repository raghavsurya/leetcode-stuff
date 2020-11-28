import java.util.*;

class Program {
  public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
    // Write your code here.
		
		for(int index = 0; index < array.size(); index++) {
			
			if(array.get(index) == toMove) {
			
				if(index + 1 < array.size()) {
					int j = index + 1;
					while(j < array.size() -1 && array.get(j) == toMove) {
						j++;
					}
				int temp = array.get(j);
					array.set(index, temp);
					array.set(j, toMove);
				} 
				
			}
		}
		
    return array;
		
  }
	
}
//O(n)
//O(1)
