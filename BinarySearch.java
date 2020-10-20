/* 
Time Complexity : O(log n)
n -> n/2 -> n/4 -> n/8 ... ~1

=> n/2pow1, n/2pow2, n/2pow3 ... ~1
let's say n = 8. so n/2pow3 = 1
8 = 2pow3
n = 2powx
x = log n (to base 2)

Space Complexity : O(1)

*/
class Solution {
    public int search(int[] nums, int target) {
        int left  = 0;
        int right = nums.length -1;
        while(left <= right) {
            int mid = (left + right) / 2;
            
            if(nums[mid] == target) {
                return mid;
            }
            
            else if(target > nums[mid]) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
