Pattern: Repeated substring / String periodicity.

Brute Force: Try every possible substring length 1 to n/2 and check whether repeating that substring forms s.
For each candidate, compare all characters with the corresponding character in the pattern. Time: O(n²) | Space: O(n).

Optimal: Use the LPS (Longest Prefix Suffix) array from KMP to find the smallest repeating unit.
Let len = n - lps[n-1]; if n % len == 0, the string is made by repeating that unit. Time: O(n) | Space: O(n).

class Solution {

    public boolean repeatedSubstringPattern(String s) {

        int n = s.length();

        // LPS[i] = length of the longest proper prefix
        // which is also a suffix for s[0...i]
        int[] lps = new int[n];

        int len = 0; // Length of current matching prefix
        int i = 1;

        // Build the LPS array
        while (i < n) {

            if (s.charAt(i) == s.charAt(len)) {

                // Characters match → extend prefix
                len++;
                lps[i] = len;
                i++;

            } else {

                if (len != 0) {

                    // Try the next smaller matching prefix
                    len = lps[len - 1];

                } else {

                    // No matching prefix exists
                    lps[i] = 0;
                    i++;
                }
            }
        }

        // Length of the smallest repeating pattern
        int patternLength = n - lps[n - 1];

        // If n is divisible by patternLength,
        // the whole string is made by repeating that pattern.
        return patternLength < n && n % patternLength == 0;
    }
}