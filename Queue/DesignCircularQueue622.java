Pattern Recognition:- Circular Array + Modulo Arithmetic


"Pointers define validity,not actual array contents."

Brute Force Approach:- 
Use a normal array queue and whenever deQueue() happens, shift all remaining elements one step left to maintain order.
Insertion happens at rear normally, but deletion is costly because of shifting.
Time Complexity: enQueue → O(1), deQueue → O(n) | Space Complexity: O(k)

Optimal Approach:-
Use a fixed-size array with circular indexing using modulo %, so rear wraps from last index back to 0 instead of shifting elements.
Maintain only front, rear, and optionally size to track queue state efficiently.
Time Complexity: All operations O(1) | Space Complexity: O(k)

for insertion ope:- check if full → move rear → insert value → update metadata(increase size)
for deletion ope:- Check if empty → move front pointer → update metadata(decrease size)

class MyCircularQueue {

    // Array to store queue elements
    int[] arr;

    // Points to current front element
    int front;

    // Points to last inserted element
    int rear;

    // Current number of elements in queue
    int size;

    // Maximum capacity of queue
    int capacity;

    // Constructor
    public MyCircularQueue(int k) {

        // Create array of size k
        arr = new int[k];

        // Store maximum capacity
        capacity = k;

        // Queue initially empty
        size = 0;

        // Front starts from index 0
        front = 0;

        // Rear = -1 because no element inserted yet
        // First insertion moves rear to 0
        rear = -1;
    }

    // Insert element into circular queue
    public boolean enQueue(int value) {

        // Cannot insert if queue already full
        if (isFull()) {
            return false;
        }

        // Move rear circularly
        // Example:
        // if rear = 4 and capacity = 5
        // (4 + 1) % 5 = 0
        rear = (rear + 1) % capacity;

        // Insert value at rear position
        arr[rear] = value;

        // Increase current size
        size++;

        return true;
    }

    // Delete front element from queue
    public boolean deQueue() {

        // Cannot delete if queue empty
        if (isEmpty()) {
            return false;
        }

        // Move front circularly
        // We do NOT physically delete element
        // Front pointer decides valid queue start
        front = (front + 1) % capacity;

        // Decrease size
        size--;

        return true;
    }

    // Get front element
    public int Front() {

        // If queue empty return -1
        if (isEmpty()) {
            return -1;
        }

        // Front pointer always points
        // to current front element
        return arr[front];
    }

    // Get rear element
    public int Rear() {

        // If queue empty return -1
        if (isEmpty()) {
            return -1;
        }

        // Rear pointer always points
        // to last inserted element
        return arr[rear];
    }

    // Check whether queue is empty
    public boolean isEmpty() {

        // Queue empty when size becomes 0
        return size == 0;
    }

    // Check whether queue is full
    public boolean isFull() {

        // Queue full when size reaches capacity
        return size == capacity;
    }
}
