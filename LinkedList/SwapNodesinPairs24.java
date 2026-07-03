Pattern Recognition: pointer Manipulation [swap + skip]

Brute Force: Store all linked list values into an array.
Swap adjacent values inside the array and create a new linked list from the swapped values.
Simple but it violates the constraint because it modifies/recreates values instead of swapping existing nodes. Time: O(n),Space: O(n)

Optimal: Use pointer manipulation to swap every adjacent pair without changing node values.
Maintain a dummy node and reconnect prev, first, second, and next after every swap.
Move prev to the end of the swapped pair and repeat until fewer than two nodes remain. Time: O(n),Space: O(1)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */

class Solution {
    public ListNode swapPairs(ListNode head) {

        // Dummy node helps handle edge cases (like swapping the first pair)
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // prev always points to the node before the pair to be swapped
        ListNode prev = dummy;

        // Continue while there are at least two nodes to swap
        while (prev.next != null && prev.next.next != null) {

            // First node of the pair
            ListNode first = prev.next;

            // Second node of the pair
            ListNode second = first.next;

            // Save the node after the pair
            ListNode next = second.next;

            // -----------------------------
            // Swap the two nodes
            // -----------------------------

            // Step 1: First node points to the remaining list
            first.next = next;

            // Step 2: Second node points to first
            second.next = first;

            // Step 3: Previous node connects to second
            prev.next = second;

            // Move prev to the end of the swapped pair
            prev = first;
        }

        // Return the new head
        return dummy.next;
    }
}