Pattern Recognition: Bit Manipulation

Brute Force Approach (Repeated Division): If n <= 0, return false.
Keep dividing by 4 while divisible by 4.
If the final value becomes 1, it is a power of four. Time: O(log₄ n),Space: O(1)

Optimal Approach (Bit Manipulation): A power of 4 must first be a power of 2.
Power of 2 check: (n & (n - 1)) == 0.
Then ensure the single 1 bit is in a valid power-of-4 position using a mask. Time: O(1), Space: O(1)

0x55555555 = 01010101... (repeated), which has 1s at all even bit positions (0, 2, 4, 6, ...)—exactly
where the single set bit of a power of 4 must be.

 class Solution {
    public boolean isPowerOfFour(int n) {

        // A power of 4 must be positive
        if (n <= 0) {
            return false;
        }

        // Check if n is a power of 2
        // A power of 2 has exactly one set bit
        if ((n & (n - 1)) != 0) {
            return false;
        }

        // 0x55555555 = 01010101010101010101010101010101
        // It has 1s only at positions:
        // 0, 2, 4, 6, ...
        //
        // Powers of 4 place their single set bit
        // only in these positions.
        return (n & 0x55555555) != 0;
    }
}