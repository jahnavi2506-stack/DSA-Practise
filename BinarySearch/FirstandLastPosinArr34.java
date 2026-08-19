Pattern Recognition: Binary Search — Find First + Find Last Occurrence

Brute Force: Scan the entire array from left to right and find every occurrence of target.
Store the first occurrence as start and continuously update end for every match. Time: O(n) | Space: O(1)

Optimal Approach: Run binary search twice: first search for the leftmost target, then search for the rightmost target.
When nums[mid] == target, don't immediately return; save mid and continue searching toward the required boundary.
Time: O(log n) | Space: O(1).

class Solution {

    // Main method: find both first and last positions
    public int[] searchRange(int[] nums, int target) {

        // Find the first occurrence of target
        int first = findFirst(nums, target);

        // Find the last occurrence of target
        int last = findLast(nums, target);

        // Return both positions
        return new int[]{first, last};
    }

    // Binary search to find the FIRST occurrence
    private int findFirst(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        // Stores the best answer found so far
        int answer = -1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            // Target found
            if (nums[mid] == target) {

                answer = mid;

                // Don't stop!
                // Continue searching towards LEFT
                right = mid - 1;

            }
            // Target is greater → search RIGHT
            else if (nums[mid] < target) {

                left = mid + 1;

            }
            // Target is smaller → search LEFT
            else {

                right = mid - 1;
            }
        }

        return answer;
    }


    // Binary search to find the LAST occurrence
    private int findLast(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        // Stores the best answer found so far
        int answer = -1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            // Target found
            if (nums[mid] == target) {

                answer = mid;

                // Don't stop!
                // Continue searching towards RIGHT
                left = mid + 1;

            }
            // Target is greater → search RIGHT
            else if (nums[mid] < target) {

                left = mid + 1;

            }
            // Target is smaller → search LEFT
            else {

                right = mid - 1;
            }
        }

        return answer;
    }
}
