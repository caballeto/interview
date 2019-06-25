package interviewbit.Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class _anagrams {
  public static ArrayList<ArrayList<Integer>> anagrams(final List<String> list) {
    HashMap<ArrayList<Character>, ArrayList<Integer>> index = new HashMap<>();

    for (int i = 0; i < list.size(); i++) {
      String s = list.get(i);
      ArrayList<Character> chars = toList(s.toCharArray());
      chars.sort(Character::compareTo);
      if (index.containsKey(chars)) {
        index.get(chars).add(i + 1);
      } else {
        ArrayList<Integer> l = new ArrayList<>();
        l.add(i + 1);
        index.put(chars, l);
      }
    }

    return new ArrayList<>(index.values());
  }

  private static ArrayList<Character> toList(char[] chars) {
    ArrayList<Character> characters = new ArrayList<>();
    for (char c : chars) characters.add(c);
    return characters;
  }
}
