package cracking_coding_interview.Arrays;

public class _1_5_oneWay {
  public static boolean oneway(String s1, String s2) {
    String max = (s1.length() > s2.length()) ? s1 : s2;
    String min = (s1.length() > s2.length()) ? s2 : s1;
    if (max.length() != min.length() && max.length() != min.length() + 1) return false;
    int front = 0, back = 0, i = 0, j = 0;
    while (i < max.length() && j < min.length()) {
      if (max.charAt(i) == min.charAt(j)) {
        front++;
        i++;
        j++;
      } else break;
    }

    i = max.length() - 1;
    j = min.length() - 1;
    while (i >= 0 && j >= 0) {
      if (max.charAt(i) == min.charAt(j)) {
        back++;
        i--;
        j--;
      } else break;
    }

    return front == max.length() || front + back + 1 == max.length();
  }

  public static void main(String[] args) {
    System.out.println(oneway("pale", "ple"));
    System.out.println(oneway("pales", "pale"));
    System.out.println(oneway("pale", "bale"));
    System.out.println(oneway("pale", "bake"));
  }
}
