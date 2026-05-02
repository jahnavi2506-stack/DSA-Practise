Pattern Recognition:- Monotonic(decreasing) Stack
we store span but not indices: 
Each element in stack already knows how many days it covers
So when we pop it, we don’t recompute anything
We just merge its span into current span

When you pop an element, you are not removing one day, you are removing a whole block of days

BruteForce:
For each incoming price, I iterate backwards through previous prices and 
count how many consecutive elements are ≤ current price. I stop when I encounter a greater element--o(n^2) time, o(n) space

class StockSpanner {

    // Stack stores pairs: {price, span}
    // span = number of consecutive days covered by this price
    Stack<int[]> st;

    // Constructor: initializes empty stack
    public StockSpanner() {
        st = new Stack<>();
    }

    public int next(int price) {

        // Step 1: every day contributes at least itself
        int span = 1;

        // Step 2: remove all previous smaller or equal prices
        // because current price "dominates" them
        while (!st.isEmpty() && price >= st.peek()[0]) {

            int[] top = st.pop(); // remove dominated element

            // add its full span (not just 1 day)
            span += top[1];
        }

        // Step 3: push current price with computed span
        st.push(new int[]{price, span});

        // Step 4: return span for today
        return span;
    }
}
//o(n) time, o(n) space
