//O(2n) => O(n) time since we are looping through twice once from left to right and another from right to left
//O(n) space since we

import java.util.*;
class Program {
  public int[] arrayOfProducts(int[] array) {
    // Write your code here.
		if(array == null || array.length == 0) return new int[] {};
    int[] arrayOfProds = new int[array.length];
		int leftRunningProduct = 1;
		for(int i = 0; i < array.length; i++) {
			arrayOfProds[i] = leftRunningProduct;
			leftRunningProduct *=  array[i];
		}
		
		int rightRunningProduct = 1;
		for(int i = array.length - 1; i  >= 0 ; i--) {
			arrayOfProds[i] *= rightRunningProduct;
			rightRunningProduct *= array[i];
		}
	
		return arrayOfProds;
  }
}
