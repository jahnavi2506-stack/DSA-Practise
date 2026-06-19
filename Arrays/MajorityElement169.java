Pattern Recognition: Boyer-Moore Voting Algorithm
Brute Force: For each element, count its occurrences by scanning the entire array.
If count > n/2, return that element.
Time Complexity: O(n²), Space Complexity: O(1)

Better Approach (HashMap): Store frequency of each element in a HashMap.
Return the element whose frequency becomes greater than n/2.
Time Complexity: O(n), Space Complexity: O(n)

Optimal Approach (Boyer-Moore Voting Algorithm): Maintain a candidate and a count.
If count becomes 0, choose the current element as candidate. Increment count for same element, decrement for different elements.
Time Complexity: O(n), Space Complexity: O(1)

class Solution {
    public int majorityElement(int[] nums) {

        // Stores the current majority candidate
        int candidate = 0;

        // Keeps track of the candidate's vote count
        int count = 0;

        // Traverse the array
        for (int num : nums) {

            // If count becomes 0,
            // choose the current element as the new candidate
            if (count == 0) {
                candidate = num;
            }

            // If the current element matches the candidate,
            // increase the vote count
            if (num == candidate) {
                count++;
            }
            // Otherwise, decrease the vote count
            else {
                count--;
            }
        }

        // The remaining candidate is the majority element
        return candidate;
    }
}
