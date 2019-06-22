package interviewbit.Backtracking;

import java.util.ArrayList;

public class _gray_code {
  public static ArrayList<Integer> grayCode(int n) {
    if (n == 0) {
      ArrayList<Integer> list = new ArrayList<>();
      list.add(0);
      return list;
    }

    ArrayList<Integer> grayPrev = grayCode(n - 1);
    int add = 1 << (n - 1);
    for (int i = grayPrev.size() - 1; i >= 0; i--) {
      grayPrev.add(add + grayPrev.get(i));
    }

    return grayPrev;
  }
}
