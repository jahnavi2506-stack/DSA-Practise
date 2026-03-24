class Solution {
    public int longestPalindrome(String s) {
      HashMap<Character, Integer> map = new HashMap<>();
     for(int i = 0; i < s.length(); i++) {
        char ch = s.charAt(i);
        map.put(ch,map.getOrDefault(ch, 0) + 1);
     }
     int length = 0;
     boolean hasOdd = false;
     for(int values : map.values()) {
        if((values % 2) == 0) {
            length += values;
        }
        else {
            length += values - 1;
            hasOdd = true;
        }
     }
     if (hasOdd) {
        length += 1;
     }
     return length; 
    }
}
