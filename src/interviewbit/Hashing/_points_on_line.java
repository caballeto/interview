package interviewbit.Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class _points_on_line {
  static class Point {
    double x;
    double y;

    Point(double x, double y) {
      this.x = x;
      this.y = y;
    }

    double slopeTo(Point that) {
      if (that.x == this.x && that.y == this.y) return Integer.MIN_VALUE;
      if (that.y == this.y) return 0;
      if (that.x == this.x) return Integer.MAX_VALUE;
      return (that.y - this.y) / (that.x - this.x);
    }

    Comparator<Point> slopeOrder() {
      return (Point o1, Point o2) -> {
        double diff = Point.this.slopeTo(o1) - Point.this.slopeTo(o2);
        if      (diff < 0) return -1;
        else if (diff > 0) return 1;
        else               return 0;
      };
    }

    @Override
    public String toString() {
      return "(" + x + "," + y + ")";
    }
  }

  public static int maxPoints(ArrayList<Integer> a, ArrayList<Integer> b) {
    if (a.size() == 0 || a.size() == 1) return a.size();
    int longest = Integer.MIN_VALUE;
    Point[] points = new Point[a.size()];
    for (int i = 0; i < a.size(); i++) {
      points[i] = new Point(a.get(i), b.get(i));
    }

    for (int i = 0; i < a.size(); i++) {
      Point point = new Point(a.get(i), b.get(i));
      Arrays.sort(points, point.slopeOrder());
      int count = 2;
      double slope = point.slopeTo(points[1]);
      for (int j = 2; j < points.length; j++) {
        if (point.slopeTo(points[j]) == slope) {
          count++;
        } else {
          longest = Math.max(longest, count);
          slope = point.slopeTo(points[j]);
          count = 2;
        }
      }

      longest = Math.max(longest, count);
    }

    return longest;
  }

  public static void main(String[] args) {
    ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1)),
      b = new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1));
    System.out.println(maxPoints(a, b));
    //System.out.println(new Point(-6, -17).slopeTo(new Point(5, -13)));
  }
}
