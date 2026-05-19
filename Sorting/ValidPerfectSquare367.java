Pattern Recognition:- Binary Search on Feasible Answer

Why Binary Search? The square values grow monotonically with increasing integers.
So after checking mid², I can eliminate half of the search space depending on whether the square is smaller or larger than num. 
brute force may check thousands/millions binary search checks only about 31 times, power of logarithmic complexity.

Brute Force Approach: Check every integer i from 1 till `i * i <= num` and verify whether `i * i == num`.
If any square equals `num`, return `true`; otherwise return `false` after loop ends. Time: O(sqrt{n}) , Space: O(1)

Optimal: Apply Binary Search on range `1 → num` and compute `mid`; compare `mid²` with `num`.
If `mid² == num` return `true`; if smaller move right, else move left.
Time Complexity: O(log n)[eliminate half of the search space] , Space Complexity: O(1)


class Solution {
    public boolean isPerfectSquare(int num) {

        // Search space starts from 1 to num
        long left = 1;
        long right = num;

        // Binary Search loop
        while (left <= right) {

            // Safe midpoint calculation to avoid overflow
            long mid = left + (right - left) / 2;

            // Store square of mid
            long square = mid * mid;

            // Case 1: Perfect square found
            if (square == num) {
                return true;
            }

            // Case 2: Square is smaller than num
            // Need larger value → move right
            else if (square < num) {
                left = mid + 1;
            }

            // Case 3: Square is greater than num
            // Need smaller value → move left
            else {
                right = mid - 1;
            }
        }

        // No perfect square exists
        return false;
    }
}

