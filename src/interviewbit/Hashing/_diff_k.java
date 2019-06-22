package interviewbit.Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class _diff_k {
  public static int diffPossible(final List<Integer> list, int k) {
    if (list.size() < 2) return 0;
    HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

    for (int i = 0; i < list.size(); i++) {
      int key = list.get(i);
      if (map.containsKey(key)) {
        map.get(key).add(i);
      } else {
        ArrayList<Integer> val = new ArrayList<>();
        val.add(i);
        map.put(key, val);
      }
    }

    for (int val : list) {
      if (map.containsKey(val + k)) {
        if (k != 0 || map.get(val).size() > 1) return 1;
      }
    }

    return 0;
  }

  public static void main(String[] args) {
    List<Integer> list = new ArrayList<>(Arrays.asList(66, 37, 46, 56, 49, 65, 62, 21, 7, 70, 13, 71, 93, 26, 18, 84, 96, 65, 92, 69, 97, 47, 6, 18, 17, 47, 28, 71, 70, 24, 46, 58, 71, 21, 30, 44, 78, 31, 45, 65, 16, 3, 22, 54, 51, 68, 19, 86, 44, 99, 53, 24, 40, 92, 38, 81, 4, 96, 1, 13, 45, 76, 77, 8, 88, 50, 89, 38, 60, 61, 49, 25, 10, 80, 49, 63, 95, 74, 29, 27, 52, 27, 40, 66, 38, 22, 85, 22, 91, 98, 19, 20, 78, 77, 48, 63, 27));
    int k = 31;
    System.out.println(diffPossible(list, k));
  }
}
