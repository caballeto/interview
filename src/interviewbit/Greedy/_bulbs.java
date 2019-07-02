package interviewbit.Greedy;

import java.util.ArrayList;
import java.util.Arrays;

public class _bulbs {
  public static int bulbs(ArrayList<Integer> list) {
    if (list.isEmpty()) return 0;
    int count = 0, state = 0;
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i) == state) {
        count++;
        state = (state == 0) ? 1 : 0;
      }
    }

    return count;
  }

  public static void main(String[] args) {
    System.out.println(bulbs(new ArrayList<>(Arrays.asList(0, 1, 0, 1))));
  }
}
