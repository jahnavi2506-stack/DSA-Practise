Pattern Recognition: Reverse Technique

Brute Force Approach: Rotate the array by 1 position to the right.
Repeat this process k times. Each rotation shifts all elements by one position. Time  : O(n × k), Space : O(1)

Optimal Approach (Reverse Technique)
Reverse the entire array. Reverse the first k elements.
Reverse the remaining n-k elements. Time  : O(n), Space : O(1)

class Solution {

    public void rotate(int[] nums, int k) {

        int n = nums.length;

        // If k is greater than array length,
        // reduce unnecessary rotations
        k = k % n;

        // Step 1: Reverse the entire array
        reverse(nums, 0, n - 1);

        // Step 2: Reverse the first k elements
        reverse(nums, 0, k - 1);

        // Step 3: Reverse the remaining elements
        reverse(nums, k, n - 1);
    }

    // Helper method to reverse a portion of the array
    private void reverse(int[] nums, int left, int right) {

        while (left < right) {

            // Swap elements at left and right
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            // Move pointers towards center
            left++;
            right--;
        }
    }
}