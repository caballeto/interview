package leetcode.session1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _reconstruct_digits {
  private static Map<String, int[]> digitCounts;
  private static Map<String, Integer> digits;

  static {
    digits = new HashMap<>();
    digitCounts = new HashMap<>();
    digits.put("zero", 0);
    digits.put("one", 1);
    digits.put("two", 2);
    digits.put("three", 3);
    digits.put("four", 4);
    digits.put("five", 5);
    digits.put("six", 6);
    digits.put("seven", 7);
    digits.put("eight", 8);
    digits.put("nine", 9);

    for (String s : digits.keySet()) {
      digitCounts.put(s, getCount(s));
    }
  }

  public static String originalDigits(String s) {
    if (s == null || s.isEmpty()) return "";
    StringBuilder sb = new StringBuilder();
    int[] counts = getCount(s);
    for (String key : digits.keySet()) {
      int[] keyCount = digitCounts.get(key);
      while (contains(counts, keyCount)) {
        remove(counts, keyCount);
        sb.append(digits.get(key));
      }
    }

    char[] chars = new char[sb.length()];
    sb.getChars(0, sb.length(), chars, 0);
    Arrays.sort(chars);
    return new String(chars);
  }

  private static void remove(int[] c1, int[] c2) {
    for (int i = 0; i < c2.length; i++)
      if (c2[i] != 0)
        c1[i] -= c2[i];
  }

  private static boolean contains(int[] c1, int[] c2) {
    for (int i = 0; i < c2.length; i++)
      if (c2[i] != 0 && c1[i] < c2[i])
        return false;
    return true;
  }

  private static int[] getCount(String s) {
    int[] count = new int[26];
    for (char c : s.toCharArray())
      count[c - 'a']++;
    return count;
  }

  public static void main(String[] args) {
    System.out.println(originalDigits("owoztneoer"));
    System.out.println(originalDigits("fviefuro"));
  }
}
