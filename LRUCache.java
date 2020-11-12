class LRUCache {

   final Node head = new Node();
    final Node tail = new Node();
    public int cache_capacity;
    Map<Integer, Node> map;

    public LRUCache(int capacity) {
        this.cache_capacity = capacity;
        map = new HashMap(cache_capacity);
        head.next = tail;
        tail.prev = head;
    }

        public int get(int key) {
        int result = -1;
        Node node = map.get(key);
        if(node != null) {
            result = node.val;
            remove(node);
            add(node);
        }
        return result;
    }

    public void put(int key, int val) {
        Node node = map.get(key);
        if(node != null) {
            remove(node);
            node.val = val;
            add(node);  
        } else {
            if(map.size() == cache_capacity) {
                Node nodeToAdd = new Node(val);
                nodeToAdd.key = key;
                map.remove(tail.prev.key);
                remove(tail.prev);
            }
              Node nodeToAdd = new Node(val);
            nodeToAdd.key = key;
            map.put(nodeToAdd.key, nodeToAdd);
            add(nodeToAdd);
        }
      

    }

    public void remove(Node node) {
        Node node_next = node.next;
        Node node_prev = node.prev;

        
        node_next.prev = node_prev;
        node_prev.next = node_next;
    }
    public void add(Node node) {
       Node head_next = head.next;
        node.next = head_next;
        head_next.prev = node;
        head.next = node;
        node.prev = head;



    }

}

class Node {
    public int key;
    public int val;
    public Node prev;
    public Node next;
    public Node() {}
    public Node(int val) {
        this.val = val;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
