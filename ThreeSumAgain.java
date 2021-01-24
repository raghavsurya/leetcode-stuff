//TC: O(nlogn + n^2) -> sorting + 2 loops
//SC: O(n) for the hashset

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> finalList = new ArrayList();
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet();
        for(int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
                while(j < k) {
                    if(nums[i] + nums[j] + nums[k] == 0) {
                            List<Integer> intList = new ArrayList<Integer>();
                            Integer[] matchedArray = new Integer[] {nums[i], nums[j], nums[k]};
                            
                            intList = Arrays.asList(matchedArray);
                            if(!set.contains(intList)) {
                                set.add(intList);
                                finalList.add(intList);    
                            }
                        j++;
                        k--;
                    }
                     else if(nums[j] + nums[k] + nums[i] > 0) {
                               k--;
                            } 
                    else {
                        j++;
                    }
                }
        }
        return finalList;
    }
}
