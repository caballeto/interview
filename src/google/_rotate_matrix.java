package google;

import java.util.ArrayList;

public class _rotate_matrix {
  public static void rotate(ArrayList<ArrayList<Integer>> list) {
    if (list == null) return;
    int n = list.size();
    for (int i = 0; i < n / 2; i++) {
      for (int j = i; j < n - i - 1; j++) {
        int temp = list.get(i).get(j);
        list.get(i).set(j, list.get(n - j - 1).get(i));
        list.get(n - j - 1).set(i, list.get(n - i - 1).get(n - j - 1));
        list.get(n - i - 1).set(n - j - 1, list.get(j).get(n - i - 1));
        list.get(j).set(n - i - 1, temp);
      }
    }
  }

  /*
    int n = a.size();
    for (int i = 0; i < n/2; i++) {
      for (int j = i; j < n - i - 1; j++) {
        int temp = a.get(i).get(j);
        a.get(i).set(j, a.get(n - j - 1).get(i));
        a.get(n - j - 1).set(i, a.get(n - i - 1).get(n - j - 1));
        a.get(n - i - 1).set(n - j - 1, a.get(j).get(n - i - 1));
        a.get(j).set(n - i - 1, temp);
      }
    }
   */
}
