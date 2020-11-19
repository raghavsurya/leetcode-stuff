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
    public void flatten(TreeNode root) {
        TreeNode currRoot = root;
        currRoot = flattenRecursively(root);
       
    }
    private TreeNode flattenRecursively(TreeNode node) {
        if(node == null) return null;
        if(!isLeafNode(node)) {
            TreeNode temp = node.right;
            TreeNode flattenedLeft = flattenRecursively(node.left);
            TreeNode flattenedRight = flattenRecursively(node.right);
            if(flattenedLeft != null) {
               flattenedLeft.right = node.right;
                 node.right = node.left;
                node.left = null;
            }
           
            // System.out.println(flattenedLeft.val);
            // System.out.println(flattenedLeft.right.val);
            
        return flattenedRight == null ? flattenedLeft : flattenedRight;
        } else {
            return node;
        }
    }
    private Boolean isLeafNode(TreeNode node) {
        return node.left == null && node.right == null;
    }
}

// TC: O(N) since we visit every node exactly once
//SC: O(N) since we might visit N nodes worst case if tree is left skewed. 
