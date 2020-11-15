import java.util.*;

class Program {
  public static int binarySearch(int[] array, int target) {
    // Write your code here.
		int left = 0;
		int right = array.length - 1;
		while(left < right) {
			int mid = left + (right - left) / 2;
			if(array[mid] == target) {
				return mid;
			} else if(array[mid] > target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
    return array[left] == target ? left : -1;
  }
}
//O(logn)
//O(1)
