//HackerRank

Pattern Recognition — Difference Array + Prefix Sum
Many queries perform “add k to every element in range [a,b]” → think Difference Array.
Mark only the range boundaries: diff[a] += k, diff[b+1] -= k.
Take a prefix sum to get actual values and track the maximum.

Brute Force: For every query (a,b,k), loop from a to b.
Add k directly to every affected array element.
After all queries, find the maximum value. Time: O(n × q) worst case | Space: O(n)

Optimal: Create a diff array and record only start +k and end+1 -k for each query.
Traverse once, maintaining a running prefix sum to reconstruct each element's final value.
During this traversal, update the maximum instead of needing another pass. Time: O(n + q) | Space: O(n)

I process each of the q queries in constant time using a difference array, so that is O(q). Then I traverse the n 
positions once to calculate the prefix sum and maximum, which is O(n). Therefore the total time complexity is
 O(n + q) and the extra space is O(n)

class Result {

    public static long arrayManipulation(int n, List<List<Integer>> queries) {

        // Difference array
        // We use n + 2 so that we can safely access b + 1
        long[] diff = new long[n + 2];

        // Process every query
        for (List<Integer> query : queries) {

            int a = query.get(0);     // Starting index
            int b = query.get(1);     // Ending index
            int k = query.get(2);     // Value to add

            // Start adding k from index a
            diff[a] += k;

            // Stop adding k after index b
            // Therefore subtract k at b + 1
            diff[b + 1] -= k;
        }

        long current = 0;   // Running prefix sum
        long max = 0;       // Maximum value found

        // Prefix sum reconstructs the actual array values
        for (int i = 1; i <= n; i++) {

            current += diff[i];

            // Current = final value of arr[i]
            max = Math.max(max, current);
        }

        return max;
    }
}