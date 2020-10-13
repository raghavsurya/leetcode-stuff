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
    
     int answer = 0;
    public int maxDepth(TreeNode root) {
       
        if(root == null) {
           return 0; 
        }
        
        return maxD_recursive(root, 1);
    }
    private int maxD_recursive(TreeNode root, int depth) {
        if(root == null) {
            return answer;
        }
        if (root.left == null && root.right == null) {
            answer = Math.max(answer, depth);
        }
        
        maxD_recursive(root.left, depth + 1);
        maxD_recursive(root.right, depth + 1);
        return answer;
    }
   
}
