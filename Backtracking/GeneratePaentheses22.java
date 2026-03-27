This is a backtracking problem with constraint-based pruning, 
where we build only valid sequences using counts of open and close parentheses

class Solution {
    public List<String> generateParenthesis(int n) {
       List<String> result = new ArrayList<>();

       backtrack(result, new StringBuilder(), 0, 0, n);
       return result;
    }
    public void backtrack(List<String> result, StringBuilder current, int openCount, int closeCount, int n) {
        if(current.length() == 2 * n) {
         result.add(current.toString());
         return ;
        }
       if(openCount < n) {
        current.append('(');
        backtrack(result, current, openCount + 1, closeCount, n);
        current.deleteCharAt(current.length() - 1);
       }
       if(closeCount < openCount) {
        current.append(')');
        backtrack(result, current, openCount, closeCount + 1, n);
        current.deleteCharAt(current.length()- 1);
       }
    }
}
Time complexity is O(4^n / √n) due to Catalan number growth, and space is O(n) excluding output,
including output is O(4^n / √n * n) due to storing all valid combinations.  