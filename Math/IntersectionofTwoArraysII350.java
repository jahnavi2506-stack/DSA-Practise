Pattern Recognition: HashMap (frequency counting) 

Brute Force: Compare every element of nums1 with every element of nums2.
Once a match is found, add it and mark that element in nums2 as used.
Continue until all elements are checked. Time  : O(N × M), Space : O(1)

Optimal Approach (HashMap - Best for Unsorted Arrays)
Store the frequency of every element of nums1 in a HashMap.
Traverse nums2; if the element exists with frequency > 0, add it to the answer and decrease its frequency.
This naturally keeps duplicates only as many times as they appear in both arrays. Time  : O(N + M), Space : O(N)

import java.util.*;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {

        // Step 1: Create a HashMap to store the frequency of elements in nums1
        // Key   -> Array element
        // Value -> Number of times it appears
        HashMap<Integer, Integer> map = new HashMap<>();

        // Step 2: Count the frequency of every element in nums1
        for (int num : nums1) {
            // If num already exists, increment its frequency
            // Otherwise, insert it with frequency 1
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Step 3: Store the intersection elements
        ArrayList<Integer> list = new ArrayList<>();

        // Step 4: Traverse nums2
        for (int num : nums2) {

            // Check if the current element exists in nums1
            // AND its frequency is still greater than 0
            if (map.containsKey(num) && map.get(num) > 0) {

                // Common element found
                list.add(num);

                // Decrease its frequency because one occurrence is used
                map.put(num, map.get(num) - 1);
            }
        }

        // Step 5: Convert ArrayList<Integer> to int[]
        int[] result = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        // Step 6: Return the final intersection array
        return result;
    }
}