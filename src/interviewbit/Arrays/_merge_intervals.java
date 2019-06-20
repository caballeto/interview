package interviewbit.Arrays;

import java.util.ArrayList;

public class _merge_intervals {
  static class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }

    @Override
    public String toString() {
      return "(" + start + "," + end + ")";
    }
  }

  public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
    int minLeft = Integer.MAX_VALUE, maxRight = Integer.MIN_VALUE;
    int left = newInterval.start, right = newInterval.end;

    for (Interval interval : intervals) {
      if (left >= interval.start && left <= interval.end && interval.start < minLeft)
        minLeft = interval.start;
      if (right >= interval.start && right <= interval.end && interval.end > maxRight)
        maxRight = interval.end;
    }

    minLeft = (minLeft == Integer.MAX_VALUE) ? left : minLeft;
    maxRight = (maxRight == Integer.MIN_VALUE) ? right : maxRight;

    int i = 0;
    while (i < intervals.size()) {
      Interval interval = intervals.get(i);
      if (interval.start >= minLeft && interval.end <= maxRight)
        intervals.remove(i);
      else i++;
    }

    insertSorted(intervals, new Interval(minLeft, maxRight));
    return intervals;
  }

  private static void insertSorted(ArrayList<Interval> intervals, Interval interval) {
    if (intervals.size() == 0) intervals.add(interval);
    else if (interval.start > intervals.get(intervals.size() - 1).start) intervals.add(interval);
    else {
      for (int i = 0; i < intervals.size(); i++) {
        if (interval.start < intervals.get(i).start) {
          intervals.add(i, interval);
          break;
        }
      }
    }
  }

  public static void main(String[] args) {
    ArrayList<Interval> intervals = new ArrayList<>();
    intervals.add(new Interval(1, 2));
    intervals.add(new Interval(3, 5));
    intervals.add(new Interval(6, 7));
    intervals.add(new Interval(8, 10));
    intervals.add(new Interval(12, 16));

    insert(intervals, new Interval(4, 9));
    System.out.println(intervals);
  }
}
