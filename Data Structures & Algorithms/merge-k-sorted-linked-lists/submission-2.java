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
        return mergeKLists(lists, 0, lists.length - 1);
    }


    private ListNode mergeKLists(ListNode[] lists, int l, int r) {
        if (l > r) {
            return null;
        }
        if (l == r) {
            return lists[l];
        }
        int mid = l + (r - l)/2;
        ListNode left = mergeKLists(lists, l, mid);
        ListNode right = mergeKLists(lists, mid + 1, r);

        return merge(left, right);
            
    }

    private ListNode merge(ListNode left, ListNode right) {
        
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        ListNode currLeft = left;
        ListNode currRight = right;

        while (currLeft != null && currRight != null) {
            if (currLeft.val <= currRight.val) {
                curr.next = currLeft;
                currLeft = currLeft.next;
            } else {
                curr.next = currRight;
                currRight = currRight.next;
            }
            curr = curr.next; 
        }
        if (currLeft != null) {
            curr.next = currLeft; 
        }
        if (currRight != null) {
            curr.next = currRight; 
        }
        return dummy.next;

    }


}
