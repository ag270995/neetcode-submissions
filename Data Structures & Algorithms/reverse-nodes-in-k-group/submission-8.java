/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        //this start value will be used to link the next Kth group after reverse operation
        ListNode start = head;
        ListNode end = head;
        //in order to stop at Kth node, iterate upto k - 1 times
        for (int i = 0; i < k - 1 && end != null; i++) {
            end = end.next;
        }
        //if head have less than K nodes then return as it is
        if (end == null) {
            return head;
        }

        //save the (k+1)th node as the start node for the next group
        ListNode nextStart = end.next;
        end.next = null; //unlink the end node of k group
        ListNode reverse = reverse(start); // noramal reverse
        start.next = reverseKGroup(nextStart, k); // repeat the process for the (k + 1)th node
        return reverse;
    }

    ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
