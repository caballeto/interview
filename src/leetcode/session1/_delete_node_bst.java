package leetcode.session1;

import cracking_coding_interview.Graphs.TreeNode;

public class _delete_node_bst {
  public static TreeNode deleteNode(TreeNode root, int key) {
    if (root == null) return null;
    if (root.val < key) {
      root.left = deleteNode(root.left, key);
    } else if (root.val > key) {
      root.right = deleteNode(root.right, key);
    } else {
      if      (root.left == null)  return root.right;
      else if (root.right == null) return root.left;
      else {
        TreeNode min = getMin(root.right);
        root.val = min.val;
        root.right = deleteNode(root.right, root.val);
        return min;
      }
    }

    return root;
  }

  private static TreeNode getMin(TreeNode node) {
    while (node.left != null)
      node = node.left;
    return node;
  }
}
