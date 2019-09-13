package leetcode.session1;

import java.util.*;

public class _two_sum {
  public static int twoSum(int[] array, int target) {
    if (array == null) return 0;
    Map<Integer, Integer> map = new HashMap<>();
    Set<List<Integer>> set = new HashSet<>();
    int count = 0;
    for (int i = 0; i < array.length; i++) {
      int complement = target - array[i];
      if (map.containsKey(complement) && !set.contains(Arrays.asList(complement, array[i]))) {
        count++;
        set.add(Arrays.asList(complement, array[i]));
      }
      map.put(array[i], i);
    }

    return count;
  }

  public static void main(String[] args) {
    System.out.println(twoSum(new int[]{1, 1, 2, 45, 46, 46}, 47));
  }
}
