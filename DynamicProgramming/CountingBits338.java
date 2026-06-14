Pattern Recognition: Bit Manipulation

Brute Force: For every number i from 0 to n, count its set bits individually using % 2 / & 1.
Repeatedly divide by 2 (or right shift) until the number becomes 0.
Store the count in ans[i]. Time: O(n log n), Space: O(1) extra space (O(n) including output array)

Optimal (DP + Bit Manipulation): Use the relation ans[i] = ans[i >> 1] + (i & 1).
i >> 1 removes the last bit, and (i & 1) gives the value of the last bit.
Build answers from 1 to n using previously computed results.
Time: O(n), Space: O(n) (answer array)

class Solution {
    public int[] countBits(int n) {

        // Create an array to store the answer for each number from 0 to n
        int[] ans = new int[n + 1];

        // ans[0] is already 0 by default
        // Start from 1 because we already know the answer for 0
        for (int i = 1; i <= n; i++) {

            /*
             * DP + Bit Manipulation Formula:
             *
             * ans[i] = ans[i >> 1] + (i & 1)
             *
             * i >> 1  -> removes the last binary bit
             * i & 1   -> gives the last bit (0 or 1)
             *
             * Example:
             * i = 5
             * Binary = 101
             *
             * i >> 1 = 10 (decimal 2)
             * i & 1  = 1
             *
             * ans[5] = ans[2] + 1
             *        = 1 + 1
             *        = 2
             */
            ans[i] = ans[i >> 1] + (i & 1);
        }

        // Return the array containing the count of set bits
        // for every number from 0 to n
        return ans;
    }
}