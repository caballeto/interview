package google;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class _first_unique {
  public static int firstUniqChar(String s) {
    if (s.isEmpty()) return -1;
    int[] index = new int[26];

    for (char c : s.toCharArray())
      index[c - 'a']++;
    for (int i = 0; i < s.length(); i++)
      if (index[s.charAt(i) - 'a'] == 1) return i;
    return -1;
  }
}
