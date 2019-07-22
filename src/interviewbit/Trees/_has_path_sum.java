package interviewbit.Trees;

import cracking_coding_interview.Graphs.TreeNode;

public class _has_path_sum {
  public static int hasPathSum(TreeNode node, int sum) {
    if (node == null) return sum == 0 ? 1 : 0;
    boolean left = hasPathSum(node.left, sum - node.val) == 1;
    boolean right = hasPathSum(node.right, sum - node.val) == 1;
    if (node.left == null && node.right == null) return toInt(left || right);
    if (node.left == null) return toInt(right);
    if (node.right == null) return toInt(left);
    return toInt(left || right);
  }

  private static int toInt(boolean b) {
    return b ? 1 : 0;
  }

  public static void main(String[] args) {
    TreeNode node = new TreeNode(10000);
    node.left = new TreeNode(200);
    node.right = null;
    System.out.println(hasPathSum(node, 1000));
  }
}
