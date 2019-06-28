package interviewbit.Trees;

import cracking_coding_interview.Graphs.TreeNode;

public class _is_symmetric {
  public static int isSymmetric(TreeNode node) {
    if (node == null || (node.left == null && node.right == null)) return 1;
    return isSymmetric(node.left, node.right) ? 1 : 0;
  }

  private static boolean isSymmetric(TreeNode a, TreeNode b) {
    if (a == null && b == null) return true;
    if (a == null) return false;
    if (b == null) return false;
    return a.val == b.val && isSymmetric(a.left, b.right) && isSymmetric(a.right, b.left);
  }
}
