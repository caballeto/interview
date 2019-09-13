package google;

import java.util.ArrayList;
import java.util.Arrays;

public class _allocate_books {
  public static int books(ArrayList<Integer> books, int maxReaders) {
    int len = books.size();
    if (len < maxReaders) return -1;
    int total = 0, max = Integer.MIN_VALUE;
    for (int val : books) {
      total += val;
      max = Math.max(max, val);
    }

    int lo = max, hi = total;
    while (lo < hi) {
      int mid = lo + (hi - lo) / 2;
      System.out.println(lo + " : " + mid + " : " + hi);
      int requiredReaders = getRequiredReaders(books, mid);
      if (requiredReaders <= maxReaders) {
        hi = mid;
      } else {
        lo = mid + 1;
      }
    }

    return lo;
  }

  private static int getRequiredReaders(ArrayList<Integer> books, int maxPagesPerReader) {
    int total = 0;
    int readers = 1;
    for (int val : books) {
      total += val;
      if (total > maxPagesPerReader) {
        total = val;
        readers++;
      }
    }

    return readers;
  }

  public static void main(String[] args) {
    System.out.println(books(new ArrayList<>(Arrays.asList(12, 34, 67, 90)), 2));
  }
}
