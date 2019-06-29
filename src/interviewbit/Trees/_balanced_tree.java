package interviewbit.Trees;

import cracking_coding_interview.Graphs.TreeNode;

public class _balanced_tree {
    static int balanced = 1;

    public static int isBalanced(TreeNode node) {
      balanced = 1;
      balance(node);
      return balanced;
    }

    private static int balance(TreeNode node) {
      if (node == null) return 0;
      int left = balance(node.left), right = balance(node.right);
      if (Math.abs(left - right) > 1) balanced = 0;
      return 1 + Math.max(left, right);
    }
}
