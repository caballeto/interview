package google;

import java.util.*;

public class _subset_sum {
  static List<List<Integer>> subset(List<Integer> nums, int sum) {
    Set<List<Integer>> set = new HashSet<>();
    backtrack(set, new ArrayList<>(), nums, sum);
    return new ArrayList<>(set);
  }

  private static void backtrack(Set<List<Integer>> all, List<Integer> current, List<Integer> nums, int sum) {
    if (sum < 0) return;
    if (sum == 0) {
      ArrayList<Integer> copy = new ArrayList<>(current);
      copy.sort(Comparator.naturalOrder());
      all.add(copy);
    }

    for (int val : nums) {
      if (sum - val < 0) continue;
      current.add(val);
      backtrack(all, current, nums, sum - val);
      current.remove(current.size() - 1);
    }
  }

  public static void main(String[] args) {
    System.out.println(subset(new ArrayList<>(Arrays.asList(10, 7, 5, 18, 12, 20, 15)), 35));
  }
}
