import java.util.*;

class Program {
  public static void invertBinaryTree(BinaryTree tree) {
    // Write your code here.
		inverseTreeRecursively(tree);
  }
	private static BinaryTree inverseTreeRecursively(BinaryTree node) {
		if (node == null) return null;
		BinaryTree left = inverseTreeRecursively(node.left);
		BinaryTree rightNode = inverseTreeRecursively(node.right);
		BinaryTree tempNode = rightNode;
		node.right = node.left;
		node.left = tempNode;
		return node;
	}

  static class BinaryTree {
    public int value;
    public BinaryTree left;
    public BinaryTree right;

    public BinaryTree(int value) {
      this.value = value;
    }
  }
}
//O(N)
//O(D) depth of tree
