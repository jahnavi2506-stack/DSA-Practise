Pattern Recognition:- Binary Search on answer space

BRUTE FORCE APPROACH: Start from 1 to n, check each number one by one using guess(i).
Return the first i where guess(i) == 0. This is simple linear search without using feedback optimization.
Time Complexity: O(n), Space Complexity: O(1)

OPTIMAL: Use search space [1, n] and pick middle element mid.
Use guess(mid) to decide direction: left if higher, right if lower. Keep eliminating half search space until correct number is found.
Time Complexity: O(log n), Space Complexity: O(1)

public class Solution extends GuessGame {

    public int guessNumber(int n) {

        // Step 1: define search space
        // number is guaranteed between 1 and n
        int left = 1;
        int right = n;

        // Step 2: binary search loop
        while (left <= right) {

            // avoid overflow
            int mid = left + (right - left) / 2;

            // API call to check relation with hidden number
            int res = guess(mid);

            // Step 3: check result of guess API
            if (res == 0) {
                // found the number
                return mid;
            }

            else if (res == 1) {
                // pick is higher than mid
                // discard left half including mid
                left = mid + 1;
            }

            else {
                // res == -1
                // pick is lower than mid
                // discard right half including mid
                right = mid - 1;
            }
        }

        // theoretically unreachable if input is valid
        return -1;
    }
}