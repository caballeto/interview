package interviewbit.Dp;

import java.util.*;

public class _word_break2 {
  static HashMap<Integer, ArrayList<String>> cache;

  public static ArrayList<String> wordBreak(String s, ArrayList<String> wordDict) {
    cache = new HashMap<>();
    ArrayList<String> res = solve(s, s.length(), wordDict);
    res.sort(Comparator.naturalOrder());
    return res;
  }

  private static ArrayList<String> solve(String s, int end, ArrayList<String> dict) {
    ArrayList<String> result = new ArrayList<>();
    if (end == 0) return new ArrayList<>(Arrays.asList(""));
    if (cache.containsKey(end)) return cache.get(end);

    for (int i = 0; i < end; i++) {
      String sub = s.substring(i, end);
      if (dict.contains(sub)) {
        ArrayList<String> temp = solve(s, i, dict);
        for (String t : temp) {
          result.add(t.isEmpty() ? sub : t + " " + sub);
        }
      }
    }

    cache.put(end, result);
    return result;
  }

  public static void main(String[] args) {
    System.out.println(wordBreak("catsanddog", new ArrayList<>(Arrays.asList("cat", "cats", "and", "sand", "dog"))));
  }
}
