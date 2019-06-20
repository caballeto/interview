package interviewbit.Strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class _valid_addresses {
  public static ArrayList<String> restoreIpAddresses(String s) {
    Set<String> set = new HashSet<>();
    if (!valid(s, 0, 4)) return new ArrayList<>();
    solve(set, s, "", 4, 0);
    ArrayList<String> list = new ArrayList<>(set);
    Collections.sort(list);
    return list;
  }

  private static void solve(Set<String> list, String s, String current, int order, int index) {
    if (order == 1) {
      String sub = s.substring(index);
      int val = Integer.parseInt(sub);
      if (sub.length() != ("" + val).length()) return;
      if (val >= 0 && val <= 255) list.add(current + val);
    } else {
      StringBuilder val = new StringBuilder();
      char c1 = s.charAt(index++);
      val.append(c1);

      if (Integer.parseInt(val.toString()) <= 255 && valid(s, index, order - 1)) {
        solve(list, s, current + val + ".", order - 1, index);
      }

      if (c1 == '0' || index >= s.length()) return;
      char c2 = s.charAt(index++);
      val.append(c2);

      if (Integer.parseInt(val.toString()) <= 255 && valid(s, index, order - 1)) {
        solve(list, s, current + val + ".", order - 1, index);
      }

      if (index >= s.length()) return;
      val.append(s.charAt(index++));

      if (Integer.parseInt(val.toString()) <= 255 && valid(s, index, order - 1)) {
        solve(list, s, current + val + ".", order - 1, index);
      }
    }
  }

  private static boolean valid(String s, int start, int k) {
    int len = s.length() - start;
    return len >= k && len <= 3*k;
  }

  public static void main(String[] args) {
    System.out.println(restoreIpAddresses("010010"));
  }
}
