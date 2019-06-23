package interviewbit.Backtracking;

import java.util.*;

public class _letter_phone {
  private static HashMap<Integer, ArrayList<String>> map = initMap();

  private static HashMap<Integer, ArrayList<String>> initMap() {
    map = new HashMap<>();
    ArrayList<String> zero = new ArrayList<>(), one = new ArrayList<>();
    zero.add("0");
    one.add("1");
    map.put(0, zero);
    map.put(1, one);
    map.put(2, new ArrayList<>(Arrays.asList("a", "b", "c")));
    map.put(3, new ArrayList<>(Arrays.asList("d", "e", "f")));
    map.put(4, new ArrayList<>(Arrays.asList("g", "h", "i")));
    map.put(5, new ArrayList<>(Arrays.asList("j", "k", "l")));
    map.put(6, new ArrayList<>(Arrays.asList("m", "n", "o")));
    map.put(7, new ArrayList<>(Arrays.asList("p", "q", "r", "s")));
    map.put(8, new ArrayList<>(Arrays.asList("t", "u", "v")));
    map.put(9, new ArrayList<>(Arrays.asList("w", "x", "y", "z")));
    return map;
  }

  public static ArrayList<String> letterCombinations(String s) {
    if (s.isEmpty()) return new ArrayList<>();
    if (s.length() == 1) return map.get(s.charAt(0) - '0');
    ArrayList<String> list = combine(map.get(s.charAt(0) - '0'), map.get(s.charAt(1) - '0'));
    for (int i = 2; i < s.length(); i++)
      list = combine(list, map.get(s.charAt(i) - '0'));
    list.sort(Comparator.naturalOrder());
    return list;
  }

  private static ArrayList<String> combine(ArrayList<String> a, ArrayList<String> b) {
    HashSet<String> combined = new HashSet<>();
    for (String sa : a) {
      for (String sb : b) {
        combined.add(sa + sb);
      }
    }

    return new ArrayList<>(combined);
  }
}