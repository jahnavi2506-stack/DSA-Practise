Pattern Recognition: Binary Search Pattern

Brute Force Approach: Scan array linearly and find first position where element ≥ target.
Traverse array from left to right,If nums[i] >= target, return i,If not found, return nums.length
Complexity: Time=O(n),Space=O(1)

Optimal Approach: Use binary search to find first position where target should be placed.
Use left = 0, right = n-1, Move left/right based on comparison with mid, Return left as insertion index
Complexity: Time=O(logn),Space=O(1)

class Solution {
    public int searchInsert(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            // Element found
            if (nums[mid] == target) {
                return mid;
            }

            // Search right half
            else if (target > nums[mid]) {
                left = mid + 1;
            }

            // Search left half
            else {
                right = mid - 1;
            }
        }

        // Insertion position
        return left;
    }
}
