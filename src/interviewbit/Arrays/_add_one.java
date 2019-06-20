package interviewbit.Arrays;

import java.util.ArrayList;

public class _add_one {
  public static ArrayList<Integer> plusOne(ArrayList<Integer> A) {
    addIt(A);
    while (A.get(0) == 0) A.remove(0);
    return A;
  }

  private static void addIt(ArrayList<Integer> list) {
    boolean add = true;
    for (int i = list.size() - 1; i >= 0; i--) {
      if (!add) break;
      int val = list.get(i) + 1;
      if (val == 10) {
        list.set(i, 0);
      } else {
        list.set(i, val);
        add = false;
      }
    }

    if (add) {
      list.add(0, 1);
    }
  }
}
