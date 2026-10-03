Pattern Recognition: Sliding Window + HashSet

Brute-force: Generate every possible substring and check whether all its characters are unique.
Track the maximum length among all valid substrings.
Time: O(n^3) using substring extraction and duplicate checking; Space: O(n) for checking a substring.

Optimal approach: Maintain a sliding window [left, right] and a HashSet of its unique characters.
If s.charAt(right) already exists, remove characters from the left until the duplicate disappears; then add the new character.
Update maxLen = Math.max(maxLen, right - left + 1); Time: O(n), Space: O(min(n,k))

right - left gives the gap between the pointers.
+1 counts the starting position itself.

class Solution {
    public int lengthOfLongestSubstring(String s) {

        int left = 0;       // Start of the sliding window
        int maxLen = 0;     // Stores the longest valid window length

        // Stores characters currently present in the window
        HashSet<Character> set = new HashSet<>();

        // right expands the window one character at a time
        for (int right = 0; right < s.length(); right++) {

            // If current character is already in the window,
            // shrink the window from the left until the duplicate is removed
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }

            // Add the current character to the window
            set.add(s.charAt(right));

            // Window length = right - left + 1
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
