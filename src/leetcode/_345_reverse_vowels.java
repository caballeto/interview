package leetcode;

import java.util.ArrayList;

public class _345_reverse_vowels {
  public String reverseVowels(String s) {
    ArrayList<Integer> indices = new ArrayList<>();
    StringBuilder builder = new StringBuilder(s);
    for (int i = 0; i < s.length(); i++) {
      char c = builder.charAt(i);
      switch (c) {
        case 'a': case 'e': case 'i': case 'o': case 'u':
        case 'A': case 'E': case 'I': case 'O': case 'U':
          indices.add(i); break;
      }
    }

    for (int i = 0; i < indices.size()/2; i++) {
      int index1 = indices.get(i), index2 = indices.get(indices.size() - i - 1);
      char temp = builder.charAt(index1);
      builder.setCharAt(index1, builder.charAt(index2));
      builder.setCharAt(index2, temp);
    }

    return builder.toString();
  }
}
