package cracking_coding_interview.Recursion;

import java.util.HashMap;

public class _8_14_booleanEval {
  public static int eval(String s, boolean result) {
    return eval(s, result, new HashMap<>());
  }

  private static int eval(String s, boolean result, HashMap<String, Integer> map) {
    if (s.length() == 0) return 0;
    if (s.length() == 1) return s.equals("1") ? 1 : 0;
    if (map.containsKey(result + s)) return map.get(result + s);

    int ways = 0;
    for (int i = 1; i < s.length(); i += 2) {
      char c = s.charAt(i);
      String left = s.substring(0, i), right = s.substring(i + 1);
      int ltrue = eval(left, true, map), lfalse = eval(left, false, map);
      int rtrue = eval(right, true, map), rfalse = eval(right, false, map);
      int total = (ltrue + lfalse) * (rtrue + rfalse), totalTrue = 0;

      if (c == '^')
        totalTrue = ltrue * rfalse + lfalse * rtrue;
      else if (c == '&')
        totalTrue = ltrue * rtrue;
      else if (c == '|')
        totalTrue = ltrue * rtrue + lfalse * rtrue + ltrue * rfalse;

      ways += (result ? totalTrue : total - totalTrue);
    }

    map.put(result + s, ways);
    return ways;
  }
}
