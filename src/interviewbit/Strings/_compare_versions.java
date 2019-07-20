package interviewbit.Strings;

public class _compare_versions {
  public static int compareVersion(String v1, String v2) {
    String[] p1 = v1.split("\\."), p2 = v2.split("\\.");
    int size = Math.min(p1.length, p2.length);
    for (int i = 0; i < size; i++) {
      int comp = compare(p1[i], p2[i]);
      if (comp == 1 || comp == -1) {
        return comp;
      }
    }

    if (p1.length == p2.length) return 0;
    else if (p1.length > p2.length) {
      if (zero(p1, size)) return 0;
      return 1;
    } else {
      if (zero(p2, size)) return 0;
      return -1;
    }
  }

  private static String removeZeros(String s) {
    if (s.isEmpty()) return s;
    int i = 0;
    while (i < s.length() - 1 && s.charAt(i) == '0') i++;
    return s.substring(i);
  }

  private static int compare(String v1, String v2) {
    v1 = removeZeros(v1);
    v2 = removeZeros(v2);
    if (v1.length() > v2.length()) return 1;
    if (v2.length() > v1.length()) return -1;

    for (int i = 0; i < v1.length(); i++) {
      if      (v1.charAt(i) > v2.charAt(i)) return 1;
      else if (v1.charAt(i) < v2.charAt(i)) return -1;
    }

    return 0;
  }

  private static boolean zero(String[] p, int size) {
    for (int i = size; i < p.length; i++) {
      for (int j = 0; j < p[i].length(); j++) {
        if (p[i].charAt(j) != '0') return false;
      }
    }

    return true;
  }

  public static void main(String[] args) {
    System.out.println(compareVersion("0.1", "1.1"));
    System.out.println(compareVersion("1.3.4", "1.3.4.7"));
    System.out.println(compareVersion("1.3.4", "1.3.4"));
    System.out.println(compareVersion("4444371174137455", "5.168"));
  }
}
