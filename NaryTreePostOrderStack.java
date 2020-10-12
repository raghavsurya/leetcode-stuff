/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> postorder(Node root) {
        LinkedList<Node> stack = new LinkedList();
        LinkedList<Integer> outpt = new LinkedList();
        if(root == null) {
            return outpt;
        }
        
        stack.push(root);
        
        while(!stack.isEmpty()) {
            Node rootNode = stack.pollLast();
            outpt.addFirst(rootNode.val);
            for(Node child: rootNode.children) {
                stack.add(child);
            }
            
        }
        return outpt;
    }
}
