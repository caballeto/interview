package interviewbit.TwoPointers;

import java.util.ArrayList;

public class _max_area {
  public static int maxArea(ArrayList<Integer> list) {
    int marea = 0;
    int i = 0, j = list.size() - 1;

    while (i < j) {
      int a = list.get(i), b = list.get(j);
      int dist = j - i, val = Math.min(a, b) * dist;

      if (val > marea) {
        marea = val;
      }

      if (a < b) {
        i++;
      } else {
        j--;
      }
    }

    return marea;
  }
}
