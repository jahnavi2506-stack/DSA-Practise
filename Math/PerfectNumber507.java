Pattern Recognition: Divisor/ Factor Problem

Brute Force: Check every number from 1 to num-1.
If it divides num, add it to the sum. Return true if sum equals num. Time  : O(n), Space : O(1)

Optimal: Divisors always occur in pairs: (i, num/i).
Loop only till √num and add both divisors whenever one is found.
Finally check if the divisor sum equals num. Time  : O(√n), Space : O(1)

class Solution {
    public boolean checkPerfectNumber(int num) {

        // 1 is not a perfect number
        // because it has no proper divisors
        if (num == 1) {
            return false;
        }

        // Start with 1 because 1 is a proper divisor
        // of every number greater than 1
        int sum = 1;

        // Check divisors only up to √num
        for (int i = 2; i * i <= num; i++) {

            // If i divides num exactly
            if (num % i == 0) {

                // Add the divisor
                sum += i;

                // Add the paired divisor
                // Example:
                // num = 28, i = 2
                // paired divisor = 28 / 2 = 14
                // Add only if they are different
                if (i != num / i) {
                    sum += num / i;
                }
            }
        }

        // Perfect number if sum of proper divisors
        // equals the original number
        return sum == num;
    }
}