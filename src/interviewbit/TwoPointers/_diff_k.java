package interviewbit.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class _diff_k {
  public static int diffPossible(ArrayList<Integer> list, int B) {
    HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

    for (int i = 0; i < list.size(); i++) {
      if (map.containsKey(list.get(i))) {
        map.get(list.get(i)).add(i);
      } else {
        ArrayList<Integer> l = new ArrayList<>();
        l.add(i);
        map.put(list.get(i), l);
      }
    }

    for (int val : list) {
      if (map.containsKey(val)) {
        if (B == 0) {
          if (map.get(val).size() > 1)
            return 1;
        } else {
          return 1;
        }
      }
    }

    return 0;
  }

  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<>(Arrays.asList( 2, 14, 18, 23, 25, 36, 40, 44, 44, 53, 54, 68, 71, 80, 94));
    System.out.println(diffPossible(list, 0));
  }
}
