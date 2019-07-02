package interviewbit.Greedy;

import java.util.Arrays;

public class _assign_mice {
  public static int mice(int[] mices, int[] holes) {
    Arrays.sort(mices);
    Arrays.sort(holes);
    int total = 0;
    for (int i = 0; i < mices.length; i++) {
      total = Math.max(total, Math.abs(mices[i] - holes[i]));
    }

    return total;
  }

  public static void main(String[] args) {
    System.out.println(mice(new int[]{4, -4, 2}, new int[]{4, 0, 5}));
  }
}
