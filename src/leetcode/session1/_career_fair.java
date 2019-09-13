package leetcode.session1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class _career_fair {
  public static int maxEvents(int[] arrival, int[] durations) {
    IndexComparator comparator = new IndexComparator(arrival, durations);
    Integer[] index = comparator.index();
    Arrays.sort(index, comparator);

    int events = 0, maxEnd = Integer.MIN_VALUE;
    for (Integer i : index) {
      int arriveAt = arrival[i];
      int duration = durations[i];
      if (arriveAt >= maxEnd) {
        events++;
        maxEnd = arriveAt + duration;
      }
    }

    return events;
  }

  private static class IndexComparator implements Comparator<Integer> {
    int[] arrival;
    int[] durations;

    IndexComparator(int[] arrival, int[] durations) {
      this.arrival = arrival;
      this.durations = durations;
    }

    @Override
    public int compare(Integer o1, Integer o2) {
      int end1 = arrival[o1] + durations[o1], end2 = arrival[o2] + durations[o2];
      if (end1 != end2)
        return end1 - end2;
      return durations[o1] - durations[o2];
    }

    public Integer[] index() {
      Integer[] indexes = new Integer[arrival.length];
      for (int i = 0; i < arrival.length; i++)
        indexes[i] = i;
      return indexes;
    }
  }

  public static void main(String[] args) {
    System.out.println(maxEvents(new int[]{1, 3, 3, 5, 7}, new int[]{2, 2, 1, 2, 1}) == 4);
    System.out.println(maxEvents(new int[]{1, 2}, new int[]{7, 3}) == 1);
    System.out.println(maxEvents(new int[]{1, 3, 4, 6}, new int[]{4, 3, 3, 2}) == 2);
  }
}
