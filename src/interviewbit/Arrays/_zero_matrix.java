package interviewbit.Arrays;

import java.util.ArrayList;

public class _zero_matrix {
  private static void zeroRow(ArrayList<ArrayList<Integer>> matrix, int row) {
    for (int c = 0; c < matrix.get(0).size(); c++) {
      matrix.get(row).set(c, 0);
    }
  }

  private static void zeroCol(ArrayList<ArrayList<Integer>> matrix, int col) {
    for (int r = 0; r < matrix.size(); r++) {
      matrix.get(r).set(col, 0);
    }
  }

  public static void zeroMatrix(ArrayList<ArrayList<Integer>> list) {
    if (list == null || list.size() == 0 || list.size() == 1) return;
    int n = list.size(), m = list.get(0).size();
    boolean zeroHoriz = false;

    for (int j = 0; j < m; j++) {
      if (list.get(0).get(j) == 0) {
        zeroHoriz = true;
        break;
      }
    }

    for (int i = 0; i < n; i++) {
      if (list.get(i).get(0) == 0) {
        list.get(0).set(0, 0);
        break;
      }
    }

    for (int i = 1; i < n; i++) {
      for (int j = 1; j < m; j++) {
        if (list.get(i).get(j) == 0) {
          list.get(i).set(0, 0);
          list.get(0).set(j, 0);
        }
      }
    }

    for (int i = 1; i < n; i++)
      if (list.get(i).get(0) == 0) zeroRow(list, i);
    for (int j = 1; j < m; j++)
      if (list.get(0).get(j) == 0) zeroCol(list, j);

    if (list.get(0).get(0) == 0) zeroCol(list, 0);
    if (zeroHoriz) zeroRow(list, 0);
  }
}
