package interviewbit.Strings;

import java.util.ArrayList;
import java.util.Arrays;

public class _longest_prefix {
  public static String longestCommonPrefix(ArrayList<String> list) {
    if (list.isEmpty()) return "";
    String current = list.get(0);

    for (int i = 0; i < list.size() - 1; i++) {
      String a = list.get(i), b = list.get(i + 1);
      String prefix = commonPrefix(a, b);
      current = (current.length() > prefix.length()) ? prefix : current;
    }

    return current;
  }

  private static String commonPrefix(String a, String b) {
    int common = 0, size = Math.min(a.length(), b.length());

    for (int i = 0; i < size; i++) {
      if (a.charAt(i) != b.charAt(i)) break;
      else common++;
    }

    return a.substring(0, common);
  }

  public static void main(String[] args) {
    ArrayList<String> list = new ArrayList<>(Arrays.asList("abcdefgh", "befghijk", "abcefgh"));

    System.out.println(longestCommonPrefix(list));
  }
}
