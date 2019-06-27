package interviewbit.Trees;

import java.util.ArrayList;

public class _preorder_traversal {
  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
      val = x;
      left = null;
      right = null;
    }
  }

  public static ArrayList<Integer> preorderTraversal(TreeNode root) {
    TreeNode node = root;
    ArrayList<TreeNode> stack = new ArrayList<>();
    ArrayList<Integer> result = new ArrayList<>();
    while (node != null || !stack.isEmpty()) {
      while (node != null) {
        stack.add(node);
        result.add(node.val);
        node = node.left;
      }

      node = stack.remove(stack.size() - 1).right;
    }

    return result;
  }
}
