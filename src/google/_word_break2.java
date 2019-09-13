package google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _word_break2 {
  private static List<String>[] memo;

  public static List<String> wordBreak(String s, List<String> wordDict) {
    if (s.isEmpty()) return new ArrayList<>();
    memo = (List<String>[]) new ArrayList[s.length()];
    List<String> result = new ArrayList<>();
    backtrack(result, wordDict, s, 0, "");
    return result;
  }

  private static void backtrack(List<String> result, List<String> dict, String s, int index, String current) {
    if (index == s.length()) {
      result.add(current);
      return;
    }

    if (memo[index] != null) {
      for (String next : memo[index])
        result.add(current + " " + next);
      return;
    }

    List<String> nextRes = new ArrayList<>();
    for (String word : dict) {
      if (index + word.length() <= s.length() && equal(index, s, word)) {
        backtrack(nextRes, dict, s, index + word.length(), word);
      }
    }

    for (String next : nextRes)
      result.add(current + (current.isEmpty() ? "" : " ") + next);
    memo[index] = nextRes;
  }

  // check if current[index : index + word.length()] == word
  private static boolean equal(int index, String current, String word) {
    for (int i = index; i < index + word.length(); i++)
      if (current.charAt(i) != word.charAt(i - index))
        return false;
    return true;
  }

  public static void main(String[] args) {
    System.out.println(wordBreak("pineapplepenapple", new ArrayList<>(Arrays.asList("apple", "pen", "applepen", "pine", "pineapple"))));
  }
}
