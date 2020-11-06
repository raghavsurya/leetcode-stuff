
/*
    Time complexity: on average O(log⁡2N)\mathcal{O}(\log_{2}{N})O(log2​N) where NNN is the length of the array, since in general it is a binary search algorithm. However, in the worst case where the array contains identical elements (i.e. case #3 nums[pivot]==nums[high]), the algorithm would deteriorate to iterating each element, as a result, the time complexity becomes O(N)\mathcal{O}(N)O(N).

    Space complexity : O(1)\mathcal{O}(1)O(1), it's a constant space solution.
*/

class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length -1;
        
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] > nums[right]) {
                left = mid + 1;
            } else if(nums[mid] < nums[right]) {
                right = mid;
            } 
            else {
                right = right -1;
            }
        }
        return nums[left];
   
    }
}
