package interviewbit.Trees;

import cracking_coding_interview.Graphs.TreeNode;

public class _flatten_tree {
  public static TreeNode flatter(TreeNode node) {
    flattenTree(node);
    return node;
  }

  private static TreeNode flattenTree(TreeNode node) {
    if (node == null) return null;
    TreeNode left = flattenTree(node.left);
    TreeNode right = flattenTree(node.right);
    if (left == null && right == null) return node;
    else if (left == null) {
      return right;
    } else if (right == null) {
      node.right = node.left;
      node.left = null;
      return left;
    } else {
      left.right = node.right;
      node.right = node.left;
      node.left = null;
      return right;
    }
  }

  private static void printRightList(TreeNode node) {
    while (node != null) {
      System.out.println(node.val);
      node = node.right;
    }
  }

  public static void main(String[] args) {
    TreeNode node = new TreeNode(1);
    node.left = new TreeNode(2);
    node.right = new TreeNode(5);
    node.left.left = new TreeNode(3);
    node.left.right = new TreeNode(4);
    node.right.right = new TreeNode(6);
    printRightList(flatter(node));
  }
}
