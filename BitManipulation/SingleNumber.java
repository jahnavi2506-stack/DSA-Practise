//136
// Every number that appears twice will cancel itself out because:
// x ^ x = 0
class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
       for(int i = 0; i < nums.length; i++) {
        result ^= nums[i];
       } 
       return result;
    }
}
