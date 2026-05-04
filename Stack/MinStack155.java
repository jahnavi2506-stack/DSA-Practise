Pattern Recognition:- Monotonic Stack + Auxiliary Data Structure (Min Tracking) [prefix minimum maintenance inside stack]

BruteForce:- We use a normal stack. But for getMin(), we don’t store any extra information.
So every time we need the minimum:
we scan the entire stack
compare each element
track the smallest value.
If there are m operations and many getMin calls: Total cost becomes O(m × n)

int[] means:- array of integers type
new int[] means:- create a new array object
{...} means:- fill values inside that array

class MinStack {
    // Stack stores pairs: [value, minimum_so_far]
    Stack<int[]> st;

    public MinStack() {
        // Initialize the stack
        st = new Stack<>();
    }
    
    public void push(int val) {
        int minNum;

        // If stack is empty, current value is the minimum
        if (st.isEmpty()) {
            minNum = val;
        } 
        else {
            // Get previous minimum from top element
            int previousMin = st.peek()[1];

            // Update minimum for current state
            minNum = Math.min(val, previousMin);
        }

        // Push [value, current_min] as a state snapshot
        st.push(new int[]{val, minNum});
    }
    
    public void pop() {
        // Remove the latest state (LIFO)
        // No recalculation needed because previous state already stores correct min
        st.pop();//historical data - remove the most recent state, going back one step in time   
    }
    
    public int top() {
        // Return only the value part of top state
        return st.peek()[0];
    }
    
    public int getMin() {
        // Return minimum stored in top state
        return st.peek()[1];
    }
}