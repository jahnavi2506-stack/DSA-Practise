Pattern Recognition: Two-pointers

Brute Force Approach (HashSet): Insert all elements of both arrays into a HashSet.
HashSet automatically removes duplicates.
Convert the set into a list/array and sort it. Time  : O((N + M) log(N + M)), Space : O(N + M)

Optimal Approach (Two Pointers): Since arrays are already sorted, use two pointers.
Compare elements and always insert the smaller one. Time  : O(N + M), Space : O(N + M)   // Output array not counted in interviews

import java.util.*;

class Solution {

    public int[] unionArray(int[] nums1, int[] nums2) {

        // Pointer for nums1
        int i = 0;

        // Pointer for nums2
        int j = 0;

        // Stores the final union
        ArrayList<Integer> ans = new ArrayList<>();

        // Traverse both arrays together
        while (i < nums1.length && j < nums2.length) {

            // nums1 element is smaller
            if (nums1[i] < nums2[j]) {

                // Add only if it is not a duplicate
                if (ans.isEmpty() || ans.get(ans.size() - 1) != nums1[i]) {
                    ans.add(nums1[i]);
                }

                i++;
            }

            // nums2 element is smaller
            else if (nums1[i] > nums2[j]) {

                // Add only if it is not a duplicate
                if (ans.isEmpty() || ans.get(ans.size() - 1) != nums2[j]) {
                    ans.add(nums2[j]);
                }

                j++;
            }

            // Both elements are equal
            else {

                // Add only once
                if (ans.isEmpty() || ans.get(ans.size() - 1) != nums1[i]) {
                    ans.add(nums1[i]);
                }

                // Move both pointers
                i++;
                j++;
            }
        }

        // Add remaining elements from nums1
        while (i < nums1.length) {

            if (ans.isEmpty() || ans.get(ans.size() - 1) != nums1[i]) {
                ans.add(nums1[i]);
            }

            i++;
        }

        // Add remaining elements from nums2
        while (j < nums2.length) {

            if (ans.isEmpty() || ans.get(ans.size() - 1) != nums2[j]) {
                ans.add(nums2[j]);
            }

            j++;
        }

        // Convert ArrayList to int[]
        int[] result = new int[ans.size()];

        for (int k = 0; k < ans.size(); k++) {
            result[k] = ans.get(k);
        }

        return result;
    }
}