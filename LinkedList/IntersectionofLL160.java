This is a linked list intersection problem where we need to compare node references, not values.
A brute force approach would take O(m × n), so we avoid it.
A better approach is aligning the lists using their lengths.
But the most optimal solution is using two pointers that switch heads after reaching the end.
This ensures both traverse equal distance and meet at the intersection node or null.
The time complexity is O(m + n) and space is O(1)

Two Pointer (Pointer Switching Technique)

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
The condition ptr1 != ptr2 compares node references, not values.
So it only stops when both pointers point to the same memory location, which guarantees it's the true intersection node.

The arrays are only representations. The actual linked lists are constructed such that intersecting nodes share the same memory reference. 
My algorithm detects this by comparing node references using two pointers.