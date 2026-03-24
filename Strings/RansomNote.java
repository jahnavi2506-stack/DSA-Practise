class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
      int[] freq = new int[26];
      for(int i = 0; i < magazine.length(); i++) {
        freq[magazine.charAt(i) - 'a']++;
      }  
      for(int i = 0; i < ransomNote.length(); i++) {
        freq[ransomNote.charAt(i) - 'a']--;
        if(freq[ransomNote.charAt(i) - 'a'] < 0) {
            return false;
        }
      }
      return true;
    }
}

// Time Complexity:
// O(n + m)
// Where:
// •	n = length of ransomNote
// •	m = length of magazine
// Very efficient 

// Space Complexity:
// O(1)
// Why?
// Because array size is always 26 (constant).
