Pattern Recognition: Binary Search on Answer Space

Brute Force: Traverse the entire array and check whether the current element is greater than both neighbors.
If `nums[i] > leftNeighbor` and `nums[i] > rightNeighbor`, return that index immediately. Time: O(n) , Space: O(1)

Optimal: Use Binary Search and compare `nums[mid]` with `nums[mid + 1]` to identify slope direction.
If decreasing slope → peak lies on left including `mid`; if increasing slope → peak lies on right. Time: O(log n) , Space: O(1)

Binary Search here is not searching for a specific peak. It is searching for:any location where left side decreases and right side decreases.
So whichever peak the search path reaches first becomes the answer


class Solution {
    public int findPeakElement(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        // Binary Search
        while (left < right) {

            int mid = left + (right - left) / 2;

            // We are in decreasing part
            // Peak is on left side including mid
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            }

            // We are in increasing part
            // Peak is on right side
            else {
                left = mid + 1;
            }
        }

        // left == right -> peak index
        return left;
    }
}