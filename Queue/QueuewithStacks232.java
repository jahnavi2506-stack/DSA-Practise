Pattern Recognition: Data structure simulation using two stacks to reverse order (LIFO → FIFO) with lazy transfer (amortized O(1)).

Brute Force:
Every pop/peek: move all elements from stack1 → stack2, do operation, then move back
Time: O(n) per operation, Space: O(n)
 Optimal
Use two stacks: push into stack1, and only transfer to stack2 when needed (lazy transfer)
Amortized Time: O(1), Space: O(n)

We don’t transfer every time because once elements are moved to stack2, 
they are already in correct FIFO order. We only transfer when stack2 becomes empty

class MyQueue {

    // Stack used for incoming elements (push operations)
    Stack<Integer> inStack;

    // Stack used for outgoing elements (pop/peek operations)
    Stack<Integer> outStack;

    public MyQueue() {
        // Initialize both stacks when object is created
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    public void push(int x) {
        // Always push into inStack
        // We do NOT maintain order here (lazy approach)
        inStack.push(x);
    }

    public int pop() {
        // If outStack is empty, we need to transfer elements
        // to get correct FIFO order
        if (outStack.isEmpty()) {

            // Move all elements from inStack → outStack
            // This reverses order and makes oldest element on top
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }

        // Now top of outStack is the front of queue
        return outStack.pop();
    }

    public int peek() {
        // Same logic as pop, but we don't remove element

        if (outStack.isEmpty()) {

            // Transfer only when needed (lazy transfer)
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }

        // Return front element without removing
        return outStack.peek();
    }

    public boolean empty() {
        // Queue is empty only when BOTH stacks are empty
        return inStack.isEmpty() && outStack.isEmpty();
    }
}