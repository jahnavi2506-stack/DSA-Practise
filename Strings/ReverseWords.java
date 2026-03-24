//557
class Solution {
    public String reverseWords(String s) {
        char[] arr = s.toCharArray();   // Convert string to char array
        int wordStart = 0;
        for (int i = 0; i <= arr.length; i++) {
            // If space OR end of array, reverse current word
            if (i == arr.length || arr[i] == ' ') {
                int left = wordStart;
                int right = i - 1;
                while (left < right) {
//Because we only need to swap characters until both pointers meet in the middle.
                    char temp = arr[left];
                    arr[left] = arr[right];
                    arr[right] = temp;
                   left++;
                    right--;
                }
                wordStart = i + 1; // Move start to next word
            }
        }
        return new String(arr);
    }
}     
//o(n),o(n)
//“I convert the string into a char array and use two pointers to reverse each word whenever I hit a space or the end of the string. This gives O(n) time complexity.” Strict O(1) extra space is impossible in Java because String is immutable. But this is considered optimal.
