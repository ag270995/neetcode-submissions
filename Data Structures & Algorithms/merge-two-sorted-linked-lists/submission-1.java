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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode res = new ListNode();
        ListNode curr = res;

        ListNode curr1 = list1;
        ListNode curr2 = list2;
        while (curr1 != null && curr2 != null) {
            if (curr1.val <= curr2.val) {
                ListNode next1 = curr1.next;
                curr.next = curr1;
                curr1 = next1;
            } else {
                ListNode next2 = curr2.next;
                curr.next = curr2;
                curr2 = next2;
            }
            curr = curr.next;
        }
        if (curr1 != null) {
            curr.next = curr1;
        }
        if (curr2 != null) {    
            curr.next = curr2;
        }
        return res.next;
    }
}