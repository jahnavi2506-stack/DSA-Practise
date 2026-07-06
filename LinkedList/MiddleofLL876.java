“Why not fast.next.next != null?”
“Because we must first ensure fast and fast.next are not null before accessing fast.next.next, otherwise it can cause NullPointerException.”

Pattern recognition:- Fast & Slow Pointer (Tortoise and Hare)


Brute Force: Traverse the linked list once to count the total number of nodes.
Traverse again until reaching the count / 2th node. Return that node as the middle.
Time Complexity: O(N) + O(N) = O(N), Space Complexity: O(1)

Optimal Approach: Use two pointers: slow moves 1 step, fast moves 2 steps.
When fast reaches the end, slow will automatically be at the middle. Only one traversal is needed.
Time Complexity: O(N),Space Complexity: O(1)

class Solution {
    public ListNode middleNode(ListNode head) {

        // Slow pointer moves one step at a time.
        // It will eventually reach the middle node.
        ListNode slow = head;

        // Fast pointer moves two steps at a time.
        // When it reaches the end, slow will be at the middle.
        ListNode fast = head;

        // Continue until fast reaches the end of the list.
        while (fast != null && fast.next != null) {

            // Move slow by one node.
            slow = slow.next;

            // Move fast by two nodes.
            fast = fast.next.next;
        }

        // At this point:
        // - For odd-length lists, slow points to the exact middle.
        // - For even-length lists, slow points to the second middle
        //   (as required by the problem).
        return slow;
    }
}