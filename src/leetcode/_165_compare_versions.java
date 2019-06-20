package leetcode;

import java.util.HashMap;
import java.util.Map;

public class _165_compare_versions {
  public int compareVersion(String version1, String version2) {
    String[] a = version1.split("\\.");
    String[] b = version2.split("\\.");

    HashMap<Integer, Integer> map = new HashMap<>();

    for (Map.Entry entry : map.entrySet()) {

    }

    if (a.length > b.length) {
      return compare(a, b, 0);
    } else {
      return -compare(b, a, 0);
    }
  }

  private int compare(String[] a, String[] b, int i) {
    if (i == a.length) return 0;
    int v1 = Integer.parseInt(a[i]);

    if (i >= b.length) {
      if (v1 > 0) return 1;
      return compare(a, b, i + 1);
    } else {
      int v2 = Integer.parseInt(b[i]);

      if      (v1 > v2) return 1;
      else if (v1 < v2) return -1;
      else return compare(a, b, i + 1);
    }
  }

  public static void main(String[] args) {
    String v1 = "7.5.2.4";
    String v2 = "7.5.3";

    //System.out.println(new _165_compare_versions().compareVersion(v1, v2));
    System.out.println((char) 65);
    System.out.println("" + (char) (26 + 64));
  }
}
