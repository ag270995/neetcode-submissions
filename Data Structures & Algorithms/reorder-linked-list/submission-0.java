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
    
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        // 1. Find middle
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. Reverse second half
        ListNode second = reverse(slow.next);
        slow.next = null; // split first half and second half

        // 3. Merge using dummy pointer
        ListNode first = head;
        ListNode dummy = new ListNode();
        ListNode curr = dummy;

        while (first != null || second != null) {
            if (first != null) {
                curr.next = first;
                curr = curr.next;
                first = first.next;
            }

            if (second != null) {
                curr.next = second;
                curr = curr.next;
                second = second.next;
            }
        }

        curr.next = null;
    }

    private ListNode reverse(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }


}
