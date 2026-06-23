Pattern Recognition: Two-pointers

Brute Force: Check every possible pair.
If numbers[i] + numbers[j] == target, return indices.
Uses two nested loops. Time: O(n²), Space: O(1)
// for(int i=0;i<n;i++)
//     for(int j=i+1;j<n;j++)
//         if(numbers[i]+numbers[j]==target)

Better Approach (HashMap):
Store each number and its index in a HashMap.
For every number, check if target - number already exists.
Return the pair when found. Time Complexity: O(n), Space Complexity: O(n)
// complement = target - numbers[i]
// if(map.containsKey(complement))
// map.put(numbers[i], i)

Not valid for Two Sum-II because the problem asks for constant extra space.

Optimal Approach (Two Pointers): Since the array is sorted, place one pointer at the start and another at the end.
If the sum is too small, move left++; if too large, move right--.
When the sum equals the target, return the 1-based indices. Time: O(n),Space : O(1)
If sum is small → left++.
If sum is large → right--.
// left=0, right=n-1
// if(sum < target) left++
// else right--

| Feature              | Two Sum           | Two Sum-II       |
| -------------------- | ----------------- | ---------------- |
| Array Sorted?        |  No               |  Yes             |
| Extra Space Allowed? |  HashMap          |  Constant Space  |
| Best Approach        | HashMap           | Two Pointers     |
| Time Complexity      | O(n)              | O(n)             |
| Space Complexity     | O(n)              | O(1)             |
| Return Indices       | Usually 0-indexed | 1-indexed        |

class Solution {
    public int[] twoSum(int[] numbers, int target) {

        // Pointer at the beginning of the array
        int left = 0;

        // Pointer at the end of the array
        int right = numbers.length - 1;

        // Continue until the pointers meet
        while (left < right) {

            // Calculate the current sum
            int sum = numbers[left] + numbers[right];

            // If target is found, return 1-based indices
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            }

            // If sum is smaller than target,
            // move left pointer right to increase the sum
            else if (sum < target) {
                left++;
            }

            // If sum is greater than target,
            // move right pointer left to decrease the sum
            else {
                right--;
            }
        }

        // This line will never execute because
        // the problem guarantees exactly one solution
        return new int[]{};
    }
}

