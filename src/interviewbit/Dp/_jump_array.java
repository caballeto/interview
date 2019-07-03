package interviewbit.Dp;

public class _jump_array {
  public static int canJump(int[] array) {
    if (array.length == 1) return 1;
    if (array[0] == 0) return 0;
    int p = 0, maxJump = array[0];
    while (true) {
      if (maxJump >= array.length) return 1;
      if (array[p] == 0) {
        if (p < maxJump)
          p++;
        else
          return 0;
      } else {
        maxJump = Math.max(maxJump, p + array[p]);
        p++;
      }
    }
  }

  public static void main(String[] args) {
    System.out.println(canJump(new int[]{30, 0, 0, 0, 0, 0, 0, 0, 0, 0, 11, 25, 16, 0, 21, 0, 21, 10, 10, 2, 0, 0, 0, 0, 6, 0, 29, 5, 0, 0, 22, 0, 0, 23, 0, 0, 0, 18, 0, 0, 0, 0, 22, 0, 0, 0, 0, 0, 0, 0, 0, 0, 14, 0, 0, 0, 0, 0, 0, 0, 15, 0, 0, 0, 0, 28, 0, 0, 18, 0, 0, 0, 1, 0, 0, 11, 0, 0, 0, 14, 0, 0, 2, 25, 0, 0, 0, 0, 3, 0, 7, 0, 0, 0, 16, 0, 17, 0, 17, 0, 0, 0, 0, 0, 0, 15, 15, 0, 0, 0, 0, 0, 6, 15, 9, 20, 0, 0, 0, 0, 0, 0, 0, 6, 0, 0, 6, 0, 0, 5, 0, 0, 0, 0, 0, 0, 22, 0, 0, 0, 17, 0, 0, 0, 25, 0, 3, 0, 28, 27, 0, 9, 0, 0, 27, 0, 3, 0, 0, 0, 22, 0, 0, 25, 14}));
  }
}
