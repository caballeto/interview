package interviewbit.Graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Queue;

public class _knight {
  private static class Point {
    int x;
    int y;

    Point(int x, int y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
      if (obj == this) return true;
      if (obj == null) return false;
      if (obj.getClass() != this.getClass()) return false;
      Point that = (Point) obj;
      return this.x == that.x && this.y == that.y;
    }

    @Override
    public int hashCode() {
      return Objects.hash(x, y);
    }
  }

  public static int knight(int n, int m, int x1, int y1, int x2, int y2) {
    if (!isValid(n, m, x1, y1) || !isValid(n, m, x2, y2)) return -1;
    Point source = new Point(x1, y1), dest = new Point(x2, y2);
    Queue<Point> queue = new ArrayDeque<>();
    queue.add(source);
    boolean[][] marked = new boolean[n][m];
    marked[source.x - 1][source.y - 1] = true;
    int distance = 0, count = 1, curr = 0;
    while (!queue.isEmpty()) {
      Point point = queue.poll();
      if (point.equals(dest)) return distance;
      count--;
      for (Point w : adj(point, n, m)) {
        if (!marked[w.x - 1][w.y - 1]) {
          curr++;
          marked[w.x - 1][w.y - 1] = true;
          queue.add(w);
        }
      }

      if (count == 0) {
        count = curr;
        curr = 0;
        distance++;
      }
    }

    return -1;
  }

  private static Iterable<Point> adj(Point point, int n, int m) {
    ArrayList<Point> points = new ArrayList<>();
    int x = point.x, y = point.y;
    if (isValid(n,m,x+2, y+1)) points.add(new Point(x+2, y+1));
    if (isValid(n,m,x+2, y-1)) points.add(new Point(x+2, y-1));
    if (isValid(n,m,x+1, y+2)) points.add(new Point(x+1, y+2));
    if (isValid(n,m,x+1, y-2)) points.add(new Point(x+1, y-2));
    if (isValid(n,m,x-2, y+1)) points.add(new Point(x-2, y+1));
    if (isValid(n,m,x-2, y-1)) points.add(new Point(x-2, y-1));
    if (isValid(n,m,x-1, y+2)) points.add(new Point(x-1, y+2));
    if (isValid(n,m,x-1, y-2)) points.add(new Point(x-1, y-2));
    return points;
  }

  private static boolean isValid(int n, int m, int x, int y) {
    return x >= 1 && x <= n && y >= 1 && y <= m;
  }

  public static void main(String[] args) {
    System.out.println(knight(4, 7, 2, 6, 2,4));
  }
}
