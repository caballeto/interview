package interviewbit.Graphs;

import cracking_coding_interview.Graphs.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class _level_order {
  public static ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
    if (root == null) return new ArrayList<>();
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    ArrayList<Integer> current = new ArrayList<>();
    int count = 1, nextCount = 0;
    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      TreeNode node = queue.poll();
      current.add(node.val);
      count--;

      if (node.left != null) {
        nextCount++;
        queue.add(node.left);
      }

      if (node.right != null) {
        nextCount++;
        queue.add(node.right);
      }

      if (count == 0) {
        result.add(current);
        current = new ArrayList<>();
        count = nextCount;
        nextCount = 0;
      }
    }

    return result;
  }
}
