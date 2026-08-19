Pattern Recognition: In-place Array Manipulation + Encoding Technique

Brute Force: Create a new array and set ans[i] = nums[nums[i]].
Traverse the array once. Time: O(n) | Space: O(n)

Optimal Approach: Encode both values as nums[i] + (nums[nums[i]] % n) * n.
% n gets the old value; / n later extracts the new value. Time: O(n) | Space: O(1)

//1920
// class Solution {                                                                        
//     public int[] buildArray(int[] nums) {
//       int n = nums.length;
//       int[] ans = new int[n];
//       for(int i = 0; i < n; i++) {
//         ans[i] =nums[nums[i]];
//       } 
//       return ans;
//     }
// }//o(n),o(n)

class Solution {
    public int[] buildArray(int[] nums) {

        // n = length of the array
        int n = nums.length;

        /*
         * Goal:
         * ans[i] = nums[nums[i]]
         *
         * We cannot use another array because we want O(1) space.
         *
         * Problem:
         * If we directly modify nums[i], we may lose its original value.
         *
         * Trick:
         * Store BOTH old value and new value in the same number.
         *
         * Encoding:
         * OLD + NEW * n
         *
         * % n -> gets OLD value
         * / n -> gets NEW value
         */

        // First loop: encode OLD and NEW values together
        for (int i = 0; i < n; i++) {

            /*
             * nums[i]               -> OLD value
             * nums[nums[i]]         -> NEW value we need
             * % n                   -> gets original NEW value
             * * n                   -> shifts NEW value
             *
             * So we store:
             * OLD + NEW * n
             */
            nums[i] = nums[i] + (nums[nums[i]] % n) * n;
        }

        // Second loop: decode and extract the NEW value
        for (int i = 0; i < n; i++) {

            /*
             * Each element is:
             * OLD + NEW * n
             *
             * Dividing by n extracts NEW
             * because OLD < n.
             */
            nums[i] = nums[i] / n;
        }

        // nums now contains the required answer
        return nums;
    }
}

/*
 * Time Complexity:
 * First loop  -> O(n)
 * Second loop -> O(n)
 * Total       -> O(n)
 *
 * Space Complexity:
 * No extra array is used
 * -> O(1)
 */

