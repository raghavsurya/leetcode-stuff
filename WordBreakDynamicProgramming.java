class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] dp = new Boolean[s.length() + 1];
        dp[0] = true;
        for (int len = 1; len <= s.length(); len++) {
            for (int i = 0; i < len; i++) {
                if(dp[i] && wordDict.contains(s.substring(i, len))) {
                    dp[len] = true;
                    break;
                }
                else {
                    dp[len] = false;
                }
            }
        }
        return dp[s.length()];
    }
}
