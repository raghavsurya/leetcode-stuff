
//Average Time Complexity: O(log n) because we are eliminating portions of tree depending on target less than or greater than left and right nodes
//Average Space complexity O(log n) because of the stack frames as a result of recursion

//Worst Time Complexity: O(n) in case we visit all the nodes. 
//Worst space complexity: O(d) where d is the depth of the tree, again if we end up visiting all the nodes)
import java.util.*;

class Program {
  public static int findClosestValueInBst(BST tree, int target) {
    // Write your code here.
		if(tree == null) return 0;
		int finalAnswer = tree.value;
		BST root = tree;
		return findRecursively(tree, target, tree.value);
  }
	
	private static int findRecursively(BST currentNode, int target, int finalAnswer) {
		if(currentNode == null) return finalAnswer;
		if(Math.abs(target - finalAnswer) > Math.abs(target - currentNode.value)) {
				finalAnswer = currentNode.value;
			}
		
		if(target < currentNode.value) {
			return findRecursively(currentNode.left, target, finalAnswer);
		}
		else if(target > currentNode.value) {
			return findRecursively(currentNode.right, target, finalAnswer);
		} else {
			return finalAnswer;
		}
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
