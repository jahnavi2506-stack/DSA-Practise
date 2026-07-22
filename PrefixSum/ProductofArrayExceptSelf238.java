Pattern Recognition: Prefix Product + Suffix Product

Brute Force Approach: For every index, iterate through the entire array and multiply all elements except the current one.
Store the computed product in the answer array.
Time Complexity: O(n²) , Space Complexity: O(1) (excluding output array)

Optimal Approach
First pass: Store the product of all elements to the left of each index in the answer array.
Second pass: Traverse from right while maintaining a rightProduct, and multiply it with the left product already stored.
Time Complexity: O(n) , Space Complexity: O(1) (excluding output array)

class Solution {
    public int[] productExceptSelf(int[] nums) {

        int n = nums.length;

        // Output array.
        // First it stores Left Products, then it becomes the final answer.
        int[] answer = new int[n];

        // No elements to the left of the first element.
        answer[0] = 1;

        // -------------------------
        // Step 1: Store Left Products
        // answer[i] = product of all elements before index i
        // -------------------------
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        // No elements to the right of the last element.
        int rightProduct = 1;

        // -------------------------
        // Step 2: Multiply with Right Products
        // rightProduct = product of all elements after index i
        // -------------------------
        for (int i = n - 1; i >= 0; i--) {

            // Final answer = Left Product × Right Product
            answer[i] *= rightProduct;

            // Update right product for the next iteration
            rightProduct *= nums[i];
        }

        return answer;
    }
}

Left Pass → Store Prefix | Right Pass → Multiply Suffix