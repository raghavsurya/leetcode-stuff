class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums.length <= 1) return false;
       
        boolean arrayDecoded = false;
        HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        for (int i = 0; i< nums.length -1; i++) {
                if(k == 0) {
                    if((nums[i] + nums[i+1]) == 0) {
                        return true;
                    }
                    else {
                        continue;
                    }
                }
                else if((nums[i] + nums[i+1]) % k == 0) {
                    arrayDecoded = true;
                    return true;
                }
                else {
                    int leftAccValues =  nums[i + 1];
                    int rightPtr = i + 1;
                    while (rightPtr < nums.length -1  && !arrayDecoded) {
                        leftAccValues += nums[++rightPtr];
                         if((leftAccValues  + nums[i]) % k == 0) {
                            arrayDecoded = true;
                             break;
                        }
                    }
                   
                        
                }
            if(arrayDecoded) return true;
        }
        return false;
    }
}
