/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

dummy node
node.next = head;
curr = head;

curr != null




*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node curr = head;
        while (curr != null) {
            Node copy = new Node(curr.val);
            map.put(curr, copy);
            curr = curr.next;            
        }
        
        curr = head;

        Node dummy = new Node(-1);
        Node newCurr = dummy;

        while (curr != null) {
            Node node = map.get(curr);
            
            Node next = curr.next != null ? map.get(curr.next) : null;
            node.next = next;
            
            Node random = curr.random != null ? map.get(curr.random) : null;
            node.random = random;

            newCurr.next = node;
            newCurr = newCurr.next;
            curr = curr.next;

        }

        return dummy.next;
    }
}
