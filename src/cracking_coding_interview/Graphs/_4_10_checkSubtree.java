package cracking_coding_interview.Graphs;

public class _4_10_checkSubtree {
  public boolean hasSubtree(TreeNode root1, TreeNode root2) {
    if (root1 == root2) return true;
    if (root1 == null) return false;
    return hasSubtree(root1.left, root2) || hasSubtree(root1.right, root2);
  }
}
