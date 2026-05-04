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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        ListNode dummy = lists[0];
        for (int i = 1; i < lists.length; i++) {
            dummy = merge(dummy, lists[i]);
        }
        return dummy;
        
    }

    public ListNode merge(ListNode first, ListNode second) {
        if (first == null) {
            return second;
        }
        if (second == null) {
            return first;
        }
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        while (first != null && second != null) {
            if (first.val <= second.val) {
                curr.next = first;
                first = first.next;
            } else {
                curr.next = second;
                second = second.next;
            }
            curr = curr.next;
        }


        if (first != null) {
            curr.next = first;
            curr = curr.next;
        }

        if (second != null) {
            curr.next = second;
            curr = curr.next;
        }

        return dummy.next;

    }
}
