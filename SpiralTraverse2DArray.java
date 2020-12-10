import java.util.*;

class Program {
	List<Integer> visitedRowIndex = new ArrayList<Integer>();
	List<Integer> visitedColumnIndex = new ArrayList<Integer>();
  public static List<Integer> spiralTraverse(int[][] array) {
		if(array.length == 0) return new ArrayList<Integer>();
    // Write your code here.
		List<Integer> result = new ArrayList<Integer>();
		
		int startRow = 0;
		int endRow = array.length - 1;
		int startColumn = 0;
		int endColumn = array[0].length - 1;
		
		while(endRow >= startRow && endColumn >= startColumn) {
			for(int i = startColumn; i <= endColumn; i++) {
				result.add(array[startRow][i]);
			}
			for (int i = startRow + 1; i <= endRow; i++) {
				result.add(array[i][endColumn]);
			}
			
			for (int i = endColumn - 1; i >= startColumn ; i--) {
				if(startRow == endRow) break;
				result.add(array[endRow][i]);
			}
			
			for (int i = endRow - 1; i > startRow; i--) {
				if(startColumn == endColumn) break;
				result.add(array[i][startColumn]);
			}
			
			startColumn++;
			startRow++;
			endRow--;
			endColumn--;
		}
			return result;
  }
}
//TC: O(N) - since we are looping through the N number (combined n x m matrix)
//SC: O(n) - cos of the list of integer result

