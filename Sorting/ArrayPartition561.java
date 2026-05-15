Pattern Recognition:- Greedy + Sorting (Pairing Optimization, Greedy Pair Formation)

Brute Force:- Generate all possible pairings using recursion/backtracking.
For every pairing, calculate sum(min(ai, bi)) and keep maximum.
Time Complexity: Exponential / Factorial (O((2n)!) approx), Space Complexity: O(n) recursion stack.

Optimal Approach (Greedy + Sorting):- 
Sort the array and pair adjacent elements: (nums[0],nums[1]), (nums[2],nums[3])...
Add every even-indexed element because it becomes the minimum of each pair.
Time Complexity: O(n log n) (sorting), Space Complexity: O(1) or O(log n) depending on sorting implementation.

class Solution {
    public int arrayPairSum(int[] nums) {

        // Step 1: Sort the array
        Arrays.sort(nums);

        // This will store the final maximum sum
        int sum = 0;

        // Step 2:
        // Take every alternate element starting from index 0
        // Because after sorting:
        // (nums[0], nums[1])
        // (nums[2], nums[3])
        // ...
        // the first element of every pair is the minimum
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }

        // Step 3: Return final answer
        return sum;
    }
}