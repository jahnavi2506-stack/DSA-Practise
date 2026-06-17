Pattern Recognition: Two-pointers

Brute Force:Traverse the array and store unique elements in a new list/set.Copy unique elements back into nums.
Return count of unique elements. Time: O(n),Space: O(n)

Optimal Approach: Use two pointers: i for last unique element and j for traversal.
When nums[j] != nums[i], place it at i+1.
Return i + 1 as the count of unique elements. Time: O(n),Space: O(1)

class Solution {
    public int removeDuplicates(int[] nums) {

        // i points to the last unique element found
        int i = 0;

        // j scans the array
        for (int j = 1; j < nums.length; j++) {

            // Found a new unique element
            if (nums[j] != nums[i]) {

                // Move i to the next position
                i++;

                // Place the unique element there
                nums[i] = nums[j];
            }
        }

        // Number of unique elements
        return i + 1;
    }
}