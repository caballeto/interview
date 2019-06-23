package interviewbit.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _sudoku {
  public static void solveSudoku(ArrayList<ArrayList<Character>> sudoku) {
    try {
      backtrack(sudoku, 0, 0);
    } catch (Exception e) {
      assert e.getMessage().equals("end");
    }
  }

  private static void backtrack(ArrayList<ArrayList<Character>> sudoku, int row, int col) {
    if (row == sudoku.size()) {
      throw new RuntimeException("end");
    } else if (sudoku.get(row).get(col) == '.') {
      for (int i = 1; i <= 9; i++) {
        if (!inSquare(sudoku, row, col, i) && !inRow(sudoku, row, i) && !inCol(sudoku, col, i)) {
          sudoku.get(row).set(col, (char) (i + '0'));
          boolean last = col == sudoku.size() - 1;
          backtrack(sudoku, (last) ? row + 1 : row, (last) ? 0 : col + 1);
          sudoku.get(row).set(col, '.');
        }
      }
    } else {
      boolean last = col == sudoku.size() - 1 ;
      backtrack(sudoku, (last) ? row + 1 : row, (last) ? 0 : col + 1);
    }
  }

  private static boolean inSquare(ArrayList<ArrayList<Character>> sudoku, int row, int col, int val) {
    int startRow = row / 3, startCol = col / 3;
    for (int i = 3*startRow; i < 3*startRow + 3; i++) {
      for (int j = 3*startCol; j < 3*startCol + 3; j++) {
        if (sudoku.get(i).get(j) == (char) (val + '0')) return true;
      }
    }

    return false;
  }

  private static boolean inRow(ArrayList<ArrayList<Character>> sudoku, int row, int val) {
    for (int i = 0; i < sudoku.size(); i++)
      if (sudoku.get(row).get(i) == (char) (val + '0')) return true;
    return false;
  }

  private static boolean inCol(ArrayList<ArrayList<Character>> sudoku, int col, int val) {
    for (int i = 0; i < sudoku.size(); i++)
      if (sudoku.get(i).get(col) == (char) (val + '0')) return true;
    return false;
  }

  private static ArrayList<ArrayList<Character>> toChars(ArrayList<String> list) {
    ArrayList<ArrayList<Character>> result = new ArrayList<>();
    for (String s : list)
      result.add(new ArrayList<>(asList(s)));
    return result;
  }

  private static List<Character> asList(String string) {
    ArrayList<Character> list = new ArrayList<>();
    for (int i = 0; i < string.length(); i++)
      list.add(string.charAt(i));
    return list;
  }

  public static void main(String[] args) {
    ArrayList<String> sudokuStr = new ArrayList<>(Arrays.asList(
      "53..7....", "6..195...", ".98....6.", "8...6...3", "4..8.3..1", "7...2...6", ".6....28.", "...419..5", "....8..79"
    ));

    ArrayList<ArrayList<Character>> sudoku = toChars(sudokuStr);
    solveSudoku(sudoku);
    System.out.println(sudoku);
  }
}
