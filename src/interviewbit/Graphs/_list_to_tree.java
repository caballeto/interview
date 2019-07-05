package interviewbit.Graphs;

import cracking_coding_interview.Graphs.TreeNode;
import leetcode.ListNode;

import java.util.ArrayList;

public class _list_to_tree {
  public TreeNode sortedListToBST(ListNode a) {
    ArrayList<Integer> list = new ArrayList<>();
    while (a != null) {
      list.add(a.val);
      a = a.next;
    }

    return listToBST(list, 0, list.size() - 1);
  }

  private static TreeNode listToBST(ArrayList<Integer> list, int lo, int hi) {
    if (hi < lo) return null;
    int mid = lo + (hi - lo) / 2;
    TreeNode node = new TreeNode(list.get(mid));
    node.left = listToBST(list, lo, mid - 1);
    node.right = listToBST(list, mid + 1, hi);
    return node;
  }
}
