package interviewbit.Trees;

import cracking_coding_interview.Graphs.TreeNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class _vertical_traversal {
  static Entry e = new Entry(0, 0, 0);

  static class Entry {
    int x; // vertical level
    int y; // depth
    int val;

    Entry(int x, int y, int val) {
      this.x = x;
      this.y = y;
      this.val = val;
    }
  }

  public static ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode node) {
    if (node == null) return new ArrayList<>();
    maxLeftRight(node, 0, 0);
    int size = 1 + e.x + e.y, mid = 1 + e.x;
    ArrayList<Entry>[] entries = (ArrayList<Entry>[]) new ArrayList[size];
    for (int i = 0; i < entries.length; i++)
      entries[i] = new ArrayList<>();
    traverse(entries, node, mid, size, 1);
    return toInt(entries);
  }

  private static void traverse(ArrayList<Entry>[] entries, TreeNode node, int offset, int size, int depth) {
    if (node == null || offset < 1 || offset > size) return;
    entries[offset - 1].add(new Entry(offset, depth, node.val));
    traverse(entries, node.left, offset - 1, size, depth + 1);
    traverse(entries, node.right, offset + 1, size, depth + 1);
  }

  private static ArrayList<ArrayList<Integer>> toInt(ArrayList<Entry>[] entries) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    for (int i = 0; i < entries.length; i++) {
      ArrayList<Entry> list = entries[i];
      if (list.isEmpty()) continue;
      list.sort(Comparator.comparingInt(e -> e.y));
      ArrayList<Integer> temp = new ArrayList<>();
      for (Entry entry : list)
        temp.add(entry.val);
      result.add(temp);
    }

    return result;
  }

  private static void maxLeftRight(TreeNode node, int left, int right) {
    if (node == null) return;
    e.x = Math.max(e.x, left);
    e.y = Math.max(e.y, right);
    maxLeftRight(node.left, left + 1, right - 1);
    maxLeftRight(node.right, left - 1, right + 1);
  }

  public static void main(String[] args) {
    TreeNode node = new TreeNode(6);
    node.left = new TreeNode(3);
    node.right = new TreeNode(7);
    node.left.left = new TreeNode(2);
    node.left.right = new TreeNode(5);
    node.right.right = new TreeNode(9);
    System.out.println(verticalOrderTraversal(node));
  }
}
