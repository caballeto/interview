package interviewbit.Trees;

import cracking_coding_interview.Graphs.TreeNode;

import java.util.List;

public class _sorted_to_balanced {
  public TreeNode sortedArrayToBST(final List<Integer> list) {
    if (list.isEmpty()) return null;
    return build(list, 0, list.size() - 1);
  }

  private static TreeNode build(List<Integer> list, int lo, int hi) {
    if (lo > hi) return null;
    int mid = lo + (hi - lo) / 2;
    TreeNode node = new TreeNode(list.get(mid));
    node.left = build(list, lo, mid - 1);
    node.right = build(list, mid + 1, hi);
    return node;
  }
}
