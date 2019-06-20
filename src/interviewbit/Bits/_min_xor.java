package interviewbit.Bits;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class _min_xor {
  public static int findMinXor(ArrayList<Integer> list) {
    Collections.sort(list);
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < list.size() - 1; i++) {
      min = Math.min(min, list.get(i) ^ list.get(i + 1));
    }

    return min;
  }

  public static void main(String[] args) {
    System.out.println(findMinXor(new ArrayList<>(Arrays.asList(0, 4, 7, 9))));
  }
}
