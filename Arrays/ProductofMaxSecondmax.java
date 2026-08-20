Brute Force: Try every possible pair using two nested loops.
Calculate (nums[i]-1) * (nums[j]-1) for every pair and keep the maximum. Time: O(n²) | Space: O(1).

Optimal Approach: Track the largest value in max and the second-largest value in secondMax.
Update them while traversing the array once. Time: O(n) | Space: O(1).

class Solution {
    public int maxProduct(int[] nums) {

        // Largest element found so far
        int max = Integer.MIN_VALUE;

        // Second largest element found so far
        int secondMax = Integer.MIN_VALUE;

        // Visit every element once
        for (int i = 0; i < nums.length; i++) {

            // Current number is bigger than the largest
            if (nums[i] > max) {

                // Old largest becomes second largest
                secondMax = max;

                // Current number becomes largest
                max = nums[i];
            }

            // Current number is not largest,
            // but it may be the second largest
            else if (nums[i] > secondMax) {

                secondMax = nums[i];
            }
        }

        // Apply the required formula
        return (max - 1) * (secondMax - 1);
    }
}
