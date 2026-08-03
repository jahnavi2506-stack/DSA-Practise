Pattern Recognition: Sliding Window + Kadane's Algorithm

Brute Force Approach: Generate every possible contiguous subarray.
Calculate the sum of each subarray.
Return the maximum sum found. Time: O(n²) (if running sum is used), Space: O(1)

Optimal Approach (Kadane's Algorithm): At each index, decide whether to start a new subarray or extend the current one.
Maintain currentSum = best subarray ending at current index.
Maintain maxSum = best subarray found so far. Time: O(n), Space: O(1)

class Solution {
    public int maxSubArray(int[] nums) {

        // Maximum sum of a subarray ending at the current index.
        // Initialize with the first element because the array can contain all negative numbers.
        int currentSum = nums[0];
        // Maximum subarray sum found so far.
        int maxSum = nums[0];

        // Start from the second element.
        for (int i = 1; i < nums.length; i++) {

            /*
             * Decide:
             * 1. Start a new subarray from nums[i]
             * 2. Extend the previous subarray by adding nums[i]
             *
             * Choose whichever gives a larger sum.
             */
            currentSum = Math.max(nums[i], currentSum + nums[i]);

            /*
             * Update the overall maximum subarray sum found so far.
             */
            maxSum = Math.max(maxSum, currentSum);
        }

        // Return the maximum subarray sum.
        return maxSum;
    }
}