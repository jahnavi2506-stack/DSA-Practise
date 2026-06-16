Pattern Recognition: Two-Pointers + Greedy

Why Greedy?
If it helps me match next needed character in s - take it
Else - discard it
Order must be preserved, We cannot rearrange characters. Once you skip a match, you can never go back

Brute Force: Generate all subsequences of t and check if any equals s.
This explores every possible combination of characters. Time: O(2^n), Space: O(n) (recursion stack)

Optimal: Use two pointers i (s) and j (t).
Move j always; move i only when characters match. If i reaches end of s, it is a subsequence.
Time: O(n), Space: O(1)

class Solution {
    public boolean isSubsequence(String s, String t) {

        // i → pointer for string s (subsequence we are checking)
        int i = 0;

        // j → pointer for string t (main string we scan through)
        int j = 0;

        // Loop until either string is fully traversed
        while (i < s.length() && j < t.length()) {

            // If characters match, move pointer of s
            // because we successfully found one character of s in t
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }

            // Always move pointer of t
            // because we are scanning t completely from left to right
            j++;
        }

        // If we have successfully matched all characters of s,
        // then i should reach the end of s
        return i == s.length();
    }
}