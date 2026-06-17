Pattern Recognition: HashSet

Bruteforce Approach: For each element in nums1, check if it exists in nums2 using loop
If yes, store in result if not already present. Time: O(n×m), Space: O(k) (result)

Optimal Approach: Convert nums1 to a set for O(1) lookup
Iterate nums2 and check membership in set, store unique results. Time: O(n + m), Space: O(n)

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        // Step 1: Store all elements of nums1 in a HashSet
        // Why? → For O(1) average lookup time and automatic duplicate removal
        Set<Integer> set1 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }

        // Step 2: Create a result set to store unique intersections
        Set<Integer> resultSet = new HashSet<>();

        // Step 3: Traverse nums2 and check if element exists in set1
        for (int num : nums2) {
            if (set1.contains(num)) {
                resultSet.add(num); // ensures uniqueness in output
            }
        }

        // Step 4: Convert resultSet to array (required output format)
        int[] result = new int[resultSet.size()];
        int i = 0;

        for (int num : resultSet) {
            result[i++] = num;
        }

        return result;
    }
}