using System;
using System.Collections.Generic;

public class Program {
	public static int NodeDepths(BinaryTree root) {
		return callRecursively(root, 0);
	}

	public static int callRecursively(BinaryTree root, int depth)
	{
		if(root == null) return 0;
		return depth + callRecursively(root.left, depth + 1) + callRecursively(root.right, depth + 1);
	}
	
	public class BinaryTree {
		public int value;
		public BinaryTree left;
		public BinaryTree right;

		public BinaryTree(int value) {
			this.value = value;
			left = null;
			right = null;
		}
	}
}
