Pattern Recognition: Prefix Sum

Brute Force: For every index:
Calculate left sum by traversing left side.
Calculate right sum by traversing right side.
Store |leftSum - rightSum|. Time: O(n²),Space: O(1) (excluding output array)

Optimal Approach: Find total sum of the array. Maintain a running leftSum.
Compute rightSum = totalSum - leftSum - nums[i] and store |leftSum - rightSum|.
Time: O(n), Space: O(1) (excluding output array)
 
 class Solution {
    public int[] leftRightDifference(int[] nums) {

        int n = nums.length;
        int[] answer = new int[n];

        // Step 1: Find total sum of array
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        // Step 2: Maintain running left sum
        int leftSum = 0;

        for (int i = 0; i < n; i++) {

            // Sum of elements to the right of current index
            int rightSum = totalSum - leftSum - nums[i];

            // Store absolute difference
            answer[i] = Math.abs(leftSum - rightSum);

            // Update left sum for next iteration
            leftSum += nums[i];
        }

        return answer;
    }
}