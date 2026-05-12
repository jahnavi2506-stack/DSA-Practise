Pattern Recognition:- Greedy + Sorting (Pairing Optimization, Greedy Pair Formation)

We are asked:- “How do we arrange digits so that the SUM becomes minimum?”

class Solution {
    public int minimumSum(int num) {

        // Array to store 4 digits
        int[] digits = new int[4];

        /*
            STEP 1: Extract digits from number

            Example:
            num = 2932

            Iteration 1:
            2932 % 10 = 2
            num = 293

            Iteration 2:
            293 % 10 = 3
            num = 29

            Iteration 3:
            29 % 10 = 9
            num = 2

            Iteration 4:
            2 % 10 = 2
            num = 0

            Final digits array:
            [2, 3, 9, 2]
        */
        for(int i = 0; i < 4; i++) {
            digits[i] = num % 10; // get last digit
            num /= 10;            // remove last digit
        }

        /*
            STEP 2: Sort digits in ascending order

            Before sorting:
            [2, 3, 9, 2]

            After sorting:
            [2, 2, 3, 9]

            WHY SORT?

            Smaller digits should occupy higher place values
            to minimize overall sum.
        */
        Arrays.sort(digits);

        /*
            STEP 3: Form two minimum numbers

            Greedy Idea:
            Distribute digits alternately to keep both numbers balanced.

            digits = [2, 2, 3, 9]

            new1 = 23
            new2 = 29

            Why?

            Smaller digits (2,2) go into tens places.
            Larger digits (3,9) stay in ones places.

            This minimizes total sum.
        */

        // First minimum number
        int new1 = digits[0] * 10 + digits[2];

        // Second minimum number
        int new2 = digits[1] * 10 + digits[3];

        /*
            STEP 4: Return minimum possible sum

            Example:
            23 + 29 = 52
        */
        return new1 + new2;
    }
}