Pattern Recognition:- Monotonic Stack

We store indices so we can both compare values and compute distance (i - previousIndex)
Stack stores indices, but comparisons are done using values from array

I use a monotonic decreasing stack storing indices.
While traversing left to right, for each temperature, I check if it can resolve previous smaller temperatures.
While current temperature is greater than the temperature at stack top, I pop and compute the number of days difference.
This ensures each element is processed once, giving O(n) time complexity.

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        // Step 1: size of input array
        int n = temperatures.length;

        // Step 2: monotonic stack storing INDICES of unresolved days
        Deque<Integer> st = new ArrayDeque<>();

        // Step 3: answer array initialized with 0
        // default 0 means "no warmer day found"
        int[] answer = new int[n];

        // Step 4: traverse left to right
        for (int i = 0; i < n; i++) {

            // current temperature at index i
            int curr = temperatures[i];

            // Step 5: resolve all previous days that are colder than current
            while (!st.isEmpty() && curr > temperatures[st.peek()]) {

                // index of previous colder day
                int idx = st.pop();

                // distance between current day and previous day
                answer[idx] = i - idx;
            }

            // Step 6: push current index (still waiting for warmer day)
            st.push(i);
        }

        // Step 7: remaining indices in stack have no warmer day → stay 0
        return answer;
    }
}