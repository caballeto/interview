package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class _139_word_break {
  public boolean wordBreak(String s, List<String> wordDict) {
    HashSet<String> set = new HashSet<>(wordDict);
    boolean[] marked = new boolean[s.length() + 1];
    marked[0] = true;

    for (int i = 1; i <= s.length(); i++) {
      for (int j = 0; j < i; j++) {
        if (marked[j] && set.contains(s.substring(j, i))) {
          marked[i] = true;
          break;
        }
      }
    }

    return marked[s.length()];
  }

  public static void main(String[] args) {
    List<String> dict = new ArrayList<>(Arrays.asList("leec", "code", "ccc"));
    String s = "leeccode";
    System.out.println(new _139_word_break().wordBreak(s, dict));
  }
}
