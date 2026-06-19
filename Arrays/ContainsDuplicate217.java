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
      
       int i = 0;
       for(int j = 1; j < nums.length; j++){
        if(nums[i] != nums[j]) {
            i++;
           nums[i] = nums[j];
        }
       } 
       return i + 1;
    }
}//o(n),o(1)
According to constraints, length is at least 1. If it was guaranteed.