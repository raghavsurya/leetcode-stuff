class Solution {
    public void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) {
                int count = i + 1;
                int counter = count;
                System.out.println(i);
                while (count < nums.length -1 && nums[count] == 0) {
                    count++;
                }
                int temp = nums[count];
                nums[i] = temp;
                nums[count] = 0;
            }
            
        }
    }
}
