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
        TreeNode node = root;
        
        while (node != null) {
            
            if(node.left != null) {
                TreeNode rightmost = node.left;

                while(rightmost.right != null) {
                    rightmost = rightmost.right;
                }
                
                rightmost.right = node.right;
                node.right = node.left;
                node.left = null;
            }
            node = node.right;
        }
       
    }
   
}

// TC: O(N) since we will end up visiting nodes at most twice. for example visit 6 when it is left, then again visit 6 when node = node.right. The algorithm is slower
// than the recursive and stack solutions because it is `greedy` cos it makes decisions at each steps and carries further unlike recursive where the right for a current node
// is calculated until all of its left and right subtrees are calculated / visited
//SC: O(1) boom!
