package interviewbit.TwoPointers;

import java.util.ArrayList;

public class _continuous_series {
  public static ArrayList<Integer> maxone(ArrayList<Integer> list, int M) {
    ArrayList<Range> ranges = new ArrayList<>();
    boolean cur = false;
    int start = 0, len = 0;
    int i = 0;

    while (i < list.size()) {
      if (list.get(i) == 1) {
        if (cur) {
          len++;
        } else {
          cur = true;
          start = i;
          len = 1;
        }
      } else {
        if (cur) {
          ranges.add(new Range(start, len));
          cur = false;
        }
      }

      i++;
    }

    if (cur) ranges.add(new Range(start, len));

    if (ranges.isEmpty()) return new ArrayList<>();
    if (ranges.size() == 1) {
      Range range = ranges.get(0);

      if (range.start + range.len < list.size()) {
        int maxStart = range.start, maxEnd = Math.min(range.start + range.len + M, list.size() - 1);
        ArrayList<Integer> index = new ArrayList<>();
        for (int j = maxStart; j <= maxEnd; j++)
          index.add(j);
        return index;
      }
    }


    int max = Integer.MIN_VALUE, maxStart = -1, maxEnd = -1;
    for (int j = 0; j < ranges.size() - 1; j++) {
      Range a = ranges.get(j), b = ranges.get(j + 1);
      if (b.start - (a.start + a.len) <= M) {
        max = Math.max(max, a.len + M + b.len);
        maxStart = a.start;
        maxEnd = b.start + b.len - 1;
      }
    }

    maxStart = (maxStart == -1) ? ranges.get(0).start : maxStart;
    maxEnd = (maxEnd == -1) ? ranges.get(0).start + ranges.get(0).len - 1 : maxEnd;

    ArrayList<Integer> index = new ArrayList<>();
    for (int j = maxStart; j <= maxEnd; j++)
      index.add(j);
    return index;
  }

  private static class Range {
    int start, len;

    Range(int start, int len) {
      this.start = start;
      this.len = len;
    }
  }
}
