Pattern Recognition:- Circular Deque using Array

Brute Force
Use a normal array and physically shift elements during insertFront and deleteFront.
Insertion/deletion from front takes O(n) due to shifting.
Time: O(n) worst case, Space: O(k).

Optimal Approach
Use circular array with front and rear pointers, and move pointers using modulo instead of shifting elements.
All operations become constant time because only indices move logically.
Time: O(1) for all operations, Space: O(k).

class MyCircularDeque {

    // Array to store deque elements
    int[] arr;

    // Points to current front element
    int front;

    // Points to current rear element
    int rear;

    // Current number of elements present
    int size;

    // Maximum capacity of deque
    int capacity;

    // Constructor
    public MyCircularDeque(int k) {

        // Create array of size k
        arr = new int[k];

        // Maximum size deque can hold
        capacity = k;

        // Initially deque is empty
        size = 0;

        // Front starts from 0
        front = 0;

        // Rear = -1 means no valid rear yet
        rear = -1;
    }

    // Insert element at FRONT side
    public boolean insertFront(int value) {

        // Cannot insert if deque already full
        if (isFull()) {
            return false;
        }

        // First element insertion
        // Both front and rear should point same index
        if (isEmpty()) {

            front = 0;
            rear = 0;
        }

        // Move front LEFT circularly
        else {

            // Example:
            // front = 0
            // capacity = 5
            // (0 - 1 + 5) % 5 = 4
            front = (front - 1 + capacity) % capacity;
        }

        // Insert value at front position
        arr[front] = value;

        // Increase current size
        size++;

        return true;
    }

    // Insert element at REAR side
    public boolean insertLast(int value) {

        // Cannot insert if deque already full
        if (isFull()) {
            return false;
        }

        // First element insertion
        if (isEmpty()) {

            front = 0;
            rear = 0;
        }

        // Move rear RIGHT circularly
        else {

            // Example:
            // rear = 4
            // capacity = 5
            // (4 + 1) % 5 = 0
            rear = (rear + 1) % capacity;
        }

        // Insert value at rear position
        arr[rear] = value;

        // Increase current size
        size++;

        return true;
    }

    // Delete element from FRONT side
    public boolean deleteFront() {

        // Cannot delete if deque empty
        if (isEmpty()) {
            return false;
        }

        // If only one element present
        // Deque becomes empty after deletion
        if (size == 1) {

            // Restore initial empty state
            front = 0;
            rear = -1;
        }

        // Move front RIGHT circularly
        else {

            front = (front + 1) % capacity;
        }

        // Decrease size
        size--;

        return true;
    }

    // Delete element from REAR side
    public boolean deleteLast() {

        // Cannot delete if deque empty
        if (isEmpty()) {
            return false;
        }

        // If only one element present
        // Deque becomes empty
        if (size == 1) {

            // Restore initial empty state
            front = 0;
            rear = -1;
        }

        // Move rear LEFT circularly
        else {

            rear = (rear - 1 + capacity) % capacity;
        }

        // Decrease size
        size--;

        return true;
    }

    // Return front element
    public int getFront() {

        // No front element exists
        if (isEmpty()) {
            return -1;
        }

        return arr[front];
    }

    // Return rear element
    public int getRear() {

        // No rear element exists
        if (isEmpty()) {
            return -1;
        }

        return arr[rear];
    }

    // Check whether deque is empty
    public boolean isEmpty() {

        return size == 0;
    }

    // Check whether deque is full
    public boolean isFull() {

        return size == capacity;
    }
}