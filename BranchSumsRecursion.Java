//O(n) time and space

import java.util.*;

class Program {
  // This is the class of the input root. Do not edit it.
  public static class BinaryTree {
    int value;
    BinaryTree left;
    BinaryTree right;

    BinaryTree(int value) {
      this.value = value;
      this.left = null;
      this.right = null;
    }
  }

  public static List<Integer> branchSums(BinaryTree root) {
    // Write your code here.
		List<Integer> finalList = new ArrayList<Integer>();
		Stack<BinaryTree> stack = new Stack<BinaryTree>();
		stack.push(root);
		int finalValue = 0;
		
		return callRecursively(root, finalList, finalValue);
  }
	private static List<Integer> callRecursively(BinaryTree currentNode, List<Integer> list, int finalValue) {
	
		if(currentNode.left == null && currentNode.right == null) {
			finalValue += currentNode.value;
			list.add(finalValue);
			finalValue =- currentNode.value;
		} 
		finalValue += currentNode.value;
				callRecursively(currentNode.left, list, finalValue);
				callRecursively(currentNode.right, list, finalValue);
			
		return list;
	}
}

/*
while(!stack.isEmpty()) {
			BinaryTree currentNode = stack.peek();
			finalValue += currentNode.value;
			
			if(currentNode.left != null) {
				stack.push(currentNode.left);
			}
			else if(currentNode.right != null) {
				stack.push(currentNode.right);
			}
			else {
				finalList.add(finalValue);
				finalValue =- currentNode.value;
				stack.remove(currentNode);
			}
		}
*/
