class Solution {
    public int myAtoi(String s) {
        StringBuilder sb = new StringBuilder();
        int returnValue = 0;
        int sign = 1;
            int i = 0;
        while(i < s.length() && s.charAt(i) == ' ') 
            i++;
           
            if(i < s.length() && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
              sign = s.charAt(i++) == '+' ? 1 : -1;
            }
        long res = 0;
           while(i < s.length() && Character.isDigit(s.charAt(i))) {
              res = res * 10 + s.charAt(i++) - '0';
               if(res * sign > Integer.MAX_VALUE || res * sign < Integer.MIN_VALUE) {
                   return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
               }
           }
            
    
        return (int) res * sign;
    }
}

//O(n)
//O(1)
