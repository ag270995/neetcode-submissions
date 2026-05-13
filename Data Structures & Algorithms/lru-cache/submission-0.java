class LRUCache {

    public class Node {
        int key;
        int val;
        Node next;
        Node prev;

        public Node() {}
        
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    Map<Integer, Node> map = new HashMap<>();
    Node start = new Node();
    Node last = new Node();
    int capacity;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.start.next = last;
        this.start.prev = null;
        this.last.prev = start;
        this.last.next = null;    
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        remove(node);
        addAtFirst(node);
        return node.val;
    }
    
    public void put(int key, int val) {
        Node node = new Node(key, val);
        
        if (map.containsKey(key)) {
           Node prev = map.get(key);
           remove(prev);
           addAtFirst(node);
           map.put(key, node);
           return;
        }
        
        if (map.size() >= capacity) {
            removeLast();
        }
        map.put(key, node);
        addAtFirst(node);
       
    }

    private void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
        node.next = null;
        node.prev = null;
    }


    private void removeLast() {

        Node nodeToBeRemoved = last.prev;
        map.remove(nodeToBeRemoved.key);
        
        Node prev = nodeToBeRemoved.prev;
        prev.next = last;
        last.prev = prev;
        nodeToBeRemoved.next = null;
        nodeToBeRemoved.prev = null;
    }

    private void addAtFirst(Node node) {
        Node first = start.next;
        node.next = first;
        first.prev = node;
        start.next = node;
        node.prev = start;
    }
}
