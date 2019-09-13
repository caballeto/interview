package leetcode.session1;

import java.util.Arrays;

public class _reorder_logs {
  public static String[] reorderLogFiles(String[] logs) {
    if (logs == null || logs.length == 0) return new String[0];
    int i = logs.length - 1, j = logs.length - 1;

    while (i >= 0 && i <= j) {
      if (isDigitLog(logs[i]))
        swap(logs, i--, j--);
      else i--;
    }

    Arrays.sort(logs, 0, j + 1, (o1, o2) -> {
      String s1 = o1.substring(o1.indexOf(" ") + 1);
      String s2 = o2.substring(o2.indexOf(" ") + 1);
      return s1.equals(s2) ? o1.compareTo(o2) : s1.compareTo(s2);
    });

    return logs;
  }

  private static boolean isDigitLog(String s) {
    return Character.isDigit(s.charAt(s.length() - 1));
  }

  private static void swap(String[] logs, int i, int j) {
    String temp = logs[i];
    logs[i] = logs[j];
    logs[j] = temp;
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(reorderLogFiles(new String[]{"a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo"})));

  }
}
