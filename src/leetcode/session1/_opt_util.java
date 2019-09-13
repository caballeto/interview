package leetcode.session1;

import java.util.*;

public class _opt_util {
  public static List<List<Integer>> optUtil(List<List<Integer>> a, List<List<Integer>> b, int target) {
    if (a == null || b == null) return new ArrayList<>();
    b.sort(Comparator.comparingInt(value -> value.get(1)));
    int diff = Integer.MAX_VALUE;
    List<List<Integer>> result = new ArrayList<>();

    for (List<Integer> pair : a) {
      int index = binSearch(b, target - pair.get(1));
      int currDiff = target - b.get(index).get(1) - pair.get(1);
      if (currDiff == diff) {
        result.add(Arrays.asList(pair.get(0), b.get(index).get(0)));
      } else if (currDiff >= 0 && currDiff < diff) {
        diff = currDiff;
        result = new ArrayList<>();
        result.add(Arrays.asList(pair.get(0), b.get(index).get(0)));
      }
    }

    return result;
  }

  private static int binSearch(List<List<Integer>> list, int val) {
    int lo = 0, hi = list.size() - 1;
    while (lo < hi) {
      int mid = lo + (hi - lo) / 2;
      int midVal = list.get(mid).get(1);
      if      (midVal == val) return mid;
      else if (midVal < val) {
        lo = mid + 1;
      } else {
        hi = mid;
      }
    }

    return lo;
  }

  public static List<int[]> getPairs(List<int[]> a, List<int[]> b, int target) {
    a.sort(Comparator.comparingInt(x -> x[1]));
    b.sort(Comparator.comparingInt(x -> x[1]));
    int max = Integer.MIN_VALUE, m = a.size(), n = b.size();
    int i = 0, j = n - 1;
    List<int[]> result = new ArrayList<>();
    while (i < m && j >= 0) {
      int sum = a.get(i)[1] + b.get(j)[1];
      if (sum > target) {
        j--;
      } else {
        if (max <= sum) {
          if (max < sum) {
            max = sum;
            result.clear();
          }
          result.add(new int[]{a.get(i)[0], b.get(j)[0]});
          int index = j - 1;
          while (index >= 0 && b.get(index)[1] == b.get(index + 1)[1])
            result.add(new int[]{a.get(i)[0], b.get(index--)[0]});
        }

        i++;
      }
    }

    return result;
  }

  public static void main(String[] args) {
    System.out.println(optUtil(new ArrayList<>(Arrays.asList(
        Arrays.asList(1, 2),
        Arrays.asList(2, 4),
        Arrays.asList(3, 6)
      )),
      new ArrayList<>(Arrays.asList(
        Arrays.asList(1, 2)
      )), 7));
  }
}
