Pattern Recognition: Sliding Window + Kadane's Algorithm

Brute Force Approach: Generate every possible contiguous subarray.
Calculate the sum of each subarray.
Return the maximum sum found. Time: O(n²) (if running sum is used), Space: O(1)

Optimal Approach (Kadane's Algorithm): At each index, decide whether to start a new subarray or extend the current one.
Maintain currentSum = best subarray ending at current index.
Maintain maxSum = best subarray found so far. Time: O(n), Space: O(1)

class Solution {
    public int maxProfit(int[] prices) {

        // Minimum price seen so far
        int minPrice = prices[0];

        // Maximum profit found so far
        int maxProfit = 0;

        // Traverse all prices
        for (int i = 1; i < prices.length; i++) {

            // Update minimum buying price
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } 
            else {
                // Profit if we sell today
                int profit = prices[i] - minPrice;

                // Update maximum profit
                maxProfit = Math.max(maxProfit, profit);
            }
        }

        return maxProfit;
    }
}