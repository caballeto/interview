package cracking_coding_interview.Arrays;

public class _1_4_isPalindromPerm {
  public static boolean isPalindromPerm(String s) {
    if (s == null || s.length() == 0) return false;
    s = s.replaceAll(" ", "").toLowerCase();
    int[] counts = new int[26];
    for (int i = 0; i < s.length(); i++) {
      counts[s.charAt(i) - 'a']++;
    }

    boolean mChar = false;
    if (s.length() % 2 == 0) mChar = true;
    for (int count : counts) {
      if (count % 2 == 0) continue;
      else if (!mChar) mChar = true;
      else return false;
    }

    return true;
  }

  public static void main(String[] args) {
    System.out.println(isPalindromPerm("Tact Coa"));
  }
}
