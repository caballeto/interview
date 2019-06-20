package interviewbit.TwoPointers;

import java.util.ArrayList;

public class _remove_duplicates {
  public static int removeDuplicates(ArrayList<Integer> list) {
    if (list.size() < 2) return list.size();

    int prev = list.get(list.size() - 1);
    for (int i = list.size() - 2; i >= 0; i--) {
      if (list.get(i) == prev) {
        list.remove(i);
      } else {
        prev = list.get(i);
      }
    }

    return list.size();
  }
}
