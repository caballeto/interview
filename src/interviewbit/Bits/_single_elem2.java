package interviewbit.Bits;

import java.util.HashMap;
import java.util.List;

public class _single_elem2 {
  public int singleNumber(final List<Integer> list) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int val : list) {
      if (map.containsKey(val)) {
        map.put(val, map.get(val) + 1);
      } else {
        map.put(val, 1);
      }
    }

    for (int key : map.keySet()) {
      if (map.get(key) == 1) return key;
    }

    return -1;
  }
}
