package interviewbit.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class _3_sum {
  public static int threeSumClosest(ArrayList<Integer> A, int B) {
    int low, high, mid;
    Collections.sort(A);
    int n = A.size();
    int res = A.get(0) + A.get(1) + A.get(2);
    if (n == 3) return res;
    int sum;

    for (low = 0; low < n - 2; low++) {
      mid = low + 1;
      high = n - 1;
      int num = B - A.get(low);
      while (mid < high) {
        sum = A.get(mid) + A.get(high);

        if (sum == num)
          return B;
        else if (sum < num) {
          mid++;
        } else {
          high--;
        }

        int diff = Math.abs(sum - num);
        int otherDiff = Math.abs(res - B);

        if (diff < otherDiff)
          res = sum + A.get(low);
      }
    }
    return res;
  }

  public static void main(String[] args) {
    System.out.println(threeSumClosest(new ArrayList<>(Arrays.asList(5, -2, -1, -10, 10)), 5));
  }
}
