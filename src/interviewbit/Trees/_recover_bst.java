package interviewbit.Trees;

import cracking_coding_interview.Graphs.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;

public class _recover_bst {
  public static ArrayList<Integer> recoverTree(TreeNode node) {
    if (node == null) return new ArrayList<>();
    ArrayList<Integer> list = new ArrayList<>();
    inorder(node, list);
    ArrayList<Integer> result = new ArrayList<>();
    for (int i = 0; i < list.size() - 1; i++) {
      if (list.get(i) > list.get(i + 1)) {
        if (result.isEmpty()) {
          result.add(i);
        } else {
          result.add(i + 1);
          break;
        }
      }
    }

    if (result.size() == 2) {
      return new ArrayList<>(Arrays.asList(list.get(result.get(1)), list.get(result.get(0))));
    } else {
      return new ArrayList<>(Arrays.asList(list.get(result.get(0) + 1), list.get(result.get(0))));
    }
  }

  private static void inorder(TreeNode node, ArrayList<Integer> list) {
    if (node == null) return;
    inorder(node.left, list);
    list.add(node.val);
    inorder(node.right, list);
  }
}
