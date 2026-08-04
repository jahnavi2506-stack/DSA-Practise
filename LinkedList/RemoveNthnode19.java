Pattern Recognition:- Fast & Slow Pointer (Floyd’s Cycle Algorithm)

Brute Force: First traverse the list to find its length L.
Calculate the target position from the beginning: L - n + 1, then traverse again to delete it.
Time: O(N), Space: O(1) — two traversals, but still linear.

Optimal Approach: Create a dummy node before head, then initialize fast and slow at dummy.
Move fast n + 1 steps to create a gap; then move both until fast == null.
slow reaches the node before the target, so delete it using slow.next = slow.next.next. Time: O(N), Space: O(1)

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
       ListNode dummy = new ListNode(0);
       dummy.next = head;

       ListNode fast = dummy;
       ListNode slow = dummy;

       for(int i = 0; i <= n; i++) {
        fast = fast.next;
       }
       
       while(fast != null) {
          fast = fast.next;
          slow = slow.next;
       }
        slow.next = slow.next.next;
        return dummy.next; 
    }
}
