package leetcode.session1;

import java.util.*;

public class _min_difference {
  private static final int FULL_DAY = 24 * 60;

  public static int findMinDifference(List<String> points) {
    if (points == null || points.size() < 2) return 0;
    Collections.sort(points);
    int minDiff = diff(points.get(0), points.get(points.size() - 1));
    for (int i = 0; i < points.size() - 1; i++)
      minDiff = Math.min(minDiff, diff(points.get(i), points.get(i + 1)));
    return minDiff;
  }

  private static int getTotal(String point) {
    return 60 * getHours(point) + getMinutes(point);
  }

  private static int getHours(String point) {
    return (point.charAt(0) - '0') * 10 + (point.charAt(1) - '0');
  }

  private static int getMinutes(String point) {
    return (point.charAt(3) - '0') * 10 + (point.charAt(4) - '0');
  }

  private static int diff(String p1, String p2) {
    int val1 = getTotal(p1), val2 = getTotal(p2);
    return Math.min(Math.abs(val1 - val2), Math.abs(val1 + (FULL_DAY - val2)));
  }

  public static void main(String[] args) {
    System.out.println(findMinDifference(new ArrayList<>(Arrays.asList("00:00", "23:59","00:00"))));
  }
}
