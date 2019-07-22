package interviewbit.Graphs;

import java.util.ArrayList;
import java.util.Arrays;

public class _word_search {
  public static int exist(ArrayList<String> board, String word) {
    int n = board.size(), m = board.get(0).length();

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (exist(board, word, i, j, 0)) { // search word starting at (i, j)
          return 1;
        }
      }
    }

    return 0;
  }

  private static boolean exist(ArrayList<String> board, String word, int x, int y, int index) {
    if (index == word.length()) return true; // return true if reached end of word
    if (x < 0 || x >= board.size() || y < 0 || y >= board.get(0).length() || board.get(x).charAt(y) != word.charAt(index))
      return false; // return false if (i, j) is our of bound or board[x][y] != word[index]
    boolean flag = exist(board, word, x+1, y, index + 1); // search adjacent positions
    if (!flag) flag = exist(board, word, x-1, y, index + 1);
    if (!flag) flag = exist(board, word, x, y+1, index + 1);
    if (!flag) flag = exist(board, word, x, y-1, index + 1);
    return flag;
  }

  public static void main(String[] args) {
    System.out.println(exist(new ArrayList<>(Arrays.asList("GFDABEGEE", "DAEFEECCF", "CAGGEDCDG", "GCABEAAEA", "CFGCGEEFB", "AFFBADFFC", "ECAGGDFAD")), "DFFBFDACBF"));
  }
}
