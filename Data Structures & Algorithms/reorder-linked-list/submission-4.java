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


 // Solving this is a - trick, arrange linkedlist as :-
 //0 -> n-1 -> 1 -> n-2-> 2 -> n - 3 
 // example : 0, 1, 2, 3, 4, 5, 6
//step 1 -> find the mid of linked list to get the second half : 3->4->5->6
//step 2 -> reverse the second half : 6->5->4->3
//first half is : 0->1->2 (after doing slow.next = null;)
// then merge them this will result in same order as the result 0 -> n-1 -> 1 -> n-2-> 2 -> n - 3 


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
        slow.next = null;//de-linking first half
        ListNode first = head;

        while (first != null && second != null) {
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
