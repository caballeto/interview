package interviewbit.Trees;

public class _populate_right {
  static class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;
    TreeLinkNode(int x) { val = x; }
  }

  public static void connect(TreeLinkNode root) {
    if (root == null) return;
    root.next = null;
    TreeLinkNode prev, next, firstNext = (root.left == null) ? root.right : root.left, prevPrev = root;
    while (firstNext != null) {
      next = firstNext;
      firstNext = null;
      prev = prevPrev;
      while (true) {
        if (next.left != null && firstNext == null) {
          prevPrev = next;
          firstNext = next.left;
        }
        if (next.right != null && firstNext == null) {
          prevPrev = next;
          firstNext = next.right;
        }

        if (prev == null) break;
        if (prev.left == next) {
          if (prev.right != null) {
            next.next = prev.right;
            next = next.next;
          }
          prev = prev.next;
        } else if (prev.right == next) {
          prev = prev.next;
        } else {
          if (prev.left == null) {
            if (prev.right != null) {
              next.next = prev.right;
              next = next.next;
            }
            prev = prev.next;
          } else {
            next.next = prev.left;
            next = next.next;
          }
        }
      }
    }
  }
}
