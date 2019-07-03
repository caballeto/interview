package interviewbit.Dp;

public class _min_jumps {
  public static int jump(int[] array) {
    if (array.length <= 1) return 0;
    if (array[0] == 0) return -1;

    int maxReach = array[0];
    int step = array[0];
    int jumps = 1;

    for (int i = 1; i < array.length; i++) {
      if (i == array.length - 1)
        return jumps;

      maxReach = Math.max(maxReach, i + array[i]);
      step--;

      if (step == 0) {
        jumps++;

        if (i >= maxReach)
          return -1;
        step = maxReach - i;
      }
    }

    return -1;
  }
}
