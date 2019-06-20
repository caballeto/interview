package cracking_coding_interview.Graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _4_3_listDepths {
  public static List<LinkedList<Integer>> depths(TreeNode root) {
    if (root == null) return null;
    ArrayDeque<TreeNode> queue = new ArrayDeque<>();
    List<LinkedList<Integer>> res = new ArrayList<>();
    LinkedList<Integer> carry = new LinkedList<>();
    int count = 1, newCount = 0;

    queue.add(root);
    while (!queue.isEmpty()) {
      TreeNode node = queue.removeFirst();
      carry.add(node.val);
      if (node.left != null) {
        queue.add(node.left);
        newCount++;
      }

      if (node.right != null) {
        queue.add(node.right);
        newCount++;
      }

      count--;
      if (count == 0) {
        res.add(carry);
        carry = new LinkedList<>();
        count = newCount;
        newCount = 0;
      }
    }

    return res;
  }

  public static void print(List<LinkedList<Integer>> depths) {
    depths.forEach(System.out::println);
  }

  public static void main(String[] args) {
    TreeNode node = new TreeNode(6);
    node.left = new TreeNode(4);
    node.right = new TreeNode(8);
    node.left.right = new TreeNode(5);
    node.left.left = new TreeNode(3);
    node.right.left = new TreeNode(7);
    node.right.right = new TreeNode(9);

    print(depths(node));
  }
}
