Brute Force: Create a new array and place each element one position to the left.
Copy the first element to the last position. Time: O(n) | Space: O(n)

Optimal Approach: Store the first element in a temporary variable.
Shift all remaining elements one position to the left, then place `temp` at the end. Time: O(n) | Space: O(1)

class Solution {
    public void rotateArrayByOne(int[] nums) {

        // Store the first element before it gets overwritten
        int temp = nums[0];

        // Shift every remaining element one position to the left
        for (int i = 1; i < nums.length; i++) {
            nums[i - 1] = nums[i];
        }

        // Place the original first element at the last position
        nums[nums.length - 1] = temp;
    }
}