package interviewbit.Dp;

import java.util.HashMap;

@SuppressWarnings("Duplicates")
public class _eval_true {
  public static int cnttrue(String s) {
    return eval(s, true, new HashMap<>());
  }

  private static int eval(String s, boolean result, HashMap<String, Integer> map) {
    if (s.isEmpty()) return 0;
    if (s.length() == 1) return (result) ? (s.equals("T") ? 1 : 0) : (s.equals("F") ? 1 : 0);
    if (map.containsKey(result + s)) return map.get(result + s);

    int ways = 0;
    for (int i = 1; i < s.length(); i += 2) {
      char c = s.charAt(i);
      String left = s.substring(0, i), right = s.substring(i + 1);
      int ltrue = eval(left, true, map), lfalse = eval(left, false, map);
      int rtrue = eval(right, true, map), rfalse = eval(right, false, map);
      int total = ((ltrue + lfalse) * (rtrue + rfalse)) % 1003, totalTrue = 0;

      if (c == '^')
        totalTrue = (ltrue * rfalse + lfalse * rtrue) % 1003;
      else if (c == '&')
        totalTrue = ltrue * rtrue % 1003;
      else if (c == '|')
        totalTrue = (ltrue * rtrue + ltrue * rfalse + lfalse * rtrue) % 1003;

      ways += (result ? totalTrue : total - totalTrue) % 1003;
    }

    map.put(result + s, ways);
    return ways % 1003;
  }

  public static void main(String[] args) {
    System.out.println(cnttrue("F|T"));
  }
}
