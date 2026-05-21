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