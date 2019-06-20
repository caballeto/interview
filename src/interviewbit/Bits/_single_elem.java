package interviewbit.Bits;

import java.util.List;

public class _single_elem {
  public static int singleNumber(final List<Integer> list) {
    int num = list.get(0);
    for (int i = 1; i < list.size(); i++) {
      num ^= list.get(i);
    }

    return num;
  }
}
