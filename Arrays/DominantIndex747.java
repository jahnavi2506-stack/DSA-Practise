//747
class Solution {
    public int dominantIndex(int[] nums) {
        int max = -1;
        int secondmax = -1;
        int maxIndex = -1;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > max) {
                secondmax = max;
                max = nums[i];
                maxIndex = i;
            } else if(nums[i] > secondmax) { 
                // If a number is not the maximum but bigger than secondMax
                // it fits exactly in the second position
                secondmax = nums[i];
            }
        }
        return max >= 2 * secondmax ? maxIndex : -1;
    }
}//o(n), o(1)
