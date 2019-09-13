package google;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class _string_permutations {
  static List<String> perms(String s) {
    if (s == null || s.isEmpty()) return new ArrayList<>();
    return toString(generate(toList(s)));
  }

  private static List<List<Character>> generate(List<Character> chars) {
    if (chars.size() == 0) {
      List<List<Character>> list = new ArrayList<>();
      list.add(new ArrayList<>());
      return list;
    }

    Character c = chars.remove(0);
    List<List<Character>> result = new ArrayList<>();
    List<List<Character>> perms = generate(chars);
    for (var perm : perms) {
      for (int i = 0; i <= perm.size(); i++) {
        List<Character> temp = new ArrayList<>(perm); // check for uniqueness here if there are duplicate characters
        temp.add(i, c);
        result.add(temp);
      }
    }

    return result;
  }

  private static List<String> toString(List<List<Character>> perms) {
    List<String> res = new ArrayList<>();
    for (List<Character> perm : perms) {
      StringBuilder builder = new StringBuilder();
      for (char c : perm) builder.append(c);
      res.add(builder.toString());
    }

    return res;
  }

  private static List<Character> toList(String s) {
    List<Character> list = new ArrayList<>();
    for (char c : s.toCharArray())
      list.add(c);
    return list;
  }

  public static void main(String[] args) {
    System.out.println(perms("abcd"));
  }
}
