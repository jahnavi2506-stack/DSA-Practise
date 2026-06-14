Pattern Recognition: Binary Representation 

Brute Force: Keep dividing n by 2 while it is divisible by 2. If the final value becomes 1, it is a power of 2; otherwise, it is not.
1. If n <= 0, return false.
2. While n % 2 == 0, divide n by 2.
3. Return n == 1. Time  : O(log n), Space : O(1)

Optimal Approach (Bit Manipulation): A power of 2 has exactly one set bit in binary. For such numbers, n & (n - 1) always equals 0.
1. If n <= 0, return false.
2. Compute (n & (n - 1)).
3. Return true if result is 0, else false. Time  : O(1),Space : O(1)

class Solution {
    public boolean isPowerOfTwo(int n) {

        // Powers of 2 must be positive
        // 0 and negative numbers cannot be powers of 2
        if (n <= 0) {
            return false;
        }

        // A power of 2 has exactly one set bit in binary
        //
        // Example:
        // 16 = 10000
        // 15 = 01111
        //
        // 10000
        // 01111
        // -----
        // 00000
        //
        // For any power of 2:
        // n & (n - 1) == 0
        return (n & (n - 1)) == 0;
    }
}