using System;

namespace ValidateBinaryTree
{

    public class TreeNode
    {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int val = 0, TreeNode left = null, TreeNode right = null)
        {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    class Program
    {
        static void Main(string[] args)
        {
            TreeNode rootNode = new TreeNode(2, new TreeNode(1), new TreeNode(3));
            Console.WriteLine(IsValidBST(rootNode));
        }

        public static bool IsValidBST(TreeNode root)
        {
            return Validate(root, null, null);
        }

        public static bool Validate(TreeNode root, Nullable<int> max, Nullable<int> min)
        {
            if (root == null)
            {
                return true;
            }
            else if ((max != null && root.val >= max.Value) || (min != null && root.val <= min.Value))
            {
                return false;
            }
            else
            {
                if (min != null)
                {
                    Console.WriteLine(String.Format("Min is {0}", min.Value));
                }
                if (max != null)
                {
                    Console.WriteLine(String.Format("Max is {0}", max.Value));
                }
                return Validate(root.left, root.val, min) && Validate(root.right, max, root.val);
            }
        }
    }
}
