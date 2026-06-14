Pattern Recognition: Bit Manipulation

Brute Force Approach: Convert the integer into a 32-bit binary string.
Reverse the binary string. Convert the reversed string back to an integer.
Time: O(32) = O(1), Space: O(32) = O(1)

Optimal Approach (Bit Manipulation): Extract the last bit using n & 1.
Shift result left and append the extracted bit. Repeat 32 times while shifting n right.
Time: O(32) = O(1), Space: O(1)

class Solution {
    public int reverseBits(int n) {

        // This will store the reversed bits
        int result = 0;

        // A 32-bit integer always has exactly 32 bits
        for (int i = 0; i < 32; i++) {

            // Shift result left by 1 bit
            // This creates space at the rightmost position
            result <<= 1;

            // Extract the last bit of n using (n & 1)
            // and place it into the newly created space
            result |= (n & 1);

            // Move to the next bit of n
            // Right shift removes the bit we just processed
            n >>= 1;
        }

        // Return the integer formed by the reversed bits
        return result;
    }
}