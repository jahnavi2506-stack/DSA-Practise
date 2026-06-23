Pattern Recognition: Two-pointers

Brute Force: Create a new array/list and store all non-zero elements.
Count the number of zeros and append them at the end.
Copy the result back to the original array. Time: O(n), Space: O(n)

Optimal (Two Pointers): Use j to track the position where the next non-zero should be placed.
Traverse with i; whenever nums[i] != 0, swap nums[i] with nums[j].
Increment j; after traversal, all zeros automatically move to the end. Time: O(n), Space: O(1)

class Solution {
    public void moveZeroes(int[] nums) {

        // j points to the position where the next non-zero
        // element should be placed
        int j = 0;

        // Traverse the entire array using i
        for (int i = 0; i < nums.length; i++) {

            // If current element is non-zero
            if (nums[i] != 0) {

                // Swap nums[i] with nums[j]
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;

                // Move j to the next position
                // for the next non-zero element
                j++;
            }
        }
    }
}