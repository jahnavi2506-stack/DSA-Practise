class Solution {
    public int lengthOfLastWord(String s) {
       int length = 0;
       int i = s.length() - 1;//Place pointer at the last character
       while (i >= 0 && s.charAt(i) == ' ') { //Skip trailing spaces
        i--;
       }
       while (i >= 0 && s.charAt(i) != ' ') { //Count characters of the last word
        length++;
        i--;
       }
       return length;
    }
}//o(n),o(1)
