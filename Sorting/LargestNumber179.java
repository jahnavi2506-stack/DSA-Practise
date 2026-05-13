Pattern Recognition:- Greedy + Custom Sorting 

Instead of generating all arrangements, we identify the optimal relative ordering between every pair using a comparator. Once the comparator 
correctly defines which pair ordering gives a larger concatenation, sorting automatically constructs the globally maximum arrangement.

That is all a comparator is: a rule to decide ordering between two elements.

We must compare: ab vs ba
This is a concatenation operation. Numbers do not naturally concatenate. Strings do.

We can do this mathematically without strings:- using powers of 10.
Example: ab = a x 10^(digits in b) + b
But: more complicated, risk of overflow, unnecessary. "Strings make comparator cleaner and safe"

BRUTE FORCE:- Generate all permutations of numbers.
Concatenate each permutation and track maximum formed value. Time: O(n! * n) , Space: O(n)

OPTIMAL:- Convert numbers to strings and sort using custom comparator.
For two strings a and b, compare (b+a) and (a+b) to decide order. Time: O(n log n) , Space: O(n)

class Solution {
    public String largestNumber(int[] nums) {

        // Step 1:
        // Convert all integers into strings
        // because we need concatenation comparison like:
        // "ab" vs "ba"
        String[] arr = new String[nums.length];

        for(int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }

        // Step 2:
        // Custom sorting
        //
        // We compare:
        // b+a  and  a+b
        //
        // Why?
        // Because we want larger concatenation first.
        //
        // Example:
        // a = "3", b = "30"
        //
        // "330" vs "303"
        //
        // Since "330" is bigger,
        // "3" should come before "30"
        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));

        // Step 3:
        // Edge case handling
        //
        // If the largest element after sorting is "0",
        // then all elements are zeros.
        //
        // Example:
        // ["0","0","0"]
        //
        // We should return "0" instead of "000"
        if(arr[0].equals("0")) {
            return "0";
        }

        // Step 4:
        // Build final answer using StringBuilder
        StringBuilder result = new StringBuilder();

        for(String num : arr) {
            result.append(num);
        }

        // Step 5:
        // Return final largest formed number
        return result.toString();
    }
}

StringBuilder-mutable buffer. Instead of creating new strings repeatedly[O(n^2)]:it modifies same memory. So appending becomes fast.[o(n)]