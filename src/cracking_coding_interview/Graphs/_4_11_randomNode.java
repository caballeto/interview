package cracking_coding_interview.Graphs;

import java.lang.reflect.Array;

public class _4_11_randomNode {
  private int count; // helper var
  private int size;
  private TreeNode root;

  public _4_11_randomNode() {
    size = 0;
    count = 0;
    root = null;
  }

  public int size() {
    return size;
  }

  public TreeNode getRandomNode() {
    if (size == 0) return null;
    int rand = (int) (Math.random()*size);
    count = 0;
    return getKthNode(root, rand);
  }

  private TreeNode getKthNode(TreeNode node, int k) {
    if (node != null) {
      TreeNode x = getKthNode(node.left, k);
      if (x != null) return x;
      if (k == count++) return node;
      return getKthNode(node.right, k);
    }

    return null;
  }

  // leetcode 230; check for correctness
  public int kthSmallest(TreeNode root, int k) {
    count = 1;
    TreeNode[] array = (TreeNode[]) Array.newInstance(TreeNode[].class, 10);
    return smallest(root, k);
  }

  private Integer smallest(TreeNode node, int k) {
    if (node != null) {
      Integer x = smallest(node.left, k);
      if (x != null) return x;
      if (k == count++) return node.val;
      return smallest(node.right, k);
    } else return null;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(3);
    root.right = new TreeNode(6);
    root.left.left = new TreeNode(2);
    root.left.right = new TreeNode(4);
    root.left.left.left = new TreeNode(1);
    System.out.println(new _4_11_randomNode().kthSmallest(root, 3));
  }
}
