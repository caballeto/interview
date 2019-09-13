package google;

import java.util.ArrayList;

public class _painter_partition {
  private static final int MOD = 10000003;

  public static int paint(int painters, int paintTime, ArrayList<Integer> boards) {
    long total = 0, max = Integer.MIN_VALUE;
    for (int val : boards) {
      total += val;
      max = Math.max(max, val);
    }

    long lo = max, hi = total;
    while (lo < hi) {
      long mid = lo + (hi - lo) / 2;
      long requiredPainters = getRequiredPainters(boards, mid);
      if (requiredPainters <= painters) {
        hi = mid;
      } else {
        lo = mid + 1;
      }
    }

    return (int) ((lo % MOD) * (paintTime % MOD)) % MOD;
  }

  private static long getRequiredPainters(ArrayList<Integer> boards,long maxTimePerPainter) {
    long total = 0, painters = 1;
    for (int val : boards) {
      total += val;
      if (total > maxTimePerPainter) {
        total = val;
        painters++;
      }
    }

    return painters;
  }
}
