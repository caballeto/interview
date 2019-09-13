package leetcode.session1;

import cracking_coding_interview.Graphs.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class _right_side_view {
  public List<Integer> rightSideView(TreeNode root) {
    if (root == null) return new ArrayList<>();
    List<Integer> view = new ArrayList<>();
    visit(root, 0, view);
    return view;
  }

  private void visit(TreeNode node, int height, List<Integer> view) {
    if (node == null) return;
    if (view.size() == height)
      view.add(node.val);

    visit(node.right, height + 1, view);
    visit(node.left, height + 1, view);
  }
}
