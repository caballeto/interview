package cracking_coding_interview.Graphs;

public class _4_5_validateBST {
  // val < x on the left
  // val > x on the right
  public boolean isBST(TreeNode node) {
    return isBST(node, Long.MIN_VALUE, Long.MAX_VALUE);
  }

  private boolean isBST(TreeNode node, long min, long max) {
    if (node == null) return true;
    return node.val < max && node.val > min && isBST(node.left, min, node.val) && isBST(node.right, node.val, max);
   }
}
