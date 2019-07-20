package interviewbit.TwoPointers;

import java.util.ArrayList;
import java.util.Collections;

public class _count_triangles {
  public static int nTriang(ArrayList<Integer> list) {
    Collections.sort(list);
    long count = 0;
    for (int i = 0; i < list.size() - 2; i++) {
      int k = i + 2;
      for (int j = i + 1; j < list.size() - 1 && list.get(i) != 0; j++) {
        while (k < list.size() && list.get(i) + list.get(j) > list.get(k)) {
          k++;
        }

        count = (count + (k - j - 1)) % 1000000007;
      }
    }

    return (int) count;
  }
}
