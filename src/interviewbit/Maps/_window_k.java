package interviewbit.Maps;

import java.util.ArrayList;
import java.util.HashMap;

public class _window_k {
  public static ArrayList<Integer> dNums(ArrayList<Integer> list, int k) {
    HashMap<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < k; i++) {
      int val = list.get(i);
      if (map.containsKey(val)) {
        map.put(val, map.get(val) + 1);
      } else {
        map.put(val, 1);
      }
    }

    ArrayList<Integer> distinct = new ArrayList<>();
    distinct.add(map.size());

    for (int i = k; i < list.size(); i++) {
      int prev = list.get(i - k), val = list.get(i);
      if (map.get(prev) == 1) {
        map.remove(prev);
      } else {
        map.put(prev, map.get(prev) - 1);
      }

      if (map.containsKey(val)) {
        map.put(val, map.get(val) + 1);
      } else {
        map.put(val, 1);
      }

      distinct.add(map.size());
    }

    return distinct;
  }
}
