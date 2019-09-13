package leetcode.session1;

import cracking_coding_interview.Graphs.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class _BST_Iterator {
  class BSTIterator {
    List<TreeNode> stack = new ArrayList<>();
    TreeNode node;

    public BSTIterator(TreeNode root) {
      node = root;
    }

    /** @return the next smallest number */
    public int next() {
      while (node != null) {
        stack.add(node);
        node = node.left;
      }

      node = stack.remove(stack.size() - 1);
      int val = node.val;
      node = node.right;
      return val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
      return node != null || !stack.isEmpty();
    }
  }
}
