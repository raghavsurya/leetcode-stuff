//Time complexity: O(log n)
//Space Complexity: O(1)

class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        
        //find out the index where the array was rotated.
        //Why? because then you can find out which side of BT you want to focus on searching. See step 2
        while(left < right) {
            mid = left + (right - left) / 2;
            if(nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        int start = left;
        left = 0;
        right = nums.length - 1;
        
        //this is to determine which side of the array you want to do the binary search
        //i.e [4,5,6,7] or [0,1,2]
        if(target >= nums[start] && target <= nums[right]) {
            left = start;
        }
        else {
            right = start;
        }
        
        //normal binary search
        while(left <= right) {
            mid = left + (right - left) / 2;
            if(nums[mid] == target) return mid;
            if(nums[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return -1;
    }
}


