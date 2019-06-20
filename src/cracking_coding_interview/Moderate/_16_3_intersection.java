package cracking_coding_interview.Moderate;

public class _16_3_intersection {
  static class Point {
    int x, y;

    Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  static class LineSegment {
    Point start, end;

    LineSegment(Point start, Point end) {
      this.start = start;
      this.end = end;
    }

    int A() {
      return end.x - start.x;
    }

    int B() {
      return end.y - start.y;
    }

    int C() {
      return start.x*end.y - end.x*start.y;
    }

    boolean inX(int x) {
      return x >= start.x && x <= end.x;
    }

    boolean inY(int y) {
      return y >= start.y && y <= end.y;
    }
  }

  public static Point intersect(LineSegment a, LineSegment b) {
    int div = b.A() * a.B() - a.A() * b.B();
    if (div == 0) return null;
    int x = (b.A()*a.C() - a.A()*b.C()) / div, y = (b.B()*a.C() - a.B()*b.C()) / div;
    if (a.inX(x) && b.inX(x) && a.inY(y) && b.inY(y))
      return new Point(x, y);
    else return null;
  }
}
