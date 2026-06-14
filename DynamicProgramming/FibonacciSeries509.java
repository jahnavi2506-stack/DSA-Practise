Pattern Recognition: Fibonacci Sequence

Brute Force (Recursion): Directly follow the recurrence relation: fib(n) = fib(n-1) + fib(n-2).
Recursively calculate the previous two Fibonacci numbers for every call.
Same subproblems are solved repeatedly, causing redundant work. Time: O(2^n), Space: O(n) (recursion stack)

Optimal (Space Optimized DP): Observe that F(n) depends only on the previous two Fibonacci numbers.
Store them in two variables (prev1, prev2) and compute the next value iteratively.
Update the variables after each iteration and return the final value. Time: O(n), Space: O(1)

class Solution {
    public int fib(int n) {

        // Base cases:
        // F(0) = 0
        // F(1) = 1
        if (n <= 1) {
            return n;
        }

        // Store the two previous Fibonacci numbers
        int prev2 = 0; // F(0)
        int prev1 = 1; // F(1)

        // Calculate Fibonacci numbers from F(2) to F(n)
        for (int i = 2; i <= n; i++) {

            // Current Fibonacci number
            // F(i) = F(i-1) + F(i-2)
            int curr = prev1 + prev2;

            // Move the window forward:
            // Old F(i-1) becomes new F(i-2)
            prev2 = prev1;

            // Current F(i) becomes new F(i-1)
            prev1 = curr;
        }

        // prev1 now contains F(n)
        return prev1;
    }
}