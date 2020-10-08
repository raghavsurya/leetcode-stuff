class Solution {
     HashMap<String, Boolean> map = new HashMap();
    public boolean wordBreak(String s, List<String> wordDict) {
        return word_break(s, new HashSet(wordDict), new HashMap<String, Boolean>());
        
    }
    private boolean word_break(String s, Set<String> wordDict,  HashMap<String, Boolean> memo) {
        HashSet<String> set = new HashSet();
       
        if(s.equals("")) return true;
        if(memo.containsKey(s)) {
            return memo.get(s);
        }
        for (String str: wordDict) {
            set.add(str);
        }
        for(int i = 1; i<=s.length(); i++) {
            if(wordDict.contains(s.substring(0, i)) &&
                word_break(s.substring(i, s.length()), set, map)) {
                memo.put(s.substring(i, s.length()), true);
                return true;
            }
        }
        memo.put(s, false);
        return false;
    }
}
