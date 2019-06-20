package interviewbit.Math;

import java.util.Arrays;
import java.util.List;

public class _max_profit {
  public static int maxProfit(final List<Integer> list) {
    int elem = list.get(0);
    int count = 1;
    for (int i = 1; i < list.size(); i++) {
      if (elem == list.get(i)) count++;
      else {
        if (count == 0) {
          elem = list.get(i);
          count = 1;
        } else {
          count--;
        }
      }
    }
    return elem;
  }

  public static void main(String[] args) {
    System.out.println(maxProfit(Arrays.asList(2, 2, 1, 1, 1)));
  }
}
