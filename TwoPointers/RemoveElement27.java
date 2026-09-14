Pattern Recognition: Two Pointers 

Brute Force: Create a new array/list and copy only elements where `nums[i] != val`.
Copy those valid elements back into the original `nums` array.
Return the number of valid elements copied, `k`. Time: `O(n)`, Space: `O(n)`

Optimal: Use `read` to scan every element and `write` to track where the next non-`val` element should go.
Whenever `nums[read] != val`, put it at `nums[write]` and increment `write`.
Return `write` as `k`, because it represents the number of elements kept. Time:`O(n)`, Space:`O(1)`

class Solution {
    public int removeElement(int[] nums, int val) {

        // write points to the position where the next valid element
        // (element not equal to val) should be placed.
        int write = 0;

        // read scans every element of the array
        for (int read = 0; read < nums.length; read++) {

            // Keep the element if it is not equal to val
            if (nums[read] != val) {

                // Place the valid element at the write position
                nums[write] = nums[read];

                // Move write to the next position
                write++;
            }
        }

        // write represents the number of elements not equal to val
        // Therefore, write = k
        return write;
    }
}