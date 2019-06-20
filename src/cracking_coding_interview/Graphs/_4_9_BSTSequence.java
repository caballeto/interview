package cracking_coding_interview.Graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class _4_9_BSTSequence {
  private static List<List<Integer>> generatePerm(List<Integer> nums) {
    if (nums.size() == 0) {
      List<List<Integer>> result = new ArrayList<>();
      result.add(new ArrayList<>());
      return result;
    }

    Integer elem = nums.remove(0);
    List<List<Integer>> result = new ArrayList<>();
    List<List<Integer>> perms  = generatePerm(nums);
    for (var perm : perms) {
      for (int i = 0; i <= perm.size(); i++) {
        List<Integer> temp = new ArrayList<>(perm);
        temp.add(i, elem);
        result.add(temp);
      }
    }

    return result;
  }

  public static List<List<Integer>> sequence(TreeNode root) {
    if (root == null) return null;
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> currentLevel = new ArrayList<>();
    int count = 1, newCount = 0;
    ArrayDeque<TreeNode> queue = new ArrayDeque<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      TreeNode node = queue.removeFirst();
      currentLevel.add(node.val);

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
        var permutations = generatePerm(currentLevel);
        if (permutations.size() == 1) {
          res.add(permutations.get(0));
        } else {
          List<List<Integer>> newRes = new ArrayList<>();
          for (var list : res) {
            for (var perm : permutations) {
              List<Integer> newList = new ArrayList<>(list);
              newList.addAll(perm);
              newRes.add(newList);
            }
          }

          res = newRes;
        }

        count = newCount;
        newCount = 0;
      }
    }

    return res;
  }

  public static void main(String[] args) {
    TreeNode node = new TreeNode(6);
    node.left = new TreeNode(4);
    node.right = new TreeNode(8);
    node.left.left = new TreeNode(3);
    node.left.right = new TreeNode(5);
    node.right.left = new TreeNode(7);
    node.right.right = new TreeNode(9);

    var sequences = sequence(node);
    System.out.println("Assert 48 == " +  sequences.size() + " : " + (sequences.size() == 48)); // 1!*2!*4!
    for (var seq : sequences) {
      System.out.println(seq);
    }
  }
}
