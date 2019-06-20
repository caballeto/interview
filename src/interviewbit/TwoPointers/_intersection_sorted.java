package interviewbit.TwoPointers;

import java.util.ArrayList;
import java.util.List;

public class _intersection_sorted {
  public ArrayList<Integer> intersect(final List<Integer> a, final List<Integer> b) {
    int p1 = 0, p2 = 0;
    ArrayList<Integer> list = new ArrayList<>();
    while (p1 < a.size() && p2 < b.size()) {
      if (a.get(p1) > b.get(p2)) {
        p2++;
      } else if (a.get(p1) < b.get(p2)) {
        p1++;
      } else {
        list.add(a.get(p1));
        p1++;
        p2++;
      }
    }

    return list;
  }
}
