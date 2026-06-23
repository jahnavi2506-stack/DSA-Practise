Pattern Recognition: Two-pointers

Brute Force Approach: Traverse the array and square every element.
Sort the squared array. Return the sorted array. Time: O(n log n),Space: O(1) (excluding sorting space)

class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        for(int i = 0; i < n; i++) {
            result[i] = nums[i] * nums[i];
        }
        Arrays.sort(result);
        return result;
    }
}

Optimal Approach (Two Pointers): Compare nums[left]² and nums[right]²; place the larger square at the end of the result array.
Move the corresponding pointer and continue until all positions are filled. Time: O(n),Space: O(n)

class Solution {
    public int[] sortedSquares(int[] nums) {

        // Length of input array
        int n = nums.length;

        // Result array to store sorted squares
        int[] result = new int[n];

        // Two pointers:
        // left -> start of array
        // right -> end of array
        int left = 0;
        int right = n - 1;

        // Fill result array from the last index
        // because the largest square will be placed first
        int index = n - 1;

        // Continue until both pointers cross
        while (left <= right) {

            // Square values at both ends
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];

            // Compare squares
            if (leftSquare > rightSquare) {

                // Place larger square at current index
                result[index] = leftSquare;

                // Move left pointer forward
                left++;
            } else {

                // Place larger square at current index
                result[index] = rightSquare;

                // Move right pointer backward
                right--;
            }

            // Move to the next position from the back
            index--;
        }

        // Return sorted squares array
        return result;
    }
}