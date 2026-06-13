Pattern Recognition: Simulation - and Bit Manipulation optimization.

Brute Force (Simulation): Repeatedly follow the given rules until num becomes 0.
If num is even, divide by 2; otherwise subtract 1.
Count every operation performed. Time: O(log n), Space: O(1)

Optimal (Bit Manipulation Observation) Count the number of set bits (1s) and total bits in the binary representation.
Every set bit contributes one subtraction operation.
Every bit except the most significant bit contributes one division operation. Formula: steps = setBits + totalBits - 1
Time: O(log n), Space: O(1)

class Solution {
    public int numberOfSteps(int num) {

        // Edge case: 0 already requires 0 steps
        if (num == 0) {
            return 0;
        }

        // Count of 1s in binary representation
        int setBits = 0;

        // Count of total bits in binary representation
        int totalBits = 0;

        // Traverse all bits of the number
        while (num > 0) {

            // Check if the last bit is 1
            if ((num & 1) == 1) {
                setBits++;
            }

            // Count the current bit
            totalBits++;

            // Remove the last bit (equivalent to num /= 2)
            num >>= 1;
        }

        // Every 1 bit needs one subtraction operation
        // Every bit except the MSB needs one division operation
        return setBits + totalBits - 1;
    }
}