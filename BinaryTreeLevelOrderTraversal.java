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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> outputArray = new LinkedList();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        
        if(root == null) {
            return outputArray;
        }
        queue.add(root);
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> currentLevels = new LinkedList();
            
            for(int i = 0; i<size; i++) {
                TreeNode node = queue.remove();
                currentLevels.add(node.val);
                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
            }
            outputArray.add(currentLevels);
        }
        return outputArray;
    }
}
