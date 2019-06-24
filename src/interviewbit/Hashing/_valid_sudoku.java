package interviewbit.Hashing;

import java.util.List;

public class _valid_sudoku {
  public static int isValidSudoku(final List<String> list) {
    int n = list.size();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (list.get(i).charAt(j) == '.') continue;
        if (inSquare(list, i, j) || inRow(list, i, j) || inCol(list, i, j))
          return 0;
      }
    }

    return 1;
  }

  private static boolean inSquare(List<String> list, int row, int col) {
    char val = list.get(row).charAt(col);
    int squarei = row / 3, squarej = col / 3;
    for (int i = 3*squarei; i < 3*squarei + 3; i++) {
      for (int j = 3*squarej; j < 3*squarej + 3; j++) {
        if (i == row && j == col) continue;
        if (list.get(i).charAt(j) == val) return true;
      }
    }

    return false;
  }

  private static boolean inRow(List<String> list, int row, int col) {
    char val = list.get(row).charAt(col);
    for (int i = 0; i < list.size(); i++) {
      if (i == col) continue;
      if (list.get(row).charAt(i) == val) return true;
    }

    return false;
  }

  private static boolean inCol(List<String> list, int row, int col) {
    char val = list.get(row).charAt(col);
    for (int i = 0; i < list.size(); i++) {
      if (i == row) continue;
      if (list.get(i).charAt(col) == val) return true;
    }

    return false;
  }
}
