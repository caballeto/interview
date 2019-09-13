package leetcode.session1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 187
public class _repeated_dna_seq {
  public static List<String> findRepeatedDnaSequences(String s) {
    if (s == null || s.length() <= 10) return new ArrayList<>();
    List<String> result = new ArrayList<>();
    Map<String, Integer> count = new HashMap<>();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < 10; i++) sb.append(s.charAt(i));
    count.put(sb.toString(), 1);

    for (int i = 10; i < s.length(); i++) {
      sb.deleteCharAt(0);
      sb.append(s.charAt(i));
      String val = sb.toString();

      if (count.containsKey(val)) {
        int repeatCount = count.get(val) + 1;
        if (repeatCount == 2)
          result.add(val);
        count.put(val, repeatCount);
      } else {
        count.put(val, 1);
      }
    }

    return result;
  }

  /*Faster solution, same idea
  public static List<String> findRepeatedDnaSequences(String s) {
    Set seen = new HashSet(), repeated = new HashSet();
    for (int i = 0; i + 9 < s.length(); i++) {
        String ten = s.substring(i, i + 10);
        if (!seen.add(ten))
            repeated.add(ten);
    }
    return new ArrayList(repeated);
  }

   */

  public static void main(String[] args) {
    System.out.println(findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
  }
}
