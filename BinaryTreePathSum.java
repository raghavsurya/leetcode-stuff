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
     boolean isTrue = false;
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        if(root.left == null && root.right == null) {
             return root.val == sum;
        }
        isTrue = preorder(root, sum, 0, 0);
       return isTrue;
    }
    private boolean preorder(TreeNode root, int sum, int add, int depth) {
        if (root == null) {
            return false;
        }
        add += root.val;
        if(root.left == null && root.right == null) {
            if (add == sum && depth > 0) {
                return true;
            }
        }
        
       isTrue = preorder(root.left, sum, add, depth+1);
        if(isTrue) return true;
        isTrue = preorder(root.right, sum, add, depth+1);
        if(isTrue) return true;
        return false;
    }
}
