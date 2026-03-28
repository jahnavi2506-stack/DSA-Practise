This problem is:- Backtracking + Partitioning Pattern
We try to build partitions of the string, and for each partition, we check if it's a palindrome. 
If it is, we continue to build the next partition from the remaining substring.

class Solution {
    public List<List<String>> partition(String s) {
       List<List<String>> result = new ArrayList<>();
       List<String> current = new ArrayList<>();

       backtrack(result, current, s, 0); 
       return result;
    }
    public void backtrack( List<List<String>> result, List<String> current, String s, int index) {
        if(index == s.length()) {
            result.add(new ArrayList<>(current));
            return ;
        } 

        for(int end = index; end < s.length(); end++)  {
            String part = s.substring(index, end + 1);
            if(isPalindrome(s, index, end)) {
                current.add(part);
                backtrack(result,current, s, end + 1);
                current.remove(current.size() - 1);
            }
        } 
    }
    public boolean isPalindrome(String s, int left, int right) {
        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

Time Complexity:- O(N * 2^N)
Each index → split or not split → ~2 choices
Palindrome check → O(N)

Space Complexity:- O(N)
recursion depth
current list

optimize palindrome checking
👉 Precompute DP table (advanced)