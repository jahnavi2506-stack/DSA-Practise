Pattern Recognition: Intervals + Merge overlapping ranges → Sort + Greedy

Brute Force Algorithm
Compare every interval with every other interval and merge overlaps.
Repeat until no more merges are possible. TC: O(n²) SC: O(1)

Optimal Algorithm
Sort intervals by start time.
If current interval overlaps with the last merged interval, update its end; otherwise, add it as a new interval.
TC: O(n log n) (sorting) SC: O(n)

class Solution {
    public int[][] merge(int[][] intervals) {

        // Step 1: Sort intervals based on start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> merged = new ArrayList<>();

        // Add the first interval
        merged.add(intervals[0]);

        // Step 2: Traverse remaining intervals
        for (int i = 1; i < intervals.length; i++) {

            int[] last = merged.get(merged.size() - 1);

            // Overlapping intervals
            if (intervals[i][0] <= last[1]) {

                // Extend the end if needed
                last[1] = Math.max(last[1], intervals[i][1]);

            } else {

                // No overlap, add current interval
                merged.add(intervals[i]);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
}