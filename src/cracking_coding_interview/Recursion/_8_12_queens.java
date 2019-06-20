package cracking_coding_interview.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _8_12_queens {
  // use backtracking. represent board as [0, 1, 2, 3, 4, 5, 6, 7]

  public static List<List<Integer>> queens(int size) {
    List<List<Integer>> boards = new ArrayList<>();
    for (int i = 0; i < size; i++) {
      backtrack(boards, new ArrayList<>(), i, 1, size);
    }

    return boards;
  }

  private static void backtrack(List<List<Integer>> boards, List<Integer> board, int row, int index, int size) {
    if (index == size) {
      board.add(row);
      boards.add(new ArrayList<>(board));
      board.remove(board.size() - 1);
    } else {
      board.add(row);
      for (int i = 0; i < size; i++) {
        if (!intersect(board, i, index)) {
          backtrack(boards, board, i, index + 1, size);
        }
      }

      board.remove(board.size() - 1);
    }
  }

  private static boolean intersect(List<Integer> board, int row, int col) {
    for (int i = 0; i < board.size(); i++) {
      if (intersect(board.get(i), i, row, col)) return true;
    }

    return false;
  }

  private static boolean intersect(int x1, int y1, int x2, int y2) {
    return x1 == x2 || y1 == y2 || Math.abs(x1 - x2) == Math.abs(y1 - y2);
  }

  // 51, 52 Leetcode Hard
  public int totalNQueens(int n) {
    return queens(n).size();
  }

  public List<List<String>> solveNQueens(int n) {
    return boardToString(queens(n), n);
  }

  private static List<List<String>> boardToString(List<List<Integer>> boards, int size) {
    List<List<String>> sboards = new ArrayList<>();
    for (List<Integer> board : boards) {
      sboards.add(toString(board, size));
    }

    return sboards;
  }

  private static List<String> toString(List<Integer> board, int size) {
    List<String> list = new ArrayList<>();
    for (int p : board) {
      char[] c = new char[size];
      Arrays.fill(c, '.');
      c[p] = 'Q';
      list.add(new String(c));
    }

    return list;
  }

  // test
  public static void main(String[] args) {
    final int SIZE = 8;
    var list = queens(SIZE);
    System.out.println(list.size()); // all 92 solutions; including reflection, rotation of 12 fundamental solutions
    System.out.println(list);
  }
}
