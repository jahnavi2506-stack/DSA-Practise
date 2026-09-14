Pattern Recognition: Two Pointers + String Manipulation.

Brute Force: Split the string using spaces.
Ignore empty strings caused by multiple spaces.
Reverse the list of words and join with " ". Time: O(n), Space: O(n)

Optimal: Use Two Pointers if you want to avoid unnecessary extra structures:
Remove/skip extra spaces and identify each word.Reverse the entire string.
Reverse each individual word. Time: O(n), Space: O(1)

class Solution {
    public String reverseWords(String s) {

        // Convert string to character array because String is immutable
        char[] arr = s.toCharArray();

        // Remove extra spaces and get the valid length
        int n = 0;
        int i = 0;

        while (i < arr.length) {

            // Skip leading and multiple spaces
            while (i < arr.length && arr[i] == ' ') {
                i++;
            }

            // Copy the word
            while (i < arr.length && arr[i] != ' ') {
                arr[n++] = arr[i++];
            }

            // Add only one space between words
            if (i < arr.length) {
                arr[n++] = ' ';
            }
        }

        // Remove the extra space at the end
        if (n > 0) {
            n--;
        }

        // Reverse the entire valid portion
        reverse(arr, 0, n - 1);

        // Reverse each individual word
        int start = 0;

        for (int end = 0; end <= n; end++) {

            // Word ends when we find a space or reach the end
            if (end == n || arr[end] == ' ') {
                reverse(arr, start, end - 1);
                start = end + 1;
            }
        }

        // Create result using only the valid portion
        return new String(arr, 0, n);
    }

    // Helper method to reverse characters between left and right
    private void reverse(char[] arr, int left, int right) {

        while (left < right) {

            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }
}