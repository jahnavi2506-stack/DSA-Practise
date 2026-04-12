//“Digit-by-digit processing with carry”

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
     ListNode dummy = new ListNode(0);
     ListNode current = dummy;

    //initalize carry
     int carry = 0;

    //continue loop as lomg as nodes exist
    while(l1 != null || l2 != null || carry != 0) {
        int x = (l1 != null) ? l1.val : 0;
        int y = (l2 != null) ? l2.val : 0;
        int sum = x + y + carry;

        int digit = sum % 10;
         carry = sum / 10;

        current.next = new ListNode(digit);
        current = current.next;
         if(l1 != null) l1 = l1.next;
         if(l2 != null) l2 = l2.next;
    } 
    return dummy.next;
    }
}//o(max(m,n)) time complexity and o(max(m,n)) space complexity 
// because we are creating a new linked list to store the result, where m and n are the lengths of the input linked lists l1 and l2 respectively.