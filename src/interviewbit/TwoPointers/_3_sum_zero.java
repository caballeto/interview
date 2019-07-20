package interviewbit.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class _3_sum_zero {
  public static ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> nums) {
    int lo, mid, hi;
    Collections.sort(nums);
    int n = nums.size();
    HashSet<ArrayList<Integer>> triplets = new HashSet<>();
    for (lo = 0; lo < n - 2; lo++) {
      mid = lo + 1;
      hi = n - 1;
      while (mid < hi) {
        int sum = nums.get(lo) + nums.get(mid) + nums.get(hi);
        if (sum == 0) {
          triplets.add(new ArrayList<>(Arrays.asList(nums.get(lo), nums.get(mid), nums.get(hi))));
          mid++;
          hi--;
        } else if (sum < 0) {
          mid++;
        } else {
          hi--;
        }
      }
    }

    return new ArrayList<>(triplets);
  }

  public static void main(String[] args) {
    System.out.println(threeSum(new ArrayList<>(Arrays.asList(-1, 0, 1, 2, -1, -4))));
  }
}
