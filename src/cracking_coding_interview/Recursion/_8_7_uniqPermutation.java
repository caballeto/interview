package cracking_coding_interview.Recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class _8_7_uniqPermutation {
  // works for len(s) <= 31
  public static List<String> permutations(String s) {
    if (s.length() == 0) return new ArrayList<>();
    HashSet<Character> charsSet = new HashSet<>();
    for (int i = 0; i < s.length(); i++) charsSet.add(s.charAt(i));
    List<Character> chars = new ArrayList<>(charsSet);
    List<String> res = new ArrayList<>();
    int size = charsSet.size(), total = 1 << size;
    for (int i = 0; i < total; i++) {
      StringBuilder builder = new StringBuilder();
      for (int j = 0; j < chars.size(); j++)
        if (((i >> j) & 1) == 1) builder.append(chars.get(j));
      res.add(builder.toString());
    }
    return res;
  }
}
