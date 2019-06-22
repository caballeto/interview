package interviewbit.Backtracking;

import java.util.*;

public class _combination_sum {
  private static final ListComparator LIST_COMPARATOR = new ListComparator();

  public static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> list, int target) {
    Set<ArrayList<Integer>> set = new HashSet<>();
    backtrack(set, list, new ArrayList<>(), target);
    ArrayList<ArrayList<Integer>> res = new ArrayList<>(set);
    res.sort(LIST_COMPARATOR);
    return res;
  }

  private static void backtrack(Set<ArrayList<Integer>> set, ArrayList<Integer> values, ArrayList<Integer> comb, int current) {
    if (current == 0) {
      ArrayList<Integer> list = new ArrayList<>(comb);
      list.sort(Comparator.naturalOrder());
      set.add(list);
    } else if (current > 0) {
      for (int val : values) {
        comb.add(val);
        backtrack(set, values, comb, current - val);
        comb.remove(comb.size() - 1);
      }
    }
  }

  private static class ListComparator implements Comparator<ArrayList<Integer>> {
    @Override
    public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
      int size = Math.min(o1.size(), o2.size());

      for (int i = 0; i < size; i++) {
        if (o1.get(i) > o2.get(i)) {
          return 1;
        } else if (o1.get(i) < o2.get(i)) {
          return -1;
        }
      }

      return o1.size() - o2.size();
    }
  }

  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<>(Arrays.asList(2, 3, 6, 7));
    System.out.println(combinationSum(list, 7));
  }
}
