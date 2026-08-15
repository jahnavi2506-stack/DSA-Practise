Pattern Recognition: Prefix Sum + HashMap

Brute Force Approach: Use two loops to generate every possible subarray.
Keep adding elements and check if the current sum equals k; if yes, increment count.
This checks all possible subarrays. Time: O(n²),Space: O(1)

Optimal Approach: Maintain a running prefix sum and store the frequency of each prefix sum in a HashMap.
For every sum, check how many times sum - k has appeared; those represent subarrays with sum k.
Add the current prefix sum to the HashMap and continue. Time: O(n), Space: O(n)

class Solution {
    public int subarraySum(int[] nums, int k) {

        // Stores: prefix sum -> frequency
        HashMap<Integer, Integer> map = new HashMap<>();

        // Important:
        // Prefix sum 0 has occurred once before we start.
        // This helps count subarrays starting from index 0.
        map.put(0, 1);

        int sum = 0;   // Current prefix sum
        int count = 0; // Number of valid subarrays

        for (int num : nums) {

            // 1. Calculate current prefix sum
            sum += num;

            // 2. We need an earlier prefix sum of (sum - k)
            // because:
            // currentSum - previousSum = k
            int required = sum - k;

            // 3. If required prefix sum exists,
            // every occurrence gives one valid subarray.
            if (map.containsKey(required)) {
                count += map.get(required);
            }

            // 4. Store/update frequency of current prefix sum
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        // Return total number of subarrays whose sum is k
        return count;
    }
}