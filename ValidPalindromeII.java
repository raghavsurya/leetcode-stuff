//TC: O(n)
//SC: O(1) constant

class Solution {
    public boolean validPalindrome(String s) {
        int i = 0;
        int right = s.length() - 1;
        
        while(i < right) {
            if(s.charAt(i) != s.charAt(right)) {
                return isValindrome(s, i+1, right) || isValindrome(s, i, right - 1);
            }
            right--;
            i++;
        }
        return true;
    }
    private boolean isValindrome(String s, int start, int end) {
        while(start < end) {
            if(s.charAt(start) != s.charAt(end)) {
                return false;
            }
            end--;
            start++;
        }
        return true;
    }
}
