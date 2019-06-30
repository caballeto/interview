package interviewbit.Trees;

import cracking_coding_interview.Graphs.TreeNode;

public class _max_depth {
  public static int minDepth(TreeNode node) {
    if (node == null) return 0;
    if (node.left == null) return 1 + min(node.right);
    if (node.right == null) return 1 + min(node.left);
    return min(node);
  }

  private static int min(TreeNode node) {
    if (node == null) return 0;
    return 1 + Math.min(minDepth(node.left), minDepth(node.right));
  }
}
