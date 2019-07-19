package interviewbit.Dp;

import java.util.ArrayList;
import java.util.Arrays;

public class _shortest_superstring {
  // WRONG SOLUTION: NP-hard problem
  public static int solve(ArrayList<String> list) {
    if (list.isEmpty()) return 0;
    list.sort((x, y) -> y.length() - x.length());
    String val = list.get(0);

    for (int i = 1; i < list.size(); i++) {
      String s = list.get(i);
      if (!val.contains(s)) {
        val = combine(val, s);
      }
    }

    return val.length();
  }

  private static String combine(String s1, String s2) {
    int start = 0, end = 0;

    for (int i = 1; i <= s2.length(); i++) {
      String s = s2.substring(0, i);
      if (s1.endsWith(s)) {
        start = i;
      }
    }

    for (int i = 1; i <= s1.length(); i++) {
      String s = s1.substring(0, i);
      if (s2.endsWith(s)) {
        end = i;
      }
    }

    if (start > end)
      return s1 + s2.substring(start);
    else
      return s2 + s1.substring(end);
  }

  public static void main(String[] args) {
    System.out.println(solve(new ArrayList<>(Arrays.asList("bwpiqhiym", "yalcyea", "vxggfitknygyv", "xnspubqjppjbrl", "ugesmmxwjjlk", "mgbnwvf", "yveolprfdcajiu"))));
  }
}
