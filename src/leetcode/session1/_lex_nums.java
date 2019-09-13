package leetcode.session1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _lex_nums {
  public static List<Integer> lexicalOrde(int n) {
    List<Integer> result = new ArrayList<>();
    Queue<Integer> q = new LinkedList<>();
    for (int i = 1; i <= 9 && i <= n; i++) {
      q.add(i);
      while (!q.isEmpty()) {
        int val = q.poll();
        result.add(val);
        int start = 10 * val;
        for (int j = start; j < start + 10 && j <= n; j++) {
          q.add(j);
        }
      }
    }

    return result;
  }

  public static List<Integer> lexicalOrder(int n) {
    List<Integer> result = new ArrayList<>();
    for (int i = 1; i < 10; i++)
      dfs(result, i, n);
    return result;
  }

  private static void dfs(List<Integer> result, int start, int end) {
    if (start > end) return;
    result.add(start);
    for (int i = 0; i < 10; i++) {
      if (start * 10 + i > end) return;
      dfs(result, start * 10 + i, end);
    }
  }

  public static void main(String[] args) {
    System.out.println(lexicalOrder(110));
  }
}
