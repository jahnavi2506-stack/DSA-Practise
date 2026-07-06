Pattern Recognition: Sorted Array +  Search --> binary search

Brute Force: Traverse the array and compare every element with the target.
Return the index if found, otherwise return -1. Time: O(n), Space: O(1)

Optimal Approach: Keep two pointers: left and right.
Find the middle element and eliminate half of the search space every iteration.
Continue until the target is found or no elements remain. Time: O(log n), Space: O(1)

class Solution {
    public int search(int[] nums, int target) {

        // Starting index
        int left = 0;

        // Ending index
        int right = nums.length - 1;

        // Continue searching while at least one element exists
        while (left <= right) {

            // Calculate middle safely (avoids integer overflow)
            int mid = left + (right - left) / 2;

            // Target found
            if (nums[mid] == target) {
                return mid;
            }

            // Target is greater, search in right half
            else if (nums[mid] < target) {
                left = mid + 1;
            }

            // Target is smaller, search in left half
            else {
                right = mid - 1;
            }
        }

        // Target not found
        return -1;
    }
}
