class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramsGrouped = new HashMap();
        List<List<String>> finalOutput = new LinkedList();
        int order = 0;
        for(int i= 0; i< strs.length; i++) {
            char[] c = strs[i].toCharArray();
            Arrays.sort(c);
            String sorted = String.valueOf(c);
            if(!anagramsGrouped.containsKey(sorted)) {
                anagramsGrouped.put(sorted, new ArrayList<>());
            }
            anagramsGrouped.get(sorted).add(strs[i]);
            
            }
            finalOutput.addAll(anagramsGrouped.values());
        return finalOutput;
           
      
    }
}
