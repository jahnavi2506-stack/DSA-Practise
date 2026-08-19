Brute Force: Try every possible combination of 3 elements using three nested loops.
Calculate each product and keep the maximum.
This checks all nC3 combinations. Time: O(n³),Space: O(1)

Better Approach — Sorting: Sort the array in ascending order.
The answer is either the 3 largest numbers or the largest number × 2 smallest numbers.
Compare nums[n-1] * nums[n-2] * nums[n-3] with nums[0] * nums[1] * nums[n-1].
Time: O(n log n), Space: O(log n) typical for Java's primitive-array sort due to implementation stack space.

Optimal Approach: In one pass, track the 3 largest (max1, max2, max3) and 2 smallest (min1, min2) values.
The maximum product must be either max1 × max2 × max3 or max1 × min1 × min2.
Return the larger product. Time: O(n), Space: O(1)

class Solution {
    public int maximumProduct(int[] nums) {

        // Track the 3 largest numbers
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;

        // Track the 2 smallest numbers
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        // Traverse the array once
        for (int num : nums) {

            // -------- Find 3 Largest --------

            if (num > max1) {
                // Shift old values to the right
                max3 = max2;
                max2 = max1;
                max1 = num;
            }
            else if (num > max2) {
                max3 = max2;
                max2 = num;
            }
            else if (num > max3) {
                max3 = num;
            }

            // -------- Find 2 Smallest --------

            if (num < min1) {
                // Shift old minimum to second minimum
                min2 = min1;
                min1 = num;
            }
            else if (num < min2) {
                min2 = num;
            }
        }

        // Case 1: Three largest numbers
        int product1 = max1 * max2 * max3;

        // Case 2: Largest number × two smallest negatives
        int product2 = max1 * min1 * min2;

        // Return the maximum possible product
        return Math.max(product1, product2);
    }
}
