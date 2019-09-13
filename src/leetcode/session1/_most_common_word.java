package leetcode.session1;

import java.util.*;

public class _most_common_word {
  public static String mostCommonWord(String paragraph, String[] banned) {
    paragraph += " ";
    Set<String> ban = new HashSet<>();
    Collections.addAll(ban, banned);

    HashMap<String, Integer> map = new HashMap<>();
    int maxCount = 0;
    String max = "";
    StringBuilder sb = new StringBuilder();

    for (char c : paragraph.toCharArray()) {
      if (Character.isLetter(c)) {
        sb.append(Character.toLowerCase(c));
      } else if (sb.length() > 0) {
        String word = sb.toString();
        if (!ban.contains(word)) {
          map.put(word, map.getOrDefault(word, 0) + 1);
          if (map.get(word) > maxCount) {
            maxCount = map.get(word);
            max = word;
          }
        }

        sb = new StringBuilder();
      }
    }

    return max;
  }

  /*
  public static String mostCommonWord(String paragraph, String[] banned) {
    if (paragraph.isEmpty()) return "";
    HashMap<String, Integer> count = new HashMap<>();
    for (String word : banned)
      count.put(word, -1);

    String[] words = paragraph.toLowerCase().split("\\W+");
    int maxCount = Integer.MIN_VALUE;
    String maxWord = "";

    for (String word : words) {
      if (!count.containsKey(word)) {
        count.put(word, 1);
        if (maxCount < 1) {
          maxCount = 1;
          maxWord = word;
        }
      } else if (count.get(word) != -1) {
        int val = count.get(word) + 1;
        count.put(word, val);
        if (maxCount < val) {
          maxCount = val;
          maxWord = word;
        }
      }
    }

    return maxWord;
  }
   */

  public static void main(String[] args) {
    System.out.println(mostCommonWord("a.", new String[]{}));
  }
}
