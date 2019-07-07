package interviewbit.Trees;

import cracking_coding_interview.Graphs.TreeNode;

public class _cnt_matrix {
  private static int count;

  public static int cntMatrix(TreeNode a, TreeNode b) {
    if (!lessEqual(a, b)) return -1;
    count = 0;
    countInsert(a, Integer.MIN_VALUE, Integer.MAX_VALUE, b);
    return count;
  }

  private static TreeNode countInsert(TreeNode t1, int min, int max, TreeNode t2) {
    if (t1 == null && t2 == null) return null;
    if (t1 == null) {
      count++;
      t1 = new TreeNode((min + (max - min) / 2));
    }

    t1.left = countInsert(t1.left, min, Math.min(max, t1.val), t2.left);
    t1.right = countInsert(t1.right, Math.max(min, t1.val), max, t2.right);
    return t1;
  }

  private static boolean lessEqual(TreeNode a, TreeNode b) {
    if (a == null && b == null) return true;
    if (a == null) return true;
    if (b == null) return false;
    return lessEqual(a.left, b.left) && lessEqual(a.right, b.right);
  }

  public static void main(String[] args) {
    TreeNode a = new TreeNode(10);
    a.left = new TreeNode(9);
    a.right = new TreeNode(20);
    a.left.left = new TreeNode(4);
    TreeNode b = new TreeNode(5);
    b.left = new TreeNode(2);
    b.right = new TreeNode(7);

    System.out.println(cntMatrix(a, b));
  }
}
