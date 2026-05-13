/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 curr -> curr.next


 */

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode res = null; 
        ListNode start = head;
        ListNode end = head;
        ListNode reverseEnd = null;
        while (end != null) {

            for (int i = 1; i < k && end != null; i++) {
                end = end.next;
            } 
            
            ListNode newStart = end != null ? end.next : null;
            if (end != null)  {
                end.next = null;
            }
            ListNode reverse = start;
            if (end != null) {
                reverse = reverse(start);
            }
            
            if (res == null) {
                res = reverse;
            }
            // print(reverse);
            if (reverseEnd != null) {
                reverseEnd.next = reverse;
            }
            reverseEnd = start;
            start = newStart;
            end = newStart;

        }
        
        return res;
        
    }


    private ListNode reverse(ListNode head) {
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

    private void print(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + "->");
            curr = curr.next;
        }
        System.out.print("null");
        System.out.println();
    }
}
