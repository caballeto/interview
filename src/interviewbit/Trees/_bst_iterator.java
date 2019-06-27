package interviewbit.Trees;

import cracking_coding_interview.Graphs.TreeNode;

import java.util.ArrayList;

public class _bst_iterator {
  private ArrayList<TreeNode> stack = new ArrayList<>();
  private TreeNode node;

  public _bst_iterator(TreeNode root) {
    node = root;
  }

  /** @return whether we have a next smallest number */
  public boolean hasNext() {
    return node != null || !stack.isEmpty();
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
}
