import java.util.*;

class Program {
  public static int[] bubbleSort(int[] array) {
    // Write your code here.
		
		boolean isSwapped = performBubbleSort(array);
		while(isSwapped) {
    	isSwapped = performBubbleSort(array);
		}
		return array;
  }
	private static boolean performBubbleSort(int[] array) {
		boolean isSwapDone = false;
		int i = 0;
		while(i < array.length) {
			if(i + 1 < array.length && array[i] > array[i + 1]) {
				isSwapDone = true;
				int temp = array[i+1];
				array[i+1] = array[i];
				array[i] = temp;
			}
			i++;
		}
		return isSwapDone;
	}
}
//Time complexity: Best case - O(n) cos if we are given a sorted array then we only need to loop through the array once
//Time complexity: Worst case - O(n^2) We have to loop through the array multiple times to do the swaps
//Space Complexity: O(1) cos we swap variables in place
