package cracking_coding_interview.Graphs;

public class _4_6_successor {
  private class TreeNode {
    private int val;
    private TreeNode left, right, parent;
    private TreeNode(int x) { val = x; }
  }

  public TreeNode successor(TreeNode node) {
    if (node == null) return null;
    TreeNode succ = getSuccessor(node.right);
    if (succ != null) return succ;
    succ = node.parent;
    while (succ != null) {
      if (node.val < succ.val) return succ;
      succ = succ.parent;
    }

    return null;
  }

  public TreeNode getSuccessor(TreeNode node) {
    if (node == null) return null;
    if (node.left == null) return node;
    return getSuccessor(node.left);
  }
}
