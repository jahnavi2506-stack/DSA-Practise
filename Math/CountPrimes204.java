Pattern Recognition: Sieve of Eratosthenes

Brute Force: Check every number from 2 to n-1.
For each number, test whether it is prime using divisors up to √num.
Count all prime numbers. Time: O(n√n), Space: O(1)

Optimal: Assume all numbers are prime.
For every prime i, mark its multiples starting from i*i as non-prime.
Count numbers still marked prime. Time: O(n log n), Space: O(n)

class Solution {
    public int countPrimes(int n) {

        // No primes less than 2
        if (n <= 2) {
            return 0;
        }

        // Assume all numbers are prime initially
        boolean[] isPrime = new boolean[n];

        for (int i = 2; i < n; i++) {
            isPrime[i] = true;
        }

        // Sieve of Eratosthenes
        for (int i = 2; i * i < n; i++) {

            // If current number is prime
            if (isPrime[i]) {

                // Mark all multiples as non-prime
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // Count remaining primes
        int count = 0;

        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                count++;
            }
        }

        return count;
    }
}

