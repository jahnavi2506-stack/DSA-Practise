public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) { //we must check fast and fast.next before accessing fast.next.next to avoid NullPointerException
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) return true;//both points to same node, means there is a cycle
        }
        return false;
    }
}