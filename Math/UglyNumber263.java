Pattern Recognition:Prime Factor Elimination/ Factor Stripping

Brute Force Approach: Find all prime factors of n by checking divisibility from 2 to √n.
Whenever a prime factor is found, check whether it is only 2, 3, or 5.
If any other prime factor exists, return false; otherwise return true. Time: O(√n), Space: O(1)

Optimal Approach
If n <= 0, return false because ugly numbers are positive.
Repeatedly divide n by 2, 3, and 5 while divisible.
If the final value becomes 1, return true; otherwise return false. Time: O(log n), Space: O(1)

The time complexity is O(log n) because each iteration divides n by a constant factor (2, 3, or 5), causing the value to shrink exponentially. 
A number can only be divided a logarithmic number of times before reaching 1. Hence the total number of divisions is O(log n).

class Solution {
    public boolean isUgly(int n) {

        // Ugly numbers must be positive
        if (n <= 0) {
            return false;
        }

        // Allowed prime factors for an ugly number
        int[] factors = {2, 3, 5};

        // Remove all occurrences of each allowed factor
        for (int factor : factors) {

            // Keep dividing until the factor no longer divides n
            while (n % factor == 0) {
                n /= factor;
            }
        }

        // If only 2, 3, and 5 were present as prime factors,
        // n will be reduced to 1
        return n == 1;
    }
}
