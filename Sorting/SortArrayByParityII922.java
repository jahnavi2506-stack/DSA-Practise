Pattern Recognition:- Two Pointers, Swapping misplaced elements, In-place Rearrangement

Brute Force:- Create a new result array and maintain: evenIndex = 0, oddIndex = 1.
Traverse nums: place even numbers at evenIndex,odd numbers at oddIndex.
After every placement, move respective index by +2 to maintain correct parity positions. Time: O(n), Space: O(n)

Optimal Approach:- Use two pointers: one scans even indices for misplaced odd values, another scans odd indices for misplaced even values.
When both wrong positions are found, swap them because one swap fixes both violations.
Move pointers only by +2 so each pointer stays restricted to its parity indices.

class Solution {
    public int[] sortArrayByParityII(int[] nums) {

        // Pointer for EVEN indices: 0, 2, 4, 6...
        int even = 0;

        // Pointer for ODD indices: 1, 3, 5, 7...
        int odd = 1;

        // Traverse only through even indices
        // We check whether even positions contain correct values
        while (even < nums.length && odd < nums.length) {

            /*
             If current even index already contains an even number,
             then this position is correct.

             Move to next even index.
            */
            if (nums[even] % 2 == 0) {
                even += 2;
            }

            /*
             Current even index has WRONG value (odd number).

             Now find an odd index that also has WRONG value
             (i.e., even number at odd index).
            */
            else {

                // Move odd pointer until we find misplaced even number
                The inner while loop skips correctly placed odd values and stops only at an 
                odd index having a wrong even value, so one swap fixes both mismatches efficiently in O(n) time.
                while (nums[odd] % 2 == 1) {
                    odd += 2;
                }

                /*
                 Swap both misplaced elements.

                 Before swap:
                 even index -> odd value 
                 odd index  -> even value 

                 After swap:
                 both positions become correct 
                */
                int temp = nums[even];
                nums[even] = nums[odd];
                nums[odd] = temp;

                // Move to next positions
                even += 2;
                odd += 2;
            }
        }

        return nums;
    }
}

Although there is a nested while loop, each pointer moves forward independently and never revisits indices. So total operations remain linear.