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
    public List<Integer> inorderTraversal(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        
        if(root == null) {
            return list;
        }
        inorderTraversal(root, list);
        return list;
    }
    private void inorderTraversal(TreeNode root,  LinkedList<Integer> list) {
        System.out.println(list);
        if(root != null) {
            if(root.left != null) {
                inorderTraversal(root.left, list);
            }
            list.add(root.val);
            if(root.right != null) {
             inorderTraversal(root.right, list);
            }
            
        }
       // step 1. check if left is there. if yes add it to list
        // step 2. if left not there then mopve to root and add it
        // step 3. if right is there repeat 1 & 2
       
        else {
            return;
        }
    }
}
