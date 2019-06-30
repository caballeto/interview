package interviewbit.Trees;

import cracking_coding_interview.Graphs.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;

public class _zigzag_traversal {
  public static ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode node) {
    if (node == null) return new ArrayList<>();
    ArrayList<Integer> current = new ArrayList<>();
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.add(node);
    int k = 1, nextK = 0;
    while (!queue.isEmpty()) {
      TreeNode n = queue.poll();
      current.add(n.val);
      if (n.left != null) {
        nextK++;
        queue.add(n.left);
      }
      if (n.right != null) {
        nextK++;
        queue.add(n.right);
      }

      k--;
      if (k == 0) {
        k = nextK;
        nextK = 0;
        result.add(current);
        current = new ArrayList<>();
      }
    }

    for (int i = 1; i < result.size(); i += 2) {
      Collections.reverse(result.get(i));
    }

    return result;
  }
}
