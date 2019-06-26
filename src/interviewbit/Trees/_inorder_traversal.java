package interviewbit.Trees;

import java.util.ArrayList;

public class _inorder_traversal {
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

  public static ArrayList<Integer> inorderTraversal(TreeNode node) {
    ArrayList<Integer> list = new ArrayList<>();
    ArrayList<TreeNode> nodes = new ArrayList<>();
    TreeNode n = node;
    while (n != null || nodes.size() > 0) {
      while (n != null) {
        nodes.add(n);
        n = n.left;
      }

      n = nodes.remove(nodes.size() - 1);
      list.add(n.val);
      n = n.right;
    }

    return list;
  }
}
