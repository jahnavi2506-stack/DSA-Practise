 Backtracking → Combination (fixed length)

You cannot reuse
You must pick one letter per digit

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        
        // Edge case
        if (digits == null || digits.length() == 0) {
            return result;
        }

        String[] map = {
            "", "", "abc", "def", "ghi",
            "jkl", "mno", "pqrs", "tuv", "wxyz"
        };

        backtrack(0, digits, new StringBuilder(), result, map);
        return result;
    }

    public void backtrack(int index, String digits, StringBuilder current,
                          List<String> result, String[] map) {

        // Base case
        if (current.length() == digits.length()) {
            result.add(current.toString());
            return;
        }

        // Get letters for current digit
        char digit = digits.charAt(index);
        String letters = map[digit - '0'];

        // Try each letter
        for (char ch : letters.toCharArray()) {
            current.append(ch);                         // choose
            backtrack(index + 1, digits, current, result, map); // explore
            current.deleteCharAt(current.length() - 1); // undo
        }
    }
}

| Type                     | Complexity     |
| ------------------------ | -------------- |
| Time                     | **O(4^N * N)** |
| Space (auxiliary)        | **O(N)**       |
| Space (including output) | **O(4^N * N)** |
