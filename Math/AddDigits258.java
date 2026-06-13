Pattern Recognition: Mathematical Pattern (Digital Root) + Simulation(brute force approach)

Brute Force: Repeatedly find the sum of all digits of num.
Replace num with this sum and continue until num < 10. Return num.
Time: O(log n), Space: O(1)

Optimal Approach (Digital Root): Observe that the result follows a repeating pattern every 9 numbers.
If num == 0, return 0; otherwise return 1 + (num - 1) % 9.
This directly gives the final single-digit result without loops.
Time: O(1) ,Space: O(1)

class Solution {
    public int addDigits(int num) {

        // Special case:
        // Digital root of 0 is 0
        if (num == 0) {
            return 0;
        }

        // Digital Root Formula:
        // Shifts the modulo cycle from [0..8] to [1..9]
        return 1 + (num - 1) % 9;
    }
}