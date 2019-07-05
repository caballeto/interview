package interviewbit.Dp;

import java.util.ArrayList;
import java.util.Arrays;

public class _word_break {
  public static int wordBreak(String s, ArrayList<String> words) {
    boolean[] marked = new boolean[s.length() + 1];
    marked[0] = true;

    for (int i = 0; i < s.length(); i++) {
      for (String word : words) {
        if (marked[i] && equals(s, i, word)) {
          marked[i + word.length()] = true;
        }
      }
    }

    return marked[s.length()] ? 1 : 0;
  }

  private static boolean equals(String s, int index, String word) {
    if (index + word.length() > s.length())
      return false;

    for (int i = index; i < index + word.length(); i++) {
      if (s.charAt(i) != word.charAt(i - index)) {
        return false;
      }
    }

    return true;
  }

  // recursive
  private static int solve(String s, String[] dict, boolean[] taken) {
    if (s.isEmpty()) return 1;

    for (int i = 0; i < dict.length; i++) {
      String word = dict[i];
      if (!taken[i] && s.startsWith(word)) {
        taken[i] = true;
        if (solve(s.substring(word.length()), dict, taken) == 1)
          return 1;
        taken[i] = false;
      }
    }

    return 0;
  }

  public static void main(String[] args) {
    System.out.println(wordBreak("myinterviewtrainer", new ArrayList<>(Arrays.asList("trainer", "my", "interview"))));
    //System.out.println(equals("myinterviewtrainer", 11, "trainer"));
  }
}
