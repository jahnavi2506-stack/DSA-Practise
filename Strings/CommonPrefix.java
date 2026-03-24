class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        // Edge case
        if (strs == null || strs.length == 0) 
            return "";
        
        // Take first string as initial prefix
        String prefix = strs[0];
        
        // Compare with remaining strings
        for (int i = 1; i < strs.length; i++) {
            
            // While current string does not start with prefix
            while (strs[i].indexOf(prefix) != 0) {
                
                // Reduce prefix
                prefix = prefix.substring(0, prefix.length() - 1);                
                if (prefix.isEmpty())
                    return "";
            }
        }
        
        return prefix;
    }
}
// TC
// •	n = number of strings
// •	m = length of smallest string
// Worst case:
// O(n * m)
// Space Complexity -- O(1)
