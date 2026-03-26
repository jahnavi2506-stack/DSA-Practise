class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) return res;
        String[] map = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backtrack(res, map, digits, 0, new StringBuilder());
        return res;
    }
    
    private void backtrack(List<String> res, String[] map, String digits, int index, StringBuilder sb) {
        if (index == digits.length()) {
            res.add(sb.toString());
            return;
        }
        
        String str = map[digits.charAt(index) - '0'];
        for (char c : str.toCharArray()) {
            sb.append(c);
            backtrack(res, map, digits, index + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}