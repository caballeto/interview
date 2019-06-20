package cracking_coding_interview.Graphs;

public class _4_4_checkBalanced {
  public int height(TreeNode node) {
    if (node == null) return 0;
    return 1 + Math.max(height(node.left), height(node.right));
  }

  // diff between heights is <= 1
  // Use node.height attribute here to cache node heights
  public boolean isBalanced(TreeNode node) {
    if (node == null) return true;
    return Math.abs(height(node.right) - height(node.left)) <= 1 && isBalanced(node.left) && isBalanced(node.right);
  }
}
