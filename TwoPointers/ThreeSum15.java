Pattern Recognition: Two-pointers + sorting

Brute Force: Generate every possible triplet using 3 loops.
Check if sum is 0.Use a Set to avoid duplicates.
Time  : O(n³),Space : O(k)  // for storing unique triplets

Optimal Approach:
Sort the array. Fix one element and use two pointers on remaining array.
Skip duplicates to avoid repeated triplets.
Time  : O(n²), Space : O(1)   // ignoring answer list [O(n log n) + O(n²) =  O(n²)]

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);  // Step 1: sort the array

        for (int i = 0; i < nums.length - 2; i++) {  // Step 2: fix nums[i]

            // Skip duplicate fixed elements
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {  // Step 3: two pointer
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    // Found a valid triplet
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Skip duplicates for left pointer
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    left++;

                    // Skip duplicates for right pointer
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    right--;

                } else if (sum < 0) {
                    left++;  // Need bigger sum
                } else {
                    right--; // Need smaller sum
                }
            }
        }

        return result;
    }
}
