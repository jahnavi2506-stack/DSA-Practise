Pattern Recognition: pointer Manipulation [skip + odd/even]

Brute Force: Traverse the list and store odd-indexed and even-indexed node values separately in arrays.
Create a new linked list by appending odd values followed by even values.
Uses extra memory, so it does not satisfy the O(1) space requirement. Time: O(n) ,Space: O(n)

Optimal: Maintain two pointers: odd and even, along with evenHead to remember the start of the even list.
Skip alternate nodes by updating odd.next and even.next until the end of the list.
Finally, connect the last odd node to evenHead. Time: O(n), Space: O(1)

class Solution {
    public ListNode oddEvenList(ListNode head) {

        // If the list is empty or has only one node, no rearrangement is needed.
        if (head == null || head.next == null) {
            return head;
        }

        // odd points to the first (odd-indexed) node
        ListNode odd = head;

        // even points to the second (even-indexed) node
        ListNode even = head.next;

        // Save the head of the even list
        // We'll attach it after the odd list at the end.
        ListNode evenHead = even;

        // Continue while there are more odd-even pairs available
        while (even != null && even.next != null) {

            // Connect current odd node to the next odd node
            odd.next = even.next;

            // Move odd pointer forward
            odd = odd.next;

            // Connect current even node to the next even node
            even.next = odd.next;

            // Move even pointer forward
            even = even.next;
        }

        // Attach the even list after the last odd node
        odd.next = evenHead;

        // Head remains unchanged
        return head;
    }
}