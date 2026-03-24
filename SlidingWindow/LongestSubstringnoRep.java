//Sliding Window + HashSet
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0;
        int right = 0;
        int maxLength = 0;

        while (right < s.length()) {
            char currentChar = s.charAt(right);

            // If the character is already in the set, remove characters from the left until it's removed
            while (set.contains(currentChar)) {
                set.remove(s.charAt(left));
                left++;
            }

            // Add the current character to the set and update maxLength
            set.add(currentChar);
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }

        return maxLength;
    }
}
HashMap → containsKey
HashSet → contains
if:remove once → still duplicate
while: remove until no duplicate
Sliding window needs: while-because condition must be valid before moving.

left ---- right
right → adds new character
left → removes old character
expand right
if duplicate → move left
window valid → update max

Core pattern:
while invalid → shrink
when valid → update answer
This is used in 80% sliding window problems.

Why +1 needed
Because both ends included.
Example:
left = 0
right = 0
Substring = 1 char