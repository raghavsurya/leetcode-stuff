import java.util.*;

class Program {
  public static int[] selectionSort(int[] array) {
    // Write your code here.
		for(int i = 0; i < array.length; i++) {
			int index = i + 1;
			int indexToSwap = i;
			while(index < array.length) {
				if(array[indexToSwap] > array[index]) {
					indexToSwap = index;
				}
				index++;
			}
			if(indexToSwap != i){
				int temp = array[indexToSwap];
				 array[indexToSwap] = array[i];
				array[i] = temp;
			}
		}
    return array;
  }
}
//O(1) SC
//O(N^2) TC
