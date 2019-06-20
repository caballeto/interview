package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _1002_common_chars {
  public List<String> commonChars(String[] A) {
    List<String> chars = new ArrayList<>();
    int[] count = new int[26];
    Arrays.fill(count, Integer.MAX_VALUE);
    for (String string : A) {
      int[] cnt = new int[26];
      for (char c : string.toCharArray()) cnt[c - 'a']++;
      for (int i = 0; i < 26; i++) count[i] = Math.min(count[i], cnt[i]);
    }

    for (char c = 'a'; c <= 'z'; c++) {
      while (count[c - 'a']-- > 0) chars.add(c + "");
    }

    return chars;
  }
}
