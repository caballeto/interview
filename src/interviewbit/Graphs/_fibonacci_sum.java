package interviewbit.Graphs;

import java.util.ArrayList;

public class _fibonacci_sum {
  public static int fibsum(int n) {
    ArrayList<Integer> dp = new ArrayList<>();
    dp.add(1);
    dp.add(1);

    for (int i = 2; dp.get(dp.size() - 1) < n; i++) {
      int val = dp.get(i - 1) + dp.get(i - 2);
      dp.add(val);
    }

    int result = 0;
    int size = dp.size() - 1;

    while (n > 0) {
      while (dp.get(size) > n) size--;
      n -= dp.get(size);
      result++;
    }

    return result;
  }
}
