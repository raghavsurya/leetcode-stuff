class Solution {
    public boolean isPalindrome(String s) {
        if (s.isEmpty()) return true;
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i <= s.length() -1) {
            if (charIsAlphaNumeric(s.charAt(i))) {
                sb.append(s.charAt(i));
            }
            i++;
        }
        String something = sb.toString();

        return something.equalsIgnoreCase(sb.reverse().toString());
        
    }
    private boolean charIsAlphaNumeric(char c) {
        if (Character.isDigit(c) || Character.isLetter(c)) {
            return true;
        }
        return false;
        
    }
}
