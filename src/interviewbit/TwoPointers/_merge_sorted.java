package interviewbit.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;

public class _merge_sorted {
  public static void merge(ArrayList<Integer> a, ArrayList<Integer> b) {
    int p1 = 0, p2 = 0;

    while (p2 < b.size()) {
      if (p1 < a.size()) {
        if (a.get(p1) < b.get(p2)) {
          p1++;
        } else {
          a.add(p1, b.get(p2));
          p1++;
          p2++;
        }
      } else {
        a.add(b.get(p2++));
      }
    }
  }

  public static void main(String[] args) {
    ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1, 5, 8));
    ArrayList<Integer> b = new ArrayList<>(Arrays.asList(6, 9));
    merge(a, b);
    System.out.println(a);
  }
}
