package google;

import java.util.List;

public class _pairwise_sum {
  private static final int MOD = 1000000007;

  public static int hammingDistance(final List<Integer> list) {
    if (list == null || list.isEmpty()) return 0;
    long sum = 0;
    for (int i = 0; i < 32; i++) {
      long ones = 0;
      for (int val : list)
        ones += ((val >> i) & 1);
      sum += ones * (list.size() - ones);
    }

    return (int) (2*sum) % MOD;
  }
}
