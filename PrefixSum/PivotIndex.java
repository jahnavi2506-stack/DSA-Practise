Pattern Recognition:Prefix Sum / Running Sum Pattern

Brute Force: For every index, calculate the left sum by traversing all elements before it.
Calculate the right sum by traversing all elements after it and compare both sums.
Time: O(n²), Space: O(1).

Optimal Approach: First compute the total sum of the array in one pass.
Traverse once while maintaining leftSum; compute rightSum = totalSum - leftSum - nums[i].
If leftSum == rightSum, return the index. Time: O(n), Space: O(1).

class Solution {
    public int pivotIndex(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;  
        }
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            int rightSum = totalSum - leftSum - nums[i];  
            if (leftSum == rightSum) {
                return i;  
            }
            leftSum += nums[i];  
        }
        return -1;  
    }
}
