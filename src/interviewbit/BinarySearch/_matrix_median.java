package interviewbit.BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class _matrix_median {
  public static int findMedian(ArrayList<ArrayList<Integer>> lists) {
    int n = lists.size(), m = lists.get(0).size();
    int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

    for (int i = 0; i < n; i++) {
      if (lists.get(i).get(0) < min)
        min = lists.get(i).get(0);
      if (lists.get(i).get(m - 1) > max)
        max = lists.get(i).get(m - 1);
    }

    int k = (m*n + 1) / 2;

    while (min < max) {
      int mid = min + (max - min) / 2;
      int place = 0, get = 0;

      for (int i = 0; i < n; i++) {
        get = Collections.binarySearch(lists.get(i), mid);

        if (get < 0) {
          get = Math.abs(get) - 1;
        } else {
          while (get < lists.get(i).size() && lists.get(i).get(get) == mid)
            get++;
        }

        place += get;
      }

      if (place < k) {
        min = mid + 1;
      } else {
        max = mid;
      }
    }

    return min;
  }

  public static void main(String[] args) {
    ArrayList<ArrayList<Integer>> lists = new ArrayList<>(Arrays.asList(
      new ArrayList<>(Arrays.asList(1, 3, 5)),
      new ArrayList<>(Arrays.asList(2, 6, 9)),
      new ArrayList<>(Arrays.asList(3, 6, 9))
    ));

    System.out.println(findMedian(lists));
  }
}
