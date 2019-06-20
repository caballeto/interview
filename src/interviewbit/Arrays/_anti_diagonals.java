package interviewbit.Arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class _anti_diagonals {
  public static ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> a) {
    if (a.size() == 0) return new ArrayList<>();
    int n = a.size();

    ArrayList<ArrayList<Integer>> list = new ArrayList<>();

    for (int j = 0; j < n; j++) {
      add(list, a, 0, j);
    }

    for (int i = 1; i < n; i++) {
      add(list, a, i, n - 1);
    }

    return list;
  }

  private static void add(ArrayList<ArrayList<Integer>> list, ArrayList<ArrayList<Integer>> matrix, int x, int y) {
    ArrayList<Integer> ar = new ArrayList<>();
    for (int i = x, j = y; i < matrix.size() && j >= 0; i++, j--) {
      ar.add(matrix.get(i).get(j));
    }

    list.add(ar);
  }

  public static void main(String[] args) {
    ArrayList<ArrayList<Integer>> list = new ArrayList<>(Arrays.asList(
      new ArrayList<>(Arrays.asList(1, 2, 3)),
      new ArrayList<>(Arrays.asList(4, 5, 6)),
      new ArrayList<>(Arrays.asList(7, 8, 9))
    ));
    ArrayList<ArrayList<Integer>> list2 = new ArrayList<>(Arrays.asList(
      new ArrayList<>(Arrays.asList(1, 2)),
      new ArrayList<>(Arrays.asList(3, 4))
    ));
    System.out.println(diagonal(list2));
  }
}
