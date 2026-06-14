Pattern Recognition: Bit Manipulation

Brute Force Approach (Repeated Division): A power of 3 can be divided by 3 repeatedly without any remainder.
Keep dividing n by 3 while n % 3 == 0.
If the final value becomes 1, return true; otherwise false.
Time: O(log₃ n),Space: O(1)

Optimal Approach: The largest power of 3 within a 32-bit integer is 3¹⁹ = 1162261467.
Every power of 3 is a divisor of 1162261467.
Therefore, if n > 0 and 1162261467 % n == 0, then n is a power of 3.
Time: O(1), Space: O(1)

class Solution {
    public boolean isPowerOfThree(int n) {

        // Power of 3 must be positive
        if (n <= 0) {
            return false;
        }

        // 3^19 = 1162261467
        // It is the largest power of 3 that fits in a 32-bit signed integer.
        // Every smaller power of 3 divides it exactly.
        // If n divides 3^19 evenly, then n must be a power of 3.
        return 1162261467 % n == 0;
    }
}