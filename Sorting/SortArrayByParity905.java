Pattern Recognition:- Two Pointers, Array Partitioning, In-place Rearrangement

Brute Force:- Create two separate lists for even and odd numbers, then concatenate them. Time: O(n), Space: O(n)
Optimal Approach:- In-place partitioning using two pointers. Time: O(n), Space: O(1)

class Solution {
    public int[] sortArrayByParity(int[] nums) {

        // Left pointer starts from beginning
        // Its job:
        // stop at wrongly placed odd element
        int left = 0;

        // Right pointer starts from end
        // Its job:
        // stop at wrongly placed even element
        int right = nums.length - 1;

        // Continue until unsolved region exists
        while (left < right) {

            // Move left forward while elements are already correct
            // (evens belong on left side)
            // Inner left < right prevents pointer crossing during scanning
            while (left < right && nums[left] % 2 == 0) {
                left++;
            }

            // Move right backward while elements are already correct
            // (odds belong on right side)
            // Inner left < right prevents pointer crossing during scanning
            while (left < right && nums[right] % 2 != 0) {
                right--;
            }

            // Now:
            // nums[left]  -> odd misplaced on left side
            // nums[right] -> even misplaced on right side
            // Swap fixes both positions in one step
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            // After swap both positions become correct
            // So move pointers inward to process remaining unsolved region
            left++;
            right--;
        }

        // Return partitioned array
        return nums;
    }
}

Swapping should happen ONLY when BOTH conditions occur together: left found wrong odd AND right found wrong even.
Outer loop protects the overall process.
Inner loop protects pointer movement DURING scanning.

Why left++ and right-- again after swap?
Because inner loops only move pointers while: elements are already correct. They STOP when they find misplaced elements.