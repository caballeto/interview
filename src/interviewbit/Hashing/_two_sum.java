package interviewbit.Hashing;

import java.util.*;

@SuppressWarnings("Duplicates")
public class _two_sum {
  public static ArrayList<Integer> twoSum(final List<Integer> list, int target) {
    HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

    for (int i = 0; i < list.size(); i++) {
      int val = list.get(i);
      if (map.containsKey(val)) {
        map.get(val).add(i);
      } else {
        ArrayList<Integer> l = new ArrayList<>();
        l.add(i);
        map.put(val, l);
      }
    }

    int index1 = Integer.MAX_VALUE, index2 = Integer.MAX_VALUE;
    for (int i = list.size() - 1; i >= 0; i--) {
      int val = list.get(i), diff = target - val;
      if (map.containsKey(diff)) {
        ArrayList<Integer> l = new ArrayList<>();
        for (int index : map.get(diff))
          if (index < i) l.add(index);
        index2 = (!l.isEmpty()) ? i : index2;
        index1 = (!l.isEmpty()) ? Collections.min(l) : index1;
      }
    }
    if (index1 == Integer.MAX_VALUE) return new ArrayList<>();
    return new ArrayList<>(Arrays.asList(index1 + 1, index2 + 1));
  }
}
