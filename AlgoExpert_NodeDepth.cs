using System;
using System.Collections.Generic;

public class Program {
	public static int NodeDepths(BinaryTree root) {
		if(root== null) return 0;
		Stack<Level> stack = new Stack<Level>();
		stack.Push(new Level(root, 0));
		int ans = 0;
		
		while(stack.Count > 0) {
				
			Level currroot = stack.Pop();
			BinaryTree node = currroot.root;
			if(node == null) continue;
			ans += currroot.depth;
		 
			if(node.left != null) {
				stack.Push(new Level(node.left, currroot.depth + 1));
			}
			if(node.right != null) {
				stack.Push(new Level(node.right, currroot.depth + 1));
			}
			
		}
		return ans;
	}

	public class Level {
		public BinaryTree root;
		public int depth;
		
		public Level(BinaryTree root, int depth)
		{
			this.root = root;
			this.depth = depth;
		}
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
