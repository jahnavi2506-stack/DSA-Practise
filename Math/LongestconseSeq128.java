Pattern Recognition: HashSet

Unsorted array
      ↓
Need consecutive numbers
      ↓
HashSet
      ↓
Find where a sequence STARTS
      ↓
Count forward

Brute Force Approach: For every nums[i], check whether nums[i] + 1 exists.
Continue finding consecutive numbers and count their length.
Keep track of the maximum length. Time  : O(n²), Space : O(1)

Optimal Approach:- Put every number into a HashSet.
For every number num, check whether num - 1 exists.
If num - 1 doesn't exist, num is the beginning of a sequence; keep checking num + 1, num + 2, etc.
Track the maximum sequence length. Time  : O(n) average, Space : O(n)

import java.util.HashSet;

class Solution {
    public int longestConsecutive(int[] nums) {

        // Store all numbers for O(1) average lookup
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int longest = 0;

        // Check every number
        for (int num : set) {

            // Start counting only if num is the
            // beginning of a consecutive sequence.
            // If num - 1 exists, num is not the start.
            if (!set.contains(num - 1)) {

                int current = num;
                int length = 1;

                // Keep checking the next consecutive number
                while (set.contains(current + 1)) {
                    current++;
                    length++;
                }

                // Update maximum sequence length
                longest = Math.max(longest, length);
            }
        }

        return longest;
    }
}
