package leetcode;

public class _316_remove_duplicate {
  public String removeDuplicateLetters(String s) {
    int[] cnt = new int[26];
    int pos = 0;
    for (int i = 0; i < s.length(); i++) cnt[s.charAt(i) - 'a']++;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) < s.charAt(pos)) pos = i;
      if (--cnt[s.charAt(i) - 'a'] == 0) break;
    }

    return s.length() == 0 ? "" : s.charAt(pos) + removeDuplicateLetters(s.substring(pos + 1).replaceAll("" + s.charAt(pos), ""));
  }

  public static void main(String[] args) {
    String s = "abacb";
    System.out.println(new _316_remove_duplicate().removeDuplicateLetters(s));
  }
}
