class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // Create dummy node
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Initialize pointers
        ListNode prev = dummy;
        ListNode curr = head;

        while (curr != null) {            
            // Check if it's a duplicate group and skip it
            if (curr.next != null && curr.val == curr.next.val) {
                
                //Skip all duplicates
                while (curr.next != null && curr.val == curr.next.val) {
                    curr = curr.next;
                }
                // Remove entire duplicate block
                prev.next = curr.next;    
            } else {
                // Move prev only if no duplicate
                prev = prev.next;
            }  
            // Always move curr
            curr = curr.next;
        }
        return dummy.next;
    }
}//o(n) time, o(1) space