package cracking_coding_interview.Sorting;

import java.util.*;

public class _10_2_groupAnagrams {
  // Leetcode 49
  public static List<List<String>> groupAnagrams(String[] strs) {
    String[] aux = new String[strs.length];
    HashMap<String, List<String>> groups = new HashMap<>();
    for (int i = 0; i < strs.length; i++) {
      char[] chars = strs[i].toCharArray();
      Arrays.sort(chars);
      aux[i] = new String(chars);
      if (groups.containsKey(aux[i])) {
        groups.get(aux[i]).add(strs[i]);
      } else {
        List<String> list = new ArrayList<>();
        list.add(strs[i]);
        groups.put(aux[i], list);
      }
    }

    // or: return new ArrayList<>(groups.values());
    List<List<String>> result = new ArrayList<>();
    for (Map.Entry<String, List<String>> entry : groups.entrySet()) {
      result.add(entry.getValue());
    }

    return result;
  }

  public static void main(String[] args) {
    String[] strings = {"eat", "tea", "tan", "ate", "nat", "bat"};
    System.out.println(groupAnagrams(strings));
  }
}
