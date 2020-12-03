import java.util.*;

class Program {
  // Tip: You can use `element instanceof ArrayList` to check whether an item
  // is an array or an integer.
  public static int productSum(List<Object> array) {
    // Write your code here.

		return recursiveSum(array, 1);
  }
	
	private static int recursiveSum(List<Object> array, int depthCount) {
		int sum = 0;
		
		for(Object thing: array) {
				if (thing instanceof ArrayList) {
					@SuppressWarnings("unchecked")
					ArrayList intList = (ArrayList) thing;
					sum += recursiveSum(intList, depthCount + 1);
      	}
				
			 else if(thing instanceof Integer) {
				sum += (int)thing;
			}
		}
    return sum * depthCount;
	
	}
}

//O(n) - number of elements in the array
//O(d) - greatest depth of the special arrays in the array
