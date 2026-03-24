class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        int[] lps = new int[n];
        int len = 0;
        int i = 1;
        while(i < n) {
            if(s.charAt(i) == s.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if(len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        int last = lps[n - 1];
        if(last > 0 && n % (n - last) == 0){
            return true;
        }
       return false;
    }
}//o(n),o(n)

