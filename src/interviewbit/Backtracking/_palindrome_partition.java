package interviewbit.Backtracking;

import java.util.ArrayList;
import java.util.Comparator;

public class _palindrome_partition {
  private static final ListComparator LIST_COMPARATOR = new ListComparator();

  private static class ListComparator implements Comparator<ArrayList<String>> {
    @Override
    public int compare(ArrayList<String> o1, ArrayList<String> o2) {
      int size = Math.min(o1.size(), o2.size());

      for (int i = 0; i < size; i++) {
        if (o1.get(i).length() < o2.get(i).length()) {
          return -1;
        } else if (o1.get(i).length() > o2.get(i).length()) {
          return 1;
        }
      }

      return o1.size() - o2.size();
    }
  }

  public static ArrayList<ArrayList<String>> partition(String a) {
    return filter(backtrack(a, 0), a.length());
  }

  private static ArrayList<ArrayList<String>> backtrack(String s, int index) {
    ArrayList<ArrayList<String>> result = new ArrayList<>();
    for (int i = index; i < s.length(); i++) {
      for (int j = i + 1; j <= s.length(); j++) {
        String sub = s.substring(i, j);
        if (isPalindrome(sub)) {
          if (j == s.length()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(sub);
            result.add(list);
          } else {
            ArrayList<ArrayList<String>> r = backtrack(s, j);
            if (r.isEmpty()) continue;
            for (ArrayList<String> lists : r) lists.add(0, sub);
            result.addAll(r);
          }
        }
      }
    }

    return result;
  }

  private static ArrayList<ArrayList<String>> filter(ArrayList<ArrayList<String>> list, int len) {
    ArrayList<ArrayList<String>> result = new ArrayList<>();
    for (ArrayList<String> array : list)
      if (len(array) == len) result.add(array);
    result.sort(LIST_COMPARATOR);
    return result;
  }

  private static int len(ArrayList<String> list) {
    int len = 0;
    for (String s : list)
      len += s.length();
    return len;
  }

  private static boolean isPalindrome(String s) {
    for (int i = 0; i < s.length()/2; i++)
      if (s.charAt(i) != s.charAt(s.length() - i - 1)) return false;
    return true;
  }

  public static void main(String[] args) {
    System.out.println(partition("aab"));
  }
}
