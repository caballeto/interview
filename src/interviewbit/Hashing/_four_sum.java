package interviewbit.Hashing;

import java.util.*;

public class _four_sum {
  static final ListComparator LIST_COMPARATOR = new ListComparator();

  private static class ListComparator implements Comparator<ArrayList<Integer>> {
    @Override
    public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
      int size = Math.min(o1.size(), o2.size());

      for (int i = 0; i < size; i++) {
        if (o1.get(i) < o2.get(i)) {
          return -1;
        } else if (o1.get(i) > o2.get(i)) {
          return 1;
        }
      }

      return o1.size() - o2.size();
    }
  }

  public static ArrayList<ArrayList<Integer>> fourSum(ArrayList<Integer> list, int target) {
    HashSet<ArrayList<Integer>> set = new HashSet<>();
    list.sort(Comparator.naturalOrder());

    for (int i = 0; i < list.size(); i++) {
      for (int j = i + 1; j < list.size(); j++) {
        int k = j + 1, l = list.size() - 1;
        while (k < l) {
          int sum = list.get(i) + list.get(j) + list.get(k) + list.get(l);
          if (sum > target) l--;
          else if (sum < target) k++;
          else {
            ArrayList<Integer> quad = new ArrayList<>(Arrays.asList(list.get(i), list.get(j), list.get(k), list.get(l)));
            set.add(quad);
            k++;
            l--;
          }
        }
      }
    }

    ArrayList<ArrayList<Integer>> result = new ArrayList<>(set);
    result.sort(LIST_COMPARATOR);
    return result;
  }
}
