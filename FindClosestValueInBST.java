import java.util.*;

class Program {
  public static int findClosestValueInBst(BST tree, int target) {
    // Write your code here.
		if(tree == null) return 0;
		int finalAnswer = tree.value;
		BST root = tree;
		while(root != null) {
			if(Math.abs(target - finalAnswer) > Math.abs(target - root.value)) {
				finalAnswer = root.value;
			}
			if(target < root.value) {
				root = root.left;
			}
			else if(target > root.value) {
				root = root.right;
			}
			else {
				break;
			}
		}
			
    return finalAnswer;
  }

  static class BST {
    public int value;
    public BST left;
    public BST right;

    public BST(int value) {
      this.value = value;
    }
  }
}
