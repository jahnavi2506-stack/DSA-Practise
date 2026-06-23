Pattern Recognition: HashSet + Sliding Window

Brute Force Approach: For every element, check the next k elements.
If any duplicate is found, return true.
Otherwise return false. Time: O(n × k) (Worst case O(n²)), Space: O(1)

Optimal Approach (Sliding Window + HashSet)
Maintain a HashSet containing the last k elements (sliding window).
If the current element already exists in the set, a duplicate is found within distance ≤ k.
Add the current element and remove the element that falls outside the window. Time  : O(n), Space : O(min(n, k))

class Solution {

    public boolean containsNearbyDuplicate(int[] nums, int k) {

        // Sliding window to store at most k previous elements
        HashSet<Integer> window = new HashSet<>();

        // Traverse the array
        for (int i = 0; i < nums.length; i++) {

            // If current element already exists in the window,
            // then a duplicate is found within distance <= k
            if (window.contains(nums[i])) {
                return true;
            }

            // Add current element to the window
            window.add(nums[i]);

            // If window size exceeds k,
            // remove the leftmost (oldest) element
            // nums[i - k] is the element that falls out of the window
            if (window.size() > k) {
                window.remove(nums[i - k]);
            }
        }

        // No duplicate found within distance <= k
        return false;
    }
}