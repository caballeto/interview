package interviewbit.Trees;

import cracking_coding_interview.Graphs.TreeNode;

import java.util.ArrayList;

public class _inorder_cartesian {
  public static TreeNode buildTree(ArrayList<Integer> list) {
    if (list.isEmpty()) return null;
    return build(list, 0, list.size() - 1);
  }

  private static TreeNode build(ArrayList<Integer> list, int lo, int hi) {
    if (lo > hi) return null;
    int index = getMax(list, lo, hi);
    TreeNode node = new TreeNode(list.get(index));
    node.left = build(list, lo, index - 1);
    node.right = build(list, index + 1, hi);
    return node;
  }

  private static int getMax(ArrayList<Integer> nums, int lo, int hi) {
    int index = lo;
    for (int i = lo; i <= hi; i++)
      if (nums.get(i) > nums.get(index))
        index = i;
    return index;
  }
}
