Pattern Recognition:

Brute Force: Find the largest element first, then compare it with every other element.
Find maximum and its index → O(n).
Loop again and check max >= 2 * nums[i] for every other element → O(n).
If any condition fails, return -1; otherwise return maximum's index. Time: O(n), Space: O(1)

Optimal Approach: Track the largest and second-largest elements while traversing the array.
Find the largest element and its index while scanning.
Find the second-largest element (or simply compare every other element with the maximum).
Check max >= 2 × secondLargest.
Because the largest is unique, checking against the second-largest is sufficient — if max is at least twice the 
second-largest, it is automatically at least twice every smaller number. Time: O(n), Space: O(1)

class Solution {
    public int dominantIndex(int[] nums) {

        // Step 1: Find the largest element and its index
        int max = -1;
        int maxIndex = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }

        // Step 2: Check whether the largest element
        // is at least twice every other element
        for (int i = 0; i < nums.length; i++) {

            // Skip the largest element itself
            if (i == maxIndex) {
                continue;
            }

            // If max is NOT at least twice nums[i],
            // the condition fails
            if (max < 2 * nums[i]) {
                return -1;
            }
        }

        // If all elements satisfy the condition,
        // return the index of the largest element
        return maxIndex;
    }
}