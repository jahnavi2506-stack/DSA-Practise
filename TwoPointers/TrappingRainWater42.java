Pattern Recognition: Two-pointers

Brute Force: For every index, scan left to find leftMax and scan right to find rightMax.
Calculate water = min(leftMax, rightMax) - height[i] and add it. Time: O(n²) | Space: O(1).

Optimal Approach: Keep two pointers left and right, plus leftMax and rightMax.
Process the side with the smaller current height; trapped water is calculated using that side's maximum.
Time: O(n) | Space: O(1).

class Solution {
    public int trap(int[] height) {

        // Two pointers: one starts from the left, one from the right
        int left = 0;
        int right = height.length - 1;

        // Store the tallest wall seen so far from each side
        int leftMax = 0;
        int rightMax = 0;

        // Total amount of trapped water
        int water = 0;

        // Process the array from both ends
        while (left <= right) {

            // The shorter current boundary determines the water level
            if (height[left] <= height[right]) {

                // If current left bar is the tallest seen so far,
                // update leftMax
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } 
                // Otherwise, water can be trapped above this bar
                else {
                    water += leftMax - height[left];
                }

                // Move left pointer inward
                left++;

            } else {

                // Process the right side because right bar is shorter

                // If current right bar is the tallest seen so far,
                // update rightMax
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } 
                // Otherwise, water can be trapped above this bar
                else {
                    water += rightMax - height[right];
                }

                // Move right pointer inward
                right--;
            }
        }

        // Return total trapped water
        return water;
    }
}