Pattern Recognition: Two Pointers + In-place Swapping

Brute Force: Create a new array/string and traverse s from right to left.
Store each character in the new array in reverse order.
Time: O(n) | Space: O(n)

Optimal Approach: Set left = 0 and right = s.length - 1.
While left < right, swap the characters and do left++, right--.
Time: O(n) | Space: O(1) 

class Solution {
    public void reverseString(char[] s) {

        // Two pointers: one at the beginning, one at the end
        int left = 0;
        int right = s.length - 1;

        // Swap characters until the pointers meet
        while (left < right) {

            // Swap s[left] and s[right]
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            // Move both pointers toward the center
            left++;
            right--;
        }
    }
}

