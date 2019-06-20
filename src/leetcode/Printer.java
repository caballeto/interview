package leetcode;

public final class Printer {
  private static void print() {
    System.out.println("This is a private method.");
  }

  public static void print(ListNode node) {
    while (node != null) {
      System.out.print(node.val + " -> ");
      node = node.next;
    }
    System.out.println("" + node);
  }

  public static void print(int[][] matrix) {
    if (matrix == null)
      throw new IllegalArgumentException();

    int rows = matrix.length;
    int cols = matrix[0].length;

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        System.out.print(matrix[i][j] + " ");
      }

      System.out.println();
    }
  }
}
