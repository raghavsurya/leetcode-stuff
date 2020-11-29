import java.util.*;

class Program {
  public static boolean isMonotonic(int[] array) {
		if(array == null || array.length == 0) return true;
    // Write your code here.
	
		int left = 0;
		int right = array.length -1;
		Boolean increasing = null;
		
		while (left < right ) {
			if(left + 1 == right) return true;
			if(array[left] != array[left+1] ) {
				increasing = array[left] < array[left + 1];
				left++;
				break;
			}
			left++;
		} 
		System.out.println(increasing);
		System.out.println(left);
		
		while(left < right) {
			
			if(increasing && array[left] > array[left+1]) {
				return false;
			} else if(!increasing && array[left] < array[left+1]) {
					return false;
			}
			else {
				left++;
			}
		}
		return true;
  }
}
//O(n) sc
//O(1) tc
