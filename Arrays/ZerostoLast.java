class Solution {
    public void moveZeroes(int[] nums) {
        int j = 0;//lastNonZeroFoundAt does not literally store the index of a zero,
        //  but it effectively points to the first position in the array that currently contains a zero and where the next non-zero element should go.
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
    }
}//o(1)