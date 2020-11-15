import java.util.*;

class Program {
  public static int getNthFib(int n) {
    // Write your code here.
		int[] fibonacciSum = new int[]{0, 1};
		int counter = 3;
		int sum = 0;
		while(counter <= n) {
			sum = fibonacciSum[0] + fibonacciSum[1];
			fibonacciSum[0] = fibonacciSum[1];
			fibonacciSum[1] = sum;
			counter++;
		}
    return n > 1 ? fibonacciSum[1] : fibonacciSum[0];
  }
}

//O(n) |tc
//O(1) |sc
