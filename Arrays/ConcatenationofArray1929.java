Pattern Recognition: Array simulation

Brute Force Approach: Create an empty array/list.
Traverse nums once and append all elements.
Traverse nums again and append all elements again. Time: O(2n) = O(n), Space: O(2n) = O(n)

Optimal Approach: Create an array ans of size 2n.
Traverse nums only once.Place nums[i] at both ans[i] and ans[i+n]. Time: O(n), Space: O(n)

class Solution {
    public int[] getConcatenation(int[] nums) {

        int n = nums.length;

        // Create a new array of size 2n
        int[] ans = new int[2 * n];

        // Traverse the original array once
        for (int i = 0; i < n; i++) {

            // Place the current element in the first half
            ans[i] = nums[i];

            // Place the same element in the second half
            ans[i + n] = nums[i];
        }

        // Return the concatenated array
        return ans;
    }
}

| Rotation Problem                        | Concatenation Problem                  |
| --------------------------------------- | -------------------------------------- |
| Doubling is a trick to search rotations | Doubling is the required output        |
| `s + s` works for strings               | `nums + nums` doesn't exist for arrays |
| We use doubling to check `contains()`   | We use copying to build answer         |
