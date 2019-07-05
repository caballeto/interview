package interviewbit.Dp;

import cracking_coding_interview.Graphs.TreeNode;

import java.util.HashMap;

public class _max_path_tree {
  HashMap<TreeNode, Integer> cache;

  public int maxPathSum(TreeNode node) {
    cache = new HashMap<>();
    return maxPathS(node);
  }

  private int maxPathS(TreeNode node) {
    if (node == null) return Integer.MIN_VALUE;
    return Math.max(node.val,
            Math.max(node.val + maxPath(node.left) + maxPath(node.right),
              Math.max(maxPathSum(node.left), maxPathSum(node.right))));
  }

  private int maxPath(TreeNode node) {
    if (node == null) return Integer.MIN_VALUE;
    if (cache.containsKey(node)) return cache.get(node);
    int val = node.val + Math.max(maxPath(node.left), maxPath(node.right));
    cache.put(node, val);
    return val;
  }
}
