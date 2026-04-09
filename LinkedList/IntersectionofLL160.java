This is a linked list intersection problem where we need to compare node references, not values.
A brute force approach would take O(m × n), so we avoid it.
A better approach is aligning the lists using their lengths.
But the most optimal solution is using two pointers that switch heads after reaching the end.
This ensures both traverse equal distance and meet at the intersection node or null.
The time complexity is O(m + n) and space is O(1)

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
       ListNode ptr1 = headA;
       ListNode ptr2 = headB;

       while(ptr1 != ptr2) {
        ptr1 = (ptr1 == null) ? headB : ptr1.next;
        ptr2 = (ptr2 == null) ? headA : ptr2.next;
       }
       return ptr1;
    }   
}//o(m + n) time, o(1) space - we traverse both lists at most twice and use only a few pointers
