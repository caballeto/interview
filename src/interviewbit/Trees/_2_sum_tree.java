package interviewbit.Trees;

import cracking_coding_interview.Graphs.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class _2_sum_tree {
  private static int value = 0;

  public int t2Sum(TreeNode node, int n) {
    value = 0;
    Iterator<Integer> iterator = new BSTIterator(node, n);
    while (iterator.hasNext()) {
      iterator.next();
    }

    return value;
  }

  private static class BSTIterator implements Iterator<Integer> {
    private int k;
    private TreeNode node;
    private HashSet<Integer> values = new HashSet<>();
    private ArrayList<TreeNode> stack = new ArrayList<>();

    public BSTIterator(TreeNode node, int k) {
      this.node = node;
      this.k = k;
    }

    @Override
    public Integer next() {
      while (node != null) {
        stack.add(node);
        values.add(node.val);
        node = node.left;
      }

      node = stack.remove(stack.size() - 1);
      int val = node.val;
      if (values.contains(k - val) && k - val != val) value = 1;
      node = node.right;
      return val;
    }

    @Override
    public boolean hasNext() {
      return node != null || !stack.isEmpty();
    }
  }
}
