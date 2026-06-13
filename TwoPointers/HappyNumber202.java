Pattern Recognition: Floyd's Cycle Detection + Simulation (Brute Force Approach)

Brute Force (HashSet)
Generate the next number by calculating the sum of squares of its digits and store every generated number in a HashSet.
If the number becomes 1, return true; if a number repeats, a cycle is detected, return false.
Time: O(k × log n), Space: O(k) (k = numbers generated before reaching 1 or a cycle)

Optimal (Floyd's Cycle Detection): Treat each number as a state and use slow/fast pointers to move through generated states.
Slow moves 1 step (getNext()), fast moves 2 steps (getNext(getNext())).
Time: O(k × log n), Space: O(1)

class Solution {

    // Returns the sum of squares of digits of n
    private int getNext(int n) {

        int sum = 0;

        while (n > 0) {

            int digit = n % 10;      // Extract last digit
            sum += digit * digit;    // Add square of digit
            n /= 10;                 // Remove last digit
        }

        return sum;
    }

    public boolean isHappy(int n) {

        int slow = n;          // Moves 1 step at a time
        int fast = getNext(n); // Moves 2 steps at a time

        // Continue until:
        // 1. Fast reaches 1 (Happy Number)
        // 2. Slow and Fast meet (Cycle detected)
        while (fast != 1 && slow != fast) {

            slow = getNext(slow);              // Move 1 step

            fast = getNext(getNext(fast));     // Move 2 steps
        }

        return fast == 1;
    }
}