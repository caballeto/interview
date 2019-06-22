package interviewbit.Backtracking;

import java.util.*;

public class _combination_sum2 {
  private static boolean[] taken;

  public static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> list, int target) {
    taken = new boolean[list.size()];
    Set<ArrayList<Integer>> set = new HashSet<>();
    backtrack(set, list, new ArrayList<>(), target);
    return new ArrayList<>(set);
  }

  private static void backtrack(Set<ArrayList<Integer>> set, ArrayList<Integer> values, ArrayList<Integer> comb, int current) {
    if (current == 0) {
      ArrayList<Integer> list = new ArrayList<>(comb);
      list.sort(Comparator.naturalOrder());
      set.add(list);
    } else if (current > 0) {
      for (int i = 0; i < values.size(); i++) {
        if (!taken[i]) {
          taken[i] = true;
          comb.add(values.get(i));
          backtrack(set, values, comb,current - values.get(i));
          comb.remove(comb.size() - 1);
          taken[i] = false;
        }
      }
    }
  }

  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<>(Arrays.asList(10,1,2,7,6,1,5));
    System.out.println(combinationSum(list, 8));
  }
}
