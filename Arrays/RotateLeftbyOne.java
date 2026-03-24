class Solution {
    public void rotateArrayByOne(int[] nums) {
    //Initializing temp variable
        int temp = nums[0];
        //Starting loop condition from to handle Edge cases
        for(int i = 1; i < nums.length; i++) {
        nums[i - 1] = nums[i];
        }
        //Storing temp value at last
        nums[nums.length - 1] = temp;
    }
}//o(n),o(1)