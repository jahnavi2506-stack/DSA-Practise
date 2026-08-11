Pattern Recognition: Two passes:- count frequencies → scan left-to-right

Brute Force: For every character s[i], scan the entire string to count how many times it occurs.
If count is 1, immediately return i; otherwise continue. Time: O(n²) | Space: O(1)

Optimal Approach: 
First pass: store frequency of every character in int[26].
Second pass: scan from left to right; the first character with frequency 1 is the answer.
Time: O(n) | Space: O(1) because only 26 lowercase letters.

class Solution {
    public int firstUniqChar(String s) {

        // Create frequency array for 26 lowercase English letters
        int[] freq = new int[26];

        // STEP 1: Count how many times each character appears
        for (char ch : s.toCharArray()) {

            // Convert character to index:
            // 'a' -> 0, 'b' -> 1, ..., 'z' -> 25
            freq[ch - 'a']++;
        }

        // STEP 2: Traverse the string from left to right
        // to find the FIRST character whose frequency is 1
        for (int i = 0; i < s.length(); i++) {

            // If character appears only once, return its index
            if (freq[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        // No non-repeating character found
        return -1;
    }
}
