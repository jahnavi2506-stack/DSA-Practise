“Why not fast.next.next != null?”
“Because we must first ensure fast and fast.next are not null before accessing fast.next.next, otherwise it can cause NullPointerException.”

class Solution {
    public ListNode middleNode(ListNode head) {
      ListNode slow = head;
      ListNode fast = head;  

      while(fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
      }
      return slow; //at middle, not fast because it is at last
    }
} 
// Time complexity: O(n) - we traverse the list at most once
// Space complexity: O(1) - we use only a few pointers, no extra space