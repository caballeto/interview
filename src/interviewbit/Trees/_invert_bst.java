package interviewbit.Trees;

import cracking_coding_interview.Graphs.TreeNode;

public class _invert_bst {
  public static TreeNode invertTree(TreeNode node) {
    if (node == null) return null;
    TreeNode n = node.left;
    node.left = node.right;
    node.right = n;
    invertTree(node.left);
    invertTree(node.right);
    return node;
  }
}
