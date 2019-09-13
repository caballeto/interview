package leetcode.session1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _find_anagrams {
  public static List<Integer> findAnagrams(String s, String p) {
    if (p.length() > s.length()) return new ArrayList<>();
    List<Integer> indices = new ArrayList<>();

    char[] pAnag = new char[26], sAnag = new char[26];
    for (char c : p.toCharArray())
      pAnag[c - 'a']++;

    for (int i = 0; i < p.length(); i++)
      sAnag[s.charAt(i) - 'a']++;

    if (isAnagram(pAnag, sAnag)) {
      indices.add(0);
    }

    for (int i = p.length(); i < s.length(); i++) {
      sAnag[s.charAt(i) - 'a']++;
      sAnag[s.charAt(i - p.length()) - 'a']--;
      if (isAnagram(pAnag, sAnag)) {
        indices.add(i - p.length() + 1);
      }
    }

    return indices;
  }

  private static boolean isAnagram(char[] c1, char[] c2) {
    return Arrays.equals(c1, c2);
  }
}
