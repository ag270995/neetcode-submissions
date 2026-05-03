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
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode startOfSecond = slow.next;
        ListNode second = reverse(startOfSecond);
        slow.next = null;
        ListNode first = head;


        while (second != null) {
            ListNode next1 = first.next;
            ListNode next2 = second.next;

            first.next = second;
            second.next = next1;

            first = next1;
            second = next2;

        }

        
    }

    ListNode reverse(ListNode head) {
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
