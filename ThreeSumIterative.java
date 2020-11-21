import java.util.*;

class Program {
  public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
    // Write your code here.
		List<Integer[]> finalList = new ArrayList<Integer[]> ();
		Arrays.sort(array); //O(nlogn)
		
		for (int left = 0; left < array.length; left++) {
			int leftPlusOne = left + 1; //1
			int right = array.length - 1;
			Integer[] currList;
			while(leftPlusOne < right) {
				if(array[left] + array[leftPlusOne] + array[right] == targetSum) {
						finalList.add(new Integer[]{array[left], array[leftPlusOne], array[right]});
				}
				if(array[left] + array[leftPlusOne] + array[right] > targetSum) {
						right--;
				} else {
				leftPlusOne++;
				}
			
			}
		}
    return finalList;
  }
}
//O(n^2) TC
// O(n) SC
