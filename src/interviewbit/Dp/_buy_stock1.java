package interviewbit.Dp;

import java.util.List;

public class _buy_stock1 {
  public static int maxProfit(final List<Integer> array) {
    if (array.isEmpty()) return 0;
    int answer = 0;
    int min = Integer.MAX_VALUE;

    for (int val : array) {
      answer = Math.max(answer, val - min);
      min = Math.min(min, val);
    }

    return answer;
  }
}
