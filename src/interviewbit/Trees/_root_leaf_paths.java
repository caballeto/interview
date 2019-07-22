package interviewbit.Trees;

import cracking_coding_interview.Graphs.TreeNode;

import java.util.ArrayList;

public class _root_leaf_paths {
  private static ArrayList<ArrayList<Integer>> set;

  public static ArrayList<ArrayList<Integer>> pathSum(TreeNode node, int sum) {
    if (node == null) return new ArrayList<>();
    set = new ArrayList<>();
    solve(node, new ArrayList<>(), sum);
    return set;
  }

  private static void solve(TreeNode node, ArrayList<Integer> path, int sum) {
    sum -= node.val;
    path.add(node.val);

    if (node.right == null && node.left == null) {
      if (sum == 0) set.add(new ArrayList<>(path));
    } else if (node.left == null) {
      solve(node.right, path, sum);
    } else if (node.right == null) {
      solve(node.left, path, sum);
    } else {
      solve(node.left, path, sum);
      solve(node.right, path, sum);
    }

    path.remove(path.size() - 1);
  }
}
