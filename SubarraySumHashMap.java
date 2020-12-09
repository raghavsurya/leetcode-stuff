class Solution {
    public int subarraySum(int[] nums, int k) {
      int result = 0;
        int cumulativeSum = 0;
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0,1);
        
        for(int i = 0; i < nums.length; i++) {
            cumulativeSum += nums[i];
            if(map.containsKey(cumulativeSum - k)) {
                result += map.get(cumulativeSum - k);
            }
            map.put(cumulativeSum, map.getOrDefault(cumulativeSum, 0) + 1);
        }
        return result;
    }
}

//O(n) suaray is traversed only once
//O(n) - hashmap size
