class Solution {
    public int[] productExceptSelf(int[] nums) {
        int i = 0;
        int product = 0;
        int[] output = new int[nums.length];
        while(i < nums.length) {
            var temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;
            
            if(i < nums.length) product = nums[1];
            
            for (int count = 1; count < nums.length - 1; count++) {
                product = product * nums[count + 1];
                
            }
            output[i] = product;
            i++;
        }
        return output;
    }
}
