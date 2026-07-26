Pattern Recognition: Greedy + Two-Pointer Approach

Brute Force: Generate all possible permutations of the array.
Sort them in lexicographical order and locate the current permutation.
Return the next permutation (or the first permutation if the current one is the last).
Time Complexity: O(n! × n) (generating permutations dominates; sorting makes it even worse in practice)
Space Complexity: O(n! × n) (to store all permutations)

Optimal Approach: Scan from the right to find the pivot (nums[i] < nums[i+1]).
Find the smallest element greater than the pivot, swap them.
Reverse the suffix after the pivot to obtain the next lexicographically smallest arrangement.
Time Complexity: O(n), Space Complexity: O(1)

class Solution {

    public void nextPermutation(int[] nums) {

        int n = nums.length;

        // ------------------------------------------
        // Step 1: Find the pivot
        // Traverse from right and find the first index
        // where nums[i] < nums[i + 1]
        // ------------------------------------------
        int pivot = -1;

        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                pivot = i;
                break;
            }
        }

        // ------------------------------------------
        // Step 2: If no pivot is found,
        // the array is in descending order
        // (largest permutation).
        // Reverse the entire array to get
        // the smallest permutation.
        // ------------------------------------------
        if (pivot == -1) {
            reverse(nums, 0, n - 1);
            return;
        }

        // ------------------------------------------
        // Step 3: Find the successor
        // Traverse from the right and find the first
        // element greater than the pivot.
        // ------------------------------------------
        for (int i = n - 1; i > pivot; i--) {
            if (nums[i] > nums[pivot]) {

                // Swap pivot and successor
                swap(nums, i, pivot);
                break;
            }
        }

        // ------------------------------------------
        // Step 4: Reverse the suffix
        // Reverse all elements after the pivot
        // to get the smallest possible arrangement.
        // ------------------------------------------
        reverse(nums, pivot + 1, n - 1);
    }

    // Swaps two elements in the array
    private void swap(int[] nums, int i, int j) {

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // Reverses the array from left to right indices
    private void reverse(int[] nums, int left, int right) {

        while (left < right) {

            swap(nums, left, right);

            left++;
            right--;
        }
    }
}
