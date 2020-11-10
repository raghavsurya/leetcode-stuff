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
*/

class Solution {
    public Node copyRandomList(Node head) {
        
        Map<Node, Node> map = new  HashMap<Node, Node>();
        Node curr = head;
        Node deepCopy = new Node(head.val);
        map.put(head, deepCopy);
        int count = 0;
        
        while(curr != null) {
            if(curr.random != null) {
                if(!map.containsKey(curr.random)) {
                    map.put(curr.random, new Node(curr.random.val));
                }
                 deepCopy.random = map.get(curr.random);
            }
             if(curr.next != null) {
                if(!map.containsKey(curr.next)) {
                    map.put(curr.next, new Node(curr.next.val));
                }
            deepCopy.next = map.get(curr.next);
            }
            deepCopy = deepCopy.next;
            curr = curr.next;
        }
       
        return map.get(head);
    }
}

//O(N)
//O(N)
