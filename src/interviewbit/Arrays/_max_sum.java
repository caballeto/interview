package interviewbit.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _max_sum {
  public static int maxSubArray(final List<Integer> A) {
    int[] array = new int[A.size()];
    int msum = A.get(0);
    array[0] = A.get(0);
    for (int i = 1; i < A.size(); i++) {
      array[i] = (array[i - 1] > 0) ? array[i - 1] + A.get(i) : A.get(i);
      msum = Math.max(msum, array[i]);
    }

    return msum;
  }

  public static void main(String[] args) {
    List<Integer> a = new ArrayList<>(Arrays.asList(-2,1,-3,4,-1,2,1,-5,4));
    System.out.println(maxSubArray(a));
  }
}
