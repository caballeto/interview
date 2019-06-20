package interviewbit.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class _combinations {
  public static int[][] combine(int n, int k) {
    ArrayList<int[]> result = new ArrayList<>();
    generate(result, new int[k], 1, n, 0, k);
    int[][] combs = new int[result.size()][k];

    for (int i = 0; i < result.size(); i++) {
      int[] arr = result.get(i);
      combs[i] = Arrays.copyOf(arr, arr.length);
    }

    return combs;
  }

  private static void generate(
    ArrayList<int[]> combs,
    int[] comb,
    int start,
    int end,
    int index,
    int k)
  {
    if (index == k) {
      int[] combination = comb.clone();
      combs.add(combination);
    } else if (start <= end) {
      comb[index] = start;
      generate(combs, comb, start + 1, end, index + 1, k);
      generate(combs, comb, start + 1, end, index, k);
    }
  }

  public static void main(String[] args) {
    int[][] m = combine(4, 2);
    for (var x : m) {
      System.out.println(Arrays.toString(x));
    }
  }
}
