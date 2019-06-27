package interviewbit.Trees;

import java.util.ArrayList;

public class _postorder_traversal {
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

  public static ArrayList<Integer> postorderTraversal(TreeNode root) {
    TreeNode node = root;
    ArrayList<TreeNode> stack = new ArrayList<>();
    ArrayList<Integer> result = new ArrayList<>();
    while (node != null || !stack.isEmpty()) {
      while (node != null) {
        stack.add(node);
        result.add(node.val);
        node = node.right;
      }

      node = stack.remove(stack.size() - 1).left;
    }

    return reverse(result);
  }

  private static ArrayList<Integer> reverse(ArrayList<Integer> list) {
    ArrayList<Integer> reversed = new ArrayList<>();
    for (int i = list.size() - 1; i >= 0; i--) {
      reversed.add(list.get(i));
    }

    return reversed;
  }
}
