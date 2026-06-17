Pattern Recognition: HashMap

Brute Force Approach: Check every possible pair (i, j).
If nums[i] + nums[j] == target, return their indices.
Since all pairs are checked, the answer is guaranteed to be found.
Time: O(n²), Space: O(1)

for(int i = 0; i < n; i++) {
    for(int j = i + 1; j < n; j++) {
        if(nums[i] + nums[j] == target)
            return new int[]{i, j};
    }
}

Optimal Approach (HashMap): Traverse the array once.
For each number, calculate its complement (target - current).
If the complement exists in HashMap, return both indices; otherwise store the current number and its index. Time: O(n), Space: O(n)

class Solution {
    public int[] twoSum(int[] nums, int target) {

        // Stores: number -> index
        HashMap<Integer, Integer> map = new HashMap<>();

        // Traverse the array once
        for (int i = 0; i < nums.length; i++) {

            // Number needed to reach target
            int complement = target - nums[i];

            // If complement already exists,
            // we found the pair
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }

            // Store current number and its index
            map.put(nums[i], i);
        }

        // Problem guarantees exactly one solution,
        // create an integer array with 0 elements.so this line will never be reached
        return new int[] {}; //Java expects array values inside {}
    }
}

i//n HashSet .add is allowed but not in HashMap so we use .put