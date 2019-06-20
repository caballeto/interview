package interviewbit.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class _triplet_sum {
  public static int solve(ArrayList<String> list) {
    ArrayList<Double> a = new ArrayList<>(), b = new ArrayList<>(), c = new ArrayList<>(); // a (0, 2/3); b (2/3, 1); c (1, 2)

    for (String s : list) {
      double val = Double.parseDouble(s);
      if      (val > 0 && val < 2/3.)   a.add(val);
      else if (val >= 2/3. && val <= 1) b.add(val);
      else if (val >= 1 && val < 2)     c.add(val);
    }

    if (a.size() >= 3 && range(max3(a), 1, 2)) return 1;
    if (a.size() >= 2 && b.size() >= 1 && solve2(a, b)) return 1;
    if (a.size() >= 2 && c.size() >= 1 && range(min2(a) + min(c), 1, 2)) return 1;
    if (b.size() >= 2 && c.size() >= 1 && range(min2(b) + min(c), 1, 2)) return 1;
    if (b.size() >= 2 && a.size() >= 1 && range(min2(b) + min(a), 1, 2)) return 1;
    if (a.size() >= 1 && b.size() >= 1 && c.size() >= 1 && range(min(a) + min(b) + min(c), 1, 2)) return 1;

    return 0;
  }

  private static boolean solve2(ArrayList<Double> a, ArrayList<Double> b) {
    ArrayList<Double> b1 = new ArrayList<>(), b2 = new ArrayList<>();

    for (double val : a) {
      if (val < 1/3.) b1.add(val);
      else b2.add(val);
    }

    if (b1.size() >= 1 && b2.size() >= 1 && range(min(b1) + min(b2) + min(b), 1, 2)) return true;
    if (b2.size() >= 2 && range(min2(b2) + min(b), 1, 2)) return true;
    if (b1.size() >= 2 && range(max2(b1) + min(b), 1, 2)) return true;

    return false;
  }

  private static double max3(ArrayList<Double> list) {
    list.sort(Comparator.reverseOrder());
    return list.get(0) + list.get(1) + list.get(2);
  }

  private static double max2(ArrayList<Double> list) {
    list.sort(Comparator.reverseOrder());
    return list.get(0) + list.get(1);
  }

  private static double min2(ArrayList<Double> list) {
    list.sort(Comparator.naturalOrder());
    return list.get(0) + list.get(1);
  }

  private static boolean range(double val, double a, double b) {
    return val > a && val < b;
  }

  private static double min(ArrayList<Double> list) {
    return Collections.min(list);
  }

  public static void main(String[] args) {
    ArrayList<String> list = new ArrayList<>(Arrays.asList("2.671613", "1.239175", "2.575260", "0.021242", "1.894100", "0.148016", "0.341571"));
    System.out.println(solve(list));
  }
}
