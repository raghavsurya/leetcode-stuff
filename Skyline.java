//O(nLog(n)) time complexity
//O(n) space since we are using the same output array / list



class Solution {
  /**
   *  Divide-and-conquer algorithm to solve skyline problem,
   *  which is similar with the merge sort algorithm.
   */
  public List<List<Integer>> getSkyline(int[][] buildings) {
        int n = buildings.length;
      ArrayList<List<Integer>> output = new ArrayList<List<Integer>>();
      
      if(n == 0) 
          return output;
       if(n == 1) {
          int x1 = buildings[0][0];
          int x2 = buildings[0][1];
          int height =  buildings[0][2];
          
          output.add(new ArrayList<Integer>() {{add(x1); add(height);}});
          output.add(new ArrayList<Integer>() {{add(x2); add(0);}});
           return output;
      }
      
      List<List<Integer>> leftSkyline, rightSkyline;
      leftSkyline = getSkyline(Arrays.copyOfRange(buildings, 0, n/2));
      rightSkyline =getSkyline(Arrays.copyOfRange(buildings, n/2, n));
      
      return mergeSkylines(leftSkyline, rightSkyline);
      
  }
    private List<List<Integer>> mergeSkylines(List<List<Integer>> left, List<List<Integer>>right) {
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        int pL = 0, pR = 0;
        int x = 0, maxY = 0, leftY = 0, rightY = 0, currY = 0;
        
        while(pL < left.size() && pR < right.size()) {
            List<Integer> pointL = left.get(pL);
            List<Integer> pointR = right.get(pR);
            if(pointL.get(0) < pointR.get(0)) {
               x = pointL.get(0) ;
                leftY = pointL.get(1);
                pL++;
            } else {
                x = pointR.get(0) ;
                rightY = pointR.get(1);
                pR++;
            }
            
            maxY = Math.max(leftY, rightY);
            if(currY != maxY) {
                updateOutput(output, x, maxY);
                currY = maxY;
            }
            
           
        }
         appendSkyline(output, left, pL, currY, left.size());
            appendSkyline(output, right, pR, currY, right.size());
        return output;
    }
    
    private void updateOutput(List<List<Integer>> output, int x, int maxY) {
        if(output.isEmpty() || output.get(output.size() - 1).get(0) != x) {
            output.add(new ArrayList<Integer>() {{ {add(x); add(maxY); }}});
        } else {
            output.get(output.size() - 1).set(1, maxY);
        }
    }
    
    private void appendSkyline(List<List<Integer>> output, List<List<Integer>> skyline, int pointer, int currY, int n) {
        while(pointer < n) {
            List<Integer> point = skyline.get(pointer);
            int x = point.get(0);
            int y = point.get(1);
            pointer++;
            
            
        if(currY != y) {
            updateOutput(output, x, y);
            currY = y;
        }
        }
        
    }
}
