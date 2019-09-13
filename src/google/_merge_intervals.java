package google;


import java.util.ArrayList;

public class _merge_intervals {
  static class Interval {
    int start, end;

    Interval(int start, int end) {
      this.start = start;
      this.end = end;
    }
  }

  public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval current) {
    if (intervals == null || current == null) return new ArrayList<>();
    ArrayList<Interval> result = new ArrayList<>();
    boolean inserted = false;
    for (int i = 0; i < intervals.size(); i++) {
      Interval interval = intervals.get(i);
      if (inserted || interval.end < current.start) {
        result.add(interval);
      } else if (overlap(current, interval)) {
        current = new Interval(Math.min(current.start, interval.start), Math.max(current.end, interval.end));
      } else if (current.end < interval.start) {
        result.add(current);
        inserted = true;
        result.add(interval);
      }
    }

    if (!inserted)
      result.add(current);

    return result;
  }

  private static boolean overlap(Interval a, Interval b) {
    return (a.start >= b.start && a.start <= b.end) || (a.end >= b.start && a.end <= b.end)
      || (a.start < b.start && a.end > b.end);
  }
}
