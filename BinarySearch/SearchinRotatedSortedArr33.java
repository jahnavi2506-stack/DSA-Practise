Pattern Recognition: Binary Search Pattern

Brute Force Approach: Traverse the entire array linearly from index `0 → n-1`
Compare every element with `target`
If found, return index; otherwise return `-1`. Time  : O(n), Space : O(1)

Optimal Approach (Binary Search on Rotated Array): Use binary search and observe that at least one half is always sorted
Identify the sorted half using `nums[left] <= nums[mid]`
Check whether target lies inside sorted half; eliminate the other half. Time  : O(log n), Space : O(1)

class Solution {
    public int search(int[] nums, int target) {

        // Start and end pointers for binary search
        int left = 0;
        int right = nums.length - 1;

        // Binary search loop
        while (left <= right) {

            // Prevents overflow
            int mid = left + (right - left) / 2;

            // Target found
            if (nums[mid] == target) {
                return mid;
            }

            // Check if LEFT HALF is sorted
            if (nums[left] <= nums[mid]) {

                /*
                 Target lies inside left sorted half
                 Example:
                 [4,5,6,7,0,1,2]
                  L     M

                 If target is between nums[left] and nums[mid],
                 move towards left half
                */
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                }

                // Otherwise search in right half
                else {
                    left = mid + 1;
                }
            }

            // Otherwise RIGHT HALF is sorted
            else {

                /*
                 Example:
                 [6,7,0,1,2,4,5]
                        M     R

                 If target lies between nums[mid] and nums[right],
                 search right half
                */
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                }

                // Otherwise search left half
                else {
                    right = mid - 1;
                }
            }
        }

        // Target not found
        return -1;
    }
}