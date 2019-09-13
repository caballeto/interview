package leetcode.session1;

import cracking_coding_interview.Graphs.TreeNode;

public class _LCA {
  public static TreeNode lowestCommonAncestor(TreeNode node, TreeNode p, TreeNode q) {
    if (node == null) return null;
    if (node == p || node == q) return node;
    TreeNode left = lowestCommonAncestor(node.left, p, q), right = lowestCommonAncestor(node.right, p, q);
    if (left != null && right != null) return node;
    return left == null ? right : left;
  }
}
