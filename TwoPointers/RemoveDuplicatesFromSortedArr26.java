Pattern Recognition: Two-pointers

Brute Force:Traverse the array and store unique elements in a new list/set.Copy unique elements back into nums.
Return count of unique elements. Time: O(n),Space: O(n)

Optimal Approach: Use two pointers: i for last unique element and j for traversal.
When nums[j] != nums[i], place it at i+1.
Return i + 1 as the count of unique elements. Time: O(n),Space: O(1)

class Solution {
    public int removeDuplicates(int[] nums) {

        // j points to the position of the last unique element
        int j = 0;

        // i scans the array from the second element onwards
        for (int i = 1; i < nums.length; i++) {

            // If a new unique element is found
            if (nums[i] != nums[j]) {

                // Move j to the next position
                j++;

                // Place the new unique element at index j
                nums[j] = nums[i];
            }
        }

        // Number of unique elements = last index + 1
        return j + 1;
    }
}