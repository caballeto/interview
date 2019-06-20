package interviewbit.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class _n_queens {
  private static ArrayList<ArrayList<Integer>> nqueens(int n) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      ArrayList<Integer> list = new ArrayList<>();
      list.add(i);
      backtrack(result, list, 1, n);
    }

    return result;
  }

  private static void backtrack(ArrayList<ArrayList<Integer>> list, ArrayList<Integer> board, int index, int n) {
    if (index == n) {
      list.add(new ArrayList<>(board));
    } else {
      for (int i = 0; i < n; i++) {
        if (!intersects(board, index, i)) {
          board.add(i);
          backtrack(list, board, index + 1, n);
          board.remove(board.size() - 1);
        }
      }
    }
  }

  private static boolean intersects(ArrayList<Integer> board, int x, int y) {
    for (int i = 0; i < board.size(); i++)
      if (intersects(i, board.get(i), x, y)) return true;
    return false;
  }

  private static boolean intersects(int i, int j, int x, int y) {
    return i == x || j == y || Math.abs(i - x) == Math.abs(j - y);
  }

  private static ArrayList<ArrayList<String>> toList(ArrayList<ArrayList<Integer>> list) {
    ArrayList<ArrayList<String>> boards = new ArrayList<>();
    for (ArrayList<Integer> board : list)
      boards.add(toString(board));
    return boards;
  }

  private static ArrayList<String> toString(ArrayList<Integer> board) {
    int size = board.size();
    ArrayList<String> sboard = new ArrayList<>();
    for (int queen : board) {
      char[] c = new char[size];
      Arrays.fill(c, '.');
      c[queen] = 'Q';
      sboard.add(new String(c));
    }

    return sboard;
  }

  public static ArrayList<ArrayList<String>> solveNQueens(int n) {
    return toList(nqueens(n));
  }

  public static void main(String[] args) {
    System.out.println(solveNQueens(4));
  }
}
