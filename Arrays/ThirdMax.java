Brute Force: Remove duplicates, then sort the remaining values in descending order.
If there are at least 3 distinct values, return the 3rd; otherwise return the maximum. Time: O(n log n),Space: O(n).

Optimal Approach: Traverse once and maintain first, second, and third largest distinct values.
When a larger value appears, shift: first → second → third; skip duplicates. Time: O(n) , Space: O(1).

class Solution {
    public int thirdMax(int[] nums) {

        // Store the top 3 DISTINCT maximum values.
        // long is used because Long.MIN_VALUE acts as a safe "not found" marker.
        long first = Long.MIN_VALUE;
        long second = Long.MIN_VALUE;
        long third = Long.MIN_VALUE;

        // Traverse the array only once
        for (int num : nums) {

            // Ignore duplicates because we need DISTINCT maximum values.
            if (num == first || num == second || num == third) {
                continue;
            }

            // num becomes the new largest.
            // Shift the old values down.
            if (num > first) {
                third = second;
                second = first;
                first = num;
            }

            // num is between first and second.
            // Shift second down to third.
            else if (num > second) {
                third = second;
                second = num;
            }

            // num is between second and third.
            // Update only third.
            else if (num > third) {
                third = num;
            }
        }

        // If 3 distinct values don't exist,
        // third remains Long.MIN_VALUE, so return the maximum.
        return third == Long.MIN_VALUE ? (int) first : (int) third;
    }
}
To find the maximum, start from the lowest possible value so every valid number has a chance to become maximum.