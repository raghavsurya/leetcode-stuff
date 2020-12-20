//TC: O(nLog(n))
//SC: O(n)Log(n)

import java.util.*;
import java.util.Arrays;		


class Program {
  public static int[] mergeSort(int[] array) {
   if(array.length <= 1) {
		 return array;
	 }
		int mid = array.length / 2;
		int[] leftHalf = Arrays.copyOfRange(array, 0, mid);
		int[] rightHalf = Arrays.copyOfRange(array, mid, array.length);
		return mergeArrays(mergeSort(leftHalf), mergeSort(rightHalf));
  }
	private static int[] mergeArrays(int[] leftHalf, int[] rightHalf) {
		int k = 0;
		int i = 0;
		int j = 0;
		int[] sortedArray = new int[leftHalf.length + rightHalf.length];
		
		while(i < leftHalf.length && j < rightHalf.length) {
			if(leftHalf[i] <= rightHalf[j]) {
				sortedArray[k++] = leftHalf[i++];
			} else {
				sortedArray[k++] = rightHalf[j++];
			}
		}
		
		while(i < leftHalf.length) {
			sortedArray[k++] = leftHalf[i++];
		}
		while(j < rightHalf.length) {
			sortedArray[k++] = rightHalf[j++];
		}
		return sortedArray;
	}
	
}
