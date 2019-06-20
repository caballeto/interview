package interviewbit.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _duplicate_array {
  public static int repeatedNumber(final List<Integer> a) {
    int[] count = new int[a.size()];
    for (int val : a) {
      count[val]++;
      if (count[val] > 1) {
        return val;
      }
    }

    return -1;
  }

  public static void main(String[] args) {
    System.out.println(repeatedNumber(new ArrayList<>(Arrays.asList(3, 4, 1, 4, 1))));
  }
}
