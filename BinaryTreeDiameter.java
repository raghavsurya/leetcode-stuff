import java.util.*;

class Program {
  // This is an input class. Do not edit.
  static class BinaryTree {
    public int value;
    public BinaryTree left = null;
    public BinaryTree right = null;
		public int edgeCount;

    public BinaryTree(int value) {
      this.value = value;
    }
  }
	
	static class TreeInfo {
		public int diameter;
		public int height;
		
		public TreeInfo(int diameter, int height) {
			this.diameter = diameter;
			this.height = height;
		}
	}

  public int binaryTreeDiameter(BinaryTree tree) {
    // Write your code here.
		TreeInfo info = getTreeInfo(tree);
		return info.diameter;
  }
	
	private TreeInfo getTreeInfo(BinaryTree node) {
		if(node == null) {
			return new TreeInfo(0,0);
		}
		TreeInfo leftTreeInfo = getTreeInfo(node.left);
		TreeInfo rightTreeInfo = getTreeInfo(node.right);
		int longestPathFromRoot = leftTreeInfo.height + rightTreeInfo.height;
		int maxDiameterSoFar = leftTreeInfo.diameter + rightTreeInfo.diameter;
		int currentDiameter = Math.max(longestPathFromRoot, maxDiameterSoFar);
		int currentHeight = 1 + Math.max(leftTreeInfo.height, rightTreeInfo.height);
		
		return new TreeInfo(currentDiameter, currentHeight);
	}
}
//O(N)
//O(N) - N : Number of nodes in the graph / tree
