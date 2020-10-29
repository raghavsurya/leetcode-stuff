import java.util.*;

class Program {
  public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
    // Write your code here.
		if(sequence.size() > array.size()) return false;
		int i = 0;
		int j = 0;
		boolean isSubset = false;
		while(i < sequence.size() && j < array.size()) {
				if(array.get(j) == sequence.get(i)) {
					i++;
				}
				j++;
		}
		return i == sequence.size();
  }
}
//O(n) space, O(1) constant time
