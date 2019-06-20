package interviewbit.Arrays;

import java.util.ArrayList;
import java.util.Comparator;

public class _merge_overlapping {
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

  public static ArrayList<Interval> merge(ArrayList<Interval> intervals) {
    intervals.sort(Comparator.comparingInt(a -> a.start));
    int i = 0, start, end;
    while (i < intervals.size() - 1) {
      Interval interval = intervals.get(i), next = intervals.get(i + 1);
      if (interval.end >= next.start) {
        start = interval.start;
        end = Math.max(interval.end, next.end);
        intervals.remove(i);
        intervals.remove(i);
        intervals.add(i, new Interval(start, end));
      } else i++;
    }

    return intervals;
  }

  public static void main(String[] args) {
    ArrayList<Interval> intervals = new ArrayList<>();

    merge(intervals);
    System.out.println(intervals);
  }
}
