Pattern Recognition: prefix sum
runningSum[i]=runningSum[i−1]+nums[i]

Brute Force: Recomputes sum from index 0 to i for every element
Uses nested loops leading to repeated calculations. Time: O(n²), Space: O(1)

class Solution {
    public int[] runningSum(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        ans[0] = nums[0];
        for(int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] + nums[i];
        }
        return ans;
    }
}

Optimal: Builds result using previous computed sum (prefix sum idea)
Avoids recomputation by carrying forward running total. Time: O(n), Space: O(1)

class Solution {
    public int[] runningSum(int[] nums) {
        for(int i = 1; i < nums.length; i++) {
            nums[i] = nums[i] + nums[i - 1];
        }
        return nums;
    }
}