package hackerrank.Arrays;

import java.util.Arrays;
import java.util.HashMap;

public class _new_year_chaos {
  static void minimumBribes(int[] queue) {
    int moves = 0;
    for (int i = 0; i < queue.length; i++) {
      int val = queue[i];
      if ((val - 1) - i > 2) {
        System.out.println("Too chaotic");
        return;
      }

      for (int j = Math.max(0, val - 2); j < i; j++) {
        if (queue[j] > val) {
          moves++;
        }
      }
    }

    System.out.println(moves);
  }

  public static void main(String[] args) {
    minimumBribes(new int[]{1, 2, 5, 3, 7, 8, 6, 4});
  }
}
