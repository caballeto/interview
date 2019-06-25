package interviewbit.Hashing;

import java.util.*;

public class _find_substring {
  static ArrayList<Integer> result;

  public static ArrayList<Integer> findSubstring(String s, final List<String> list) {
    result = new ArrayList<>();
    int n = list.get(0).length();
    HashMap<String, Integer> set = new HashMap<>();

    for (String val : list) {
      if (set.containsKey(val)) {
        set.put(val, set.get(val) + 1);
      } else {
        set.put(val, 1);
      }
    }

    ArrayList<Integer> index = new ArrayList<>();
    for (int i = 0; i <= s.length() - n; i++) {
      String sub = s.substring(i, i + n);
      if (set.containsKey(sub)) {
        if (set.get(sub) == 1) {
          set.remove(sub);
          index.add(i);
          solve(index, s.substring(i + n), set, n);
          index.remove(index.size() - 1);
          set.put(sub, 1);
        } else {
          set.put(sub, set.get(sub) - 1);
          index.add(i);
          solve(index, s.substring(i + n), set, n);
          index.remove(index.size() - 1);
          set.put(sub, set.get(sub) + 1);
        }
      }
    }

    return result;
  }

  private static void solve(ArrayList<Integer> index, String s, Map<String, Integer> set, int n) {
    if (set.size() == 0) {
      result.add(index.get(0));
    } else if (s.length() >= n) {
      String sub = s.substring(0, n);
      if (set.containsKey(sub)) {
        if (set.get(sub) == 1) {
          set.remove(sub);
          solve(index, s.substring(n), set, n);
          set.put(sub, 1);
        } else {
          set.put(sub, set.get(sub) - 1);
          solve(index, s.substring(n), set, n);
          set.put(sub, set.get(sub) + 1);
        }
      }
    }
  }

  public static void main(String[] args) {
    System.out.println("Rsult: " + findSubstring("barfoothefoobarman", new ArrayList<>(Arrays.asList( "bar", "foo"))));
  }
}
