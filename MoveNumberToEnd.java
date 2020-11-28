import java.util.*;

class Program {
  public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
    // Write your code here.
		Integer[] arrayed = new Integer[array.size()];
		for(int i = 0; i < array.size(); i++) {
			arrayed[i] = array.get(i);
		}
		
		for(int index = 0; index < arrayed.length; index++) {
			
			if(arrayed[index] == toMove) {
			
				if(index + 1 < arrayed.length) {
					int j = index + 1;
					while(j < arrayed.length -1 && arrayed[j] == toMove) {
						j++;
					}
				int temp = arrayed[j];
				arrayed[index] = temp;
				arrayed[j] = toMove;
				} 
				
			}
		}
		
    return Arrays.asList(arrayed);
		
  }
	
}
//O(n) time
//O(n) space
