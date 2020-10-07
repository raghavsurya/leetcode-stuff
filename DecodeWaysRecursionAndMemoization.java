class Solution {
    public int numDecodings(String s) {
        HashMap<Integer, Integer> memo = new HashMap();
        if (s == null || s.isEmpty()) return 0;
        
        return callRecursively(s.length() -1, s, memo);
        
    }
    
    public int callRecursively(int index, String s, HashMap<Integer, Integer> memo) {
        int ways = 0;
        if(index == 0) {
            
            if (s.charAt(index) == '0') {
                memo.put(index, 0);
                return 0;
            }
            else {
                memo.put(index, 1);
                return 1;
            }
        }
        if(index == -1) {
            return 1;
        }
            
        if(s.charAt(index) == '0') {
                if (s.charAt(index-1) == '1' || s.charAt(index-1) == '2' ) {
                if(memo.containsKey(index - 2)) return memo.get(index-2);
                ways = callRecursively(index - 2, s, memo);
                memo.put(index - 2, ways);
                return memo.get(index - 2);
            }
            else {
                return 0;
            }
        }
        
        if(s.charAt(index - 1) == '1' || (s.charAt(index - 1) == '2' && Character.getNumericValue(s.charAt(index)) < 7)) {
            if(memo.containsKey(index)) return memo.get(index);
            ways = callRecursively(index - 1, s, memo) + callRecursively(index - 2, s, memo);
             memo.put(index, ways);
        } else {
            if(memo.containsKey(index - 1)) {
               return memo.get(index - 1);
            } else {
             ways = callRecursively(index - 1, s, memo) ;
           
            }
        }
       
        return ways;
    }
}


