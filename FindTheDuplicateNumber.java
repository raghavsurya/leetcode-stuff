class Solution {
    public int findDuplicate(int[] nums) {
        int mid = nums.length / 2;
        int left = 0 ;
        int right;
        
       while(left < nums.length){
           right = nums.length - 1;
           while(left < right) {
               if(nums[left] == nums[right]){
                   return nums[left];
               }
               right--;
           }
           left++;
       }
        return nums[left];
        
    }
}
//O(N) ?
//O(1)
