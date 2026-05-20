Pattern Recognition: Binary Search Pattern + wrap around

wrap around:If no char > than target is found,return the first character of the array because the answer wraps around to the beginning

Brute Force Approach: Traverse the array from left to right and check every character.
Return the first character that is strictly greater than target since array is sorted.
If no greater character is found, return the first character (wrap-around case).
Time Complexity: `O(n)`, Space Complexity: `O(1)`

Optimal Approach (Binary Search / Upper Bound):
Use binary search to find the first character strictly greater than target.
If `letters[mid] > target`, store answer and move left to find smaller valid character.
Else move right; if no answer found, return first character for wrap-around.
Time Complexity: `O(log n)`,Space Complexity: `O(1)`

class Solution {
    public char nextGreatestLetter(char[] letters, char target) {

        // Initialize left pointer at start of array
        int left = 0;

        // Initialize right pointer at end of array
        int right = letters.length - 1;

        // Default answer for wrap-around case
        // If no greater character is found,
        // return first character of array
        char ans = letters[0];

        // Perform binary search
        while (left <= right) {

            // Calculate middle index safely
            // Avoids integer overflow
            int mid = left + (right - left) / 2;

            // If current character is greater than target
            // it can be a possible answer
            if (letters[mid] > target) {

                // Store current possible answer
                ans = letters[mid];

                // Move LEFT to search for smaller valid answer
                // because we need the SMALLEST character > target
                right = mid - 1;
            }

            // Current character is <= target
            // so it cannot be the answer
            else {

                // Move RIGHT to find greater character
                left = mid + 1;
            }
        }

        // Return final answer
        return ans;
    }
}