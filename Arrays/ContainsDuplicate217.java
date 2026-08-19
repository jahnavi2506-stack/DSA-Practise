Pattern Recognition: Two-pointer

HashSet stores only values, HashMap stores key–value pairs.

Brute Force: Compare each element with every other element using nested loops.
If any two elements are equal, return true; otherwise return false.
Time Complexity: O(n²), Space Complexity: O(1)

Optimal Approach (HashSet): Traverse the array and store each element in a HashSet.
If an element is already present in the set, return true; otherwise add it to the set.
Time Complexity: O(n), Space Complexity: O(n)

Follow-up Approach (Two Pointers): Use (i and j).
j scans the array.
i keeps track of the position where the next unique element should be placed.
No extra data structures are used. Time Complexity: O(n), Space Complexity: O(1)

              HashSet
class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums) {
            if(set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }
}//o(n),o(n)

                     Two-pointer
class Solution {
    public int removeDuplicates(int[] nums) {

        // i points to the position of the last unique element
        int i = 0;

        // j scans the array to find new unique elements
        for (int j = 1; j < nums.length; j++) {

            // If nums[j] is different, we found a new unique value
            if (nums[i] != nums[j]) {

                // Move i to the next position for the unique value
                i++;

                // Store the new unique value
                nums[i] = nums[j];
            }
        }

        // i is an index, so number of unique elements = i + 1
        return i + 1;
    }
}
According to constraints, length is at least 1. If it was guaranteed.