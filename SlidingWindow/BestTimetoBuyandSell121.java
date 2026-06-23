Pattern Recognition: Track Minimum + Max Difference

Brute Force Approach: Try every day as a buying day. For each buying day, try every future day as a selling day.
Keep track of maximum profit. Time: O(n²), Space: O(1)

Optimal Approach: Keep track of the minimum stock price seen so far. For every price, calculate profit if sold today.
Update maximum profit whenever a larger profit is found. Time: O(n),Space: O(1)

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