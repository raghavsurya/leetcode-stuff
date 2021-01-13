//TC: O(N) N being the length of the array
//SC: O(1)

import java.util.*;

class Program {
  public static int maxSubsetSumNoAdjacent(int[] array) {
		if(array == null || array.length == 0 ) return 0;
		if(array.length == 1 ) return array[0];
   int maxSum = Integer.MIN_VALUE;
		
		int first  = array[0]; //75
		int second = Math.max(array[0], array[1]); //105
		int current = 0;
		for(int i = 2; i < array.length; i++) {
			current = Math.max(second, (first + array[i]));
			first = second;
			second = current;
			
		}
		return second;
  }
}
