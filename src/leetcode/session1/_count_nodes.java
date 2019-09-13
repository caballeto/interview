package leetcode.session1;

import cracking_coding_interview.Graphs.TreeNode;

public class _count_nodes {
  // O(log(n) * log(n))
  public int countNodes(TreeNode root) {
    if (root == null) return 0;
    int leftHeight = height(0, root, true), rightHeight = height(0, root, false);
    if (leftHeight == rightHeight)
      return (1 << leftHeight) - 1;
    return 1 + countNodes(root.left) + countNodes(root.right);
  }

  private int height(int h, TreeNode node, boolean left) {
    while (node != null) {
      h++;
      node = left ? node.left : node.right;
    }
    return h;
  }

  static class TernaryNode {
    TernaryNode left;
    TernaryNode mid;
    TernaryNode right;
  }

  public int countTernary(TernaryNode node) {
    if (node == null) return 0;
    int leftH = leftHeight(node), rightH = rightHeight(node);
    if (leftH == rightH)
      return (int) (Math.pow(3, leftH) - 1);
    return 1 + countTernary(node.left) + countTernary(node.mid) + countTernary(node.right);
  }

  private static int leftHeight(TernaryNode node) {
    if (node == null) return 0;
    return 1 + leftHeight(node.left);
  }

  private static int rightHeight(TernaryNode node) {
    if (node == null) return 0;
    return 1 + rightHeight(node.right);
  }
}
