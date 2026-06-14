Pattern Recognition:  Brain Kernighan’s Algorithm
Question keywords: Count set bits, Number of 1s, Hamming Weight, Population Count (Popcount)

Brute Force: Check the last bit using n & 1. If it is 1, increment the count.
Right shift (n >>= 1) and repeat until n becomes 0.
Time  : O(log n)// One iteration per bit, Space : O(1)

Optimal Approach (Brian Kernighan Algorithm): Repeatedly perform n = n & (n - 1).
Each operation removes the rightmost set bit. Count how many times this operation is performed until n becomes 0.
Time  : O(number of set bits), Space : O(1)

class Solution {
    public int hammingWeight(int n) {

        // Stores the number of set bits (1s)
        int count = 0;

        // Continue until all set bits are removed
        while (n != 0) {

            /*
             * Brian Kernighan's Algorithm
             *
             * n & (n - 1) removes the rightmost set bit (1)
             *
             * Example:
             * n = 101100
             * n-1 = 101011
             *
             * 101100
             * 101011
             * ------
             * 101000
             *
             * The rightmost 1 is removed.
             */
            n = n & (n - 1);

            // One set bit has been removed
            count++;
        }

        // Return the total number of set bits
        return count;
    }
}