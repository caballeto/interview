package interviewbit.Trees;

import cracking_coding_interview.Graphs.TreeNode;

public class _identical_trees {
  public static int isSameTree(TreeNode a, TreeNode b) {
    if (a == null && b == null) return 1;
    if (a == null) return 0;
    if (b == null) return 0;
    return (a.val == b.val && isSameTree(a.left, b.left) == 1 && isSameTree(a.right, b.right) == 1) ? 1 : 0;
  }
}
