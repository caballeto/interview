package interviewbit.Hashing;

import java.util.HashSet;

public class _longest_norepeating {
  public static int lengthOfLongestSubstring(String s) {
    if (s.isEmpty()) return 0;
    int start = 0, index = 1, longest = 1;
    HashSet<Character> set = new HashSet<>();
    set.add(s.charAt(0));

    while (index < s.length()) {
      char c = s.charAt(index);
      if (set.contains(c)) {
        while (set.contains(c))
          set.remove(s.charAt(start++));
        set.add(c);
        index++;
      } else {
        set.add(c);
        index++;
        longest = Math.max(longest, index - start);
      }
    }

    return longest;
  }

  public static void main(String[] args) {
    System.out.println(lengthOfLongestSubstring("dadbc"));
  }
}
