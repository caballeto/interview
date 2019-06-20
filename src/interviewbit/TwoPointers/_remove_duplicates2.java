package interviewbit.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;

public class _remove_duplicates2 {
    public static int removeDuplicates(ArrayList<Integer> list) {
      if (list.size() < 2) return list.size();

      int prev = list.get(list.size() - 1);
      boolean two = false;
      for (int i = list.size() - 2; i >= 0; i--) {
        if (list.get(i) == prev) {
          if (!two) {
            two = true;
          } else {
            list.remove(i);
          }
        } else {
          prev = list.get(i);
          two = false;
        }
      }

      return list.size();
    }

  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 1, 1, 2));
    System.out.println(removeDuplicates(list));
    System.out.println(list);
  }
}
