package interviewbit.Greedy;

import java.util.ArrayList;
import java.util.Comparator;

public class _max_number {
  public static int maxp3(ArrayList<Integer> list) {
    list.sort(Comparator.naturalOrder());
    int n = list.size();
    return Math.max(list.get(0)*list.get(1)*list.get(n - 1), list.get(n - 1)*list.get(n - 2)*list.get(n - 3));
  }
}
