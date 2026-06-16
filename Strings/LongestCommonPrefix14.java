Pattern Recognition: String pattern (Horizontal Scanning)

Brute Force (Character-by-Character Comparison): Take the first string as a reference.
For each character position, compare that character with all other strings.
Stop at the first mismatch and return the prefix formed so far.Time: O(N × M),Space: O(1)
where: N = number of strings, M = length of the shortest string

Optimal Approach (Horizontal Scanning): Assume the first string is the common prefix.
Compare it with each string and keep removing the last character until the current string starts with it.
After all comparisons, the remaining prefix is the longest common prefix. Time: O(N × M),Space: O(1)

class Solution {
    public String longestCommonPrefix(String[] strs) {

        // Assume the first string is the common prefix
        String prefix = strs[0];

        // Compare the current prefix with every other string
        for (int i = 1; i < strs.length; i++) {

            // Keep shrinking the prefix until
            // the current string starts with it
            while (!strs[i].startsWith(prefix)) {

                // Remove the last character
                prefix = prefix.substring(0, prefix.length() - 1);

                // If nothing is left, no common prefix exists
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        // Remaining prefix is the longest common prefix
        return prefix;
    }
}

1. Start with first string as prefix.
2. Check if current string starts with prefix.
3. If not, remove last character from prefix.
4. Repeat until it matches.
5. If prefix becomes empty - return "".
6. After all strings are processed, return prefix.