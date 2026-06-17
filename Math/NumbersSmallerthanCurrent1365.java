Pattern Recognition: Ranking / Counting Smaller Elements Pattern.

But after sorting, we've lost the original order. We'd need to store original indices and map answers back.
At that point, we're no longer really using a "two-pointer" technique—it's a sorting + indexing problem.

Brute Force Approach: For every element nums[i], compare it with every other element.
Count how many elements are smaller than nums[i].
Store the count in the answer array. Time: O(n²), Space: O(1) (excluding output array)

Optimal Approach (Counting Sort / Frequency Array):Since values range only from 0 to 100, create a frequency array of size 101.
Compute how many numbers are smaller than each value using prefix sums.
For every nums[i], directly look up the count of smaller numbers.Time: O(n + 101) ≈ O(n), Space: O(101) ≈ O(1)

class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {

        // Frequency array because nums[i] is between 0 and 100
        int[] freq = new int[101];

        // Count occurrences of each number
        for (int num : nums) {
            freq[num]++;
        }

        // Convert frequency array into prefix counts
        // freq[i] will store how many numbers are smaller than i
        int smallerCount = 0;

        for (int i = 0; i < 101; i++) {
            int currentFreq = freq[i];
            freq[i] = smallerCount;
            smallerCount += currentFreq;
        }

        // Build the answer array
        int[] ans = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            ans[i] = freq[nums[i]];
        }

        return ans;
    }
}