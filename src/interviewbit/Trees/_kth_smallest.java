package interviewbit.Trees;

import cracking_coding_interview.Graphs.TreeNode;

import java.util.ArrayList;
import java.util.Iterator;

public class _kth_smallest {
  public int kthsmallest(TreeNode node, int n) {
    if (node == null) return 0;
    BSTIterator iterator = new BSTIterator(node);
    int val = 0;
    for (int i = 0; i < n; i++)
      val = iterator.next();
    return val;
  }

  private static class BSTIterator implements Iterator<Integer> {
    private TreeNode node;
    private ArrayList<TreeNode> stack = new ArrayList<>();

    public BSTIterator(TreeNode node) {
      this.node = node;
    }

    @Override
    public Integer next() {
      while (node != null) {
        stack.add(node);
        node = node.left;
      }

      node = stack.remove(stack.size() - 1);
      int val = node.val;
      node = node.right;
      return val;
    }

    @Override
    public boolean hasNext() {
      return node != null || !stack.isEmpty();
    }
  }
}
