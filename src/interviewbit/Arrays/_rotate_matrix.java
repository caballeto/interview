package interviewbit.Arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class _rotate_matrix {
  public static void rotate(ArrayList<ArrayList<Integer>> a) {
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
  }

  public static void main(String[] args) {
    ArrayList<ArrayList<Integer>> list = new ArrayList<>(Arrays.asList(
      new ArrayList<>(Arrays.asList(1, 2)),
      new ArrayList<>(Arrays.asList(3, 4))
    ));

    rotate(list);
    System.out.println(list);
  }
}
