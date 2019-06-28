package interviewbit.Trees;

import cracking_coding_interview.Graphs.TreeNode;

public class _least_common_ancestor {
  static boolean found = false;

  public int lca(TreeNode node, int a, int b) {
    found = false;
    node = findLCA(node, a, b);
    if (node == null || !found) return -1;
    return node.val;
  }

  public TreeNode findLCA(TreeNode node, int a, int b) {
    if (node == null) return null;
    TreeNode left = findLCA(node.left, a, b), right = findLCA(node.right, a, b);

    if ((node.val == a || node.val == b) && (left != null || right != null)) {
      found = true;
      return node;
    }
    if (left != null && right != null) {
      found = true;
      return node;
    }
    if (node.val == a && node.val == b) {
      found = true;
      return node;
    }
    if (node.val == a || node.val == b) {
      return node;
    }
    return left != null ? left : right;
  }
}
