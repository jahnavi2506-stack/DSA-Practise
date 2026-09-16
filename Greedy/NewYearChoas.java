// HackerRank
Pattern Recognition: Greedy + Inversion Counting.
Each person can move forward at most **2 positions**, so first check `q[i] - (i+1) > 2`.
Then count people who were originally behind but are now ahead → each crossing = **1 bribe**.

Brute Force: For every person, compare with **all people before them**; if `q[j] > q[i]`, count one bribe.
First check whether anyone moved forward more than 2; otherwise count all such inversions.
Time: `O(n²)` | Space:`O(1)`.

Optimal: For each `q[i]`, only check from `max(0, q[i]-2)` to `i-1`, because nobody could have moved forward more than 2.
If `q[j] > q[i]`, that means `q[j]` crossed `q[i]` → increment bribes.
Time: `O(n)` | Space:`O(1)`.

public static void minimumBribes(List<Integer> q) {

    int bribes = 0;

    // Step 1: Check if anyone has moved forward by more than 2 positions
    for (int i = 0; i < q.size(); i++) {

        int person = q.get(i);

        // Current position = i + 1
        // Original position = person
        // If original - current > 2, the person bribed more than 2 people
        if (person - (i + 1) > 2) {
            System.out.println("Too chaotic");
            return;
        }
    }

    // Step 2: Count the number of bribes
    for (int i = 0; i < q.size(); i++) {

        int person = q.get(i);

        /*
         * A person could have moved forward by at most 2 positions.
         * Therefore, we only need to check from person - 2.
         *
         * Math.max(0, ...) prevents the starting index from becoming negative.
         */
        int start = Math.max(0, person - 2);

        // Check only the people who could have crossed this person
        for (int j = start; j < i; j++) {

            /*
             * If q[j] > person:
             *
             * q[j] was originally behind 'person'
             * but is now ahead of 'person'.
             *
             * Therefore, q[j] must have bribed 'person'.
             */
            if (q.get(j) > person) {
                bribes++;
            }
        }
    }

    // Print the total number of bribes
    System.out.println(bribes);
}
