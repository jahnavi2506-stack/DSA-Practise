Pattern Recognition: Hashing / Math / XOR

Brute Force Approach: Check every number from 0 to n.
For each number, search the entire array. If a number is not found, return it. Time: O(N²), Space: O(1)

Better Approach (HashSet): Store every element in a HashSet.
Traverse numbers from 0 to n. Return the number not present in the set. Time: O(N), Space: O(N)

Optimal: Calculate the expected sum of numbers from 0 to n using the formula n * (n + 1) / 2.
Traverse the array once to calculate the actual sum of its elements.
Return expectedSum - actualSum, which is the missing number. Time: O(N), Space: O(1)

class Solution {
    public int missingNumber(int[] nums) {

        int n = nums.length;

        // Sum of numbers from 0 to n
        int expectedSum = n * (n + 1) / 2;

        // Sum of array elements
        int actualSum = 0;

        for (int num : nums) {
            actualSum += num;
        }

        // Difference gives missing number
        return expectedSum - actualSum;
    }
}