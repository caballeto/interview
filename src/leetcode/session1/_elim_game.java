package leetcode.session1;

public class _elim_game {
  public static int lastRemaining(int n) {
    return leftPos(1, n, 1, n);
  }

  private static int leftPos(int start, int end, int step, int n) {
    if (start == end) return start;
    if (n % 2 == 0) {
      return rightPos(start + step, end, 2*step, n / 2);
    } else {
      return rightPos(start + step, end - step, 2*step,n / 2);
    }
  }

  private static int rightPos(int start, int end, int step, int n) {
    if (start == end) return start;
    if (n % 2 == 0) {
      return leftPos(start, end - step, 2*step, n / 2);
    } else {
      return leftPos(start + step, end - step, 2*step, n / 2);
    }
  }

  public static void main(String[] args) {
    System.out.println(lastRemaining(9));
    System.out.println(lastRemaining(10));
    System.out.println(lastRemaining(14));
    System.out.println(lastRemaining(16));
    System.out.println(lastRemaining(4));
    // floor(log2(n))
    // 1 2 3 4 5 6 7 8
    // 2 4 6 8
    // 2 6
    // 6

    // 1 2 3 4 5 6 7 8 9 10
    // 2 4 6 8 10
    // 4 8
    // 8

    // 1 2 3 4 5 6 7 8 9 10 11 12 13 14
    // 2 4 6 8 10 12 14
    // 4 8 12
    // 8

    // 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
    // 2 4 6 8 10 12 14 16
    // 2 6 10 14
    // 6 14
    // 6

    // 1 2 3 4
    // 2 4
    // 2

    // left:
  }
}
