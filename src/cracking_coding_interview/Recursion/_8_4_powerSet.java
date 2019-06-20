package cracking_coding_interview.Recursion;

import java.util.ArrayList;
import java.util.List;

public class _8_4_powerSet {
  public static <T> List<List<T>> powerSet(List<T> set) {
    List<List<T>> sets = new ArrayList<>();
    int n = set.size(), total = 1 << n;
    for (int i = 0; i < total; i++) {
      List<T> s = new ArrayList<>();
      for (int j = 0; j < n; j++) {
        if (((i >> j) & 1) == 1) s.add(set.get(j));
      }
      sets.add(s);
    }

    return sets;
  }

  public static void printPowerSet(int[] nums) {
    int n = nums.length, total = 1 << n;
    for (int i = 0; i < total; i++) {
      System.out.print("{ ");
      for (int j = 0; j < n; j++)
        if (((i >> j) & 1) == 1) System.out.print(nums[j] + " ");
      System.out.println("}");
    }
  }

  public static void main(String[] args) {
    int[] nums = {1, 2, 3, 4};
    printPowerSet(nums);
  }
}
