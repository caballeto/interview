package leetcode.session1;

import cracking_coding_interview.Graphs.TreeNode;

public class _subtree_of_tree {
  public boolean isSubtree(TreeNode s, TreeNode t) {
    if (s == null) return false;
    return isSubtree(s.left, t) || isSubtree(s.right, t) || isEqual(s, t);
  }

  private static boolean isEqual(TreeNode a, TreeNode b) {
    if (a == null && b == null) return true;
    if (a == null || b == null) return false;
    return a.val == b.val && isEqual(a.left, b.left) && isEqual(a.right, b.right);
  }

  public static void main(String[] args) {

  }
}
