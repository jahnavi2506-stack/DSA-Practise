Pattern recognition:- Fast & Slow Pointer (Floyd’s Cycle Detection Algorithm)

Brute Force Approach (HashSet): Traverse the linked list and store every visited node in a HashSet.
Before visiting a node, check if it already exists in the HashSet.
If it exists, a cycle is present; otherwise, continue until reaching null. Time Complexity: O(n), Space Complexity: O(n)

Optimal Approach (Floyd's Cycle Detection / Tortoise and Hare Algorithm): slow moves one step, while fast moves two steps.
If the linked list contains a cycle, the two pointers will eventually meet.
If fast or fast.next becomes null, the linked list has no cycle. Time: O(n), Space: O(1)

public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) { // we must check fast and fast.next before accessing fast.next.next to avoid NullPointerException
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) return true;// both points to same node, means there is a cycle
        }
        return false;
    }
}