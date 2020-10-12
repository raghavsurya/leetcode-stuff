/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
       LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        LinkedList<Integer> list = new LinkedList();
        
        if(root == null) {
            return list;
        }
        
        stack.add(root);
        
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(0, node.val);
            if(node.left != null) {
                stack.push(node.left);
            }
            if(node.right != null) {
                stack.push(node.right);
            }
        }
        return list;
    }
}
