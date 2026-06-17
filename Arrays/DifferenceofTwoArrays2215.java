Pattern Recognition: HashSet

Brute Force Approach: Convert nums1 and nums2 into sets (or use nested loops directly).
For each element in nums1, check linearly if it exists in nums2 - collect missing. Repeat reverse for nums2 → nums1.
Time: O(n * m) (nested search),Space: O(1) extra (ignoring output)

Optimal Approach (HashSet): Insert all elements of nums1 into set1 and nums2 into set2.
Iterate set1 - add elements not in set2 to answer[0].
Iterate set2 - add elements not in set1 to answer[1]. Time: O(n + m),Space: O(n + m)

class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {

        // Step 1: Store unique elements of both arrays
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int num : nums1) set1.add(num);
        for (int num : nums2) set2.add(num);

        // Step 2: Prepare result lists
        List<Integer> onlyInNums1 = new ArrayList<>();
        List<Integer> onlyInNums2 = new ArrayList<>();

        // Step 3: Find elements in nums1 but not in nums2
        for (int num : set1) {
            if (!set2.contains(num)) {
                onlyInNums1.add(num);
            }
        }

        // Step 4: Find elements in nums2 but not in nums1
        for (int num : set2) {
            if (!set1.contains(num)) {
                onlyInNums2.add(num);
            }
        }

        // Step 5: Return final result as required format
        List<List<Integer>> result = new ArrayList<>();
        result.add(onlyInNums1);
        result.add(onlyInNums2);

        return result;
    }
}