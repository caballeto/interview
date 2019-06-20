package interviewbit.Math;

import java.util.ArrayList;
import java.util.HashMap;

public class _brute_force {
  public static String solve(String s, String t) {
    HashMap<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < t.length(); i++) {
      char c = t.charAt(i);
      if (map.containsKey(c)) {
        map.put(c, map.get(c) + 1);
      } else {
        map.put(c, 1);
      }
    }

    int p1 = 0, p2 = 1;
    ArrayList<String> windows = new ArrayList<>();
    HashMap<Character, Integer> chars = new HashMap<>();
    chars.put(s.charAt(0), 1);

    while (p2 < s.length()) {
      if (!containsAll(map, chars) && p2 != s.length() - 1) {
        if (chars.containsKey(s.charAt(p2))) {
          chars.put(s.charAt(p2), chars.get(s.charAt(p2)) + 1);
        } else {
          chars.put(s.charAt(p2), 1);
        }

        p2++;
      } else {
        while (!map.containsKey(s.charAt(p1))) p1++;
        windows.add(s.substring(p1, p2 + 1));
        p1 = p2;
        p2++;
        chars.clear();
        chars.put(s.charAt(p1), 1);
      }
    }

    return min(windows);
  }

  private static String min(ArrayList<String> list) {
    String min = list.get(0);
    for (String s : list) {
      if (s.length() < min.length()) {
        min = s;
      } else if (s.length() == min.length() && s.compareTo(min) < 0) {
        min = s;
      }
    }

    return min;
  }

  private static boolean containsAll(HashMap<Character, Integer> map1, HashMap<Character, Integer> map2) {
    for (char key : map1.keySet()) {
      if (!map2.containsKey(key)) return false;
      if (map2.get(key) < map1.get(key)) return false;
    }

    return true;
  }

  public static void main(String[] args) {
    System.out.println(solve("ADOBECODEBANC", "ADOBECODEBANC"));
  }
}
