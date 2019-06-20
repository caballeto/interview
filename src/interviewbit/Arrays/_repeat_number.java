package interviewbit.Arrays;

import java.util.HashMap;
import java.util.List;

public class _repeat_number {
  public static int repeatedNumber(final List<Integer> list) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int val : list) {
      if (map.containsKey(val)) {
        map.put(val, map.get(val) + 1);
      } else {
        map.put(val, 1);
      }
    }

    double x = list.size()/3.;

    for (int key : map.keySet()) {
      if (map.get(key) > x) return key;
    }

    return -1;
  }
}
