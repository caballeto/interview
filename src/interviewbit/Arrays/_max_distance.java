package interviewbit.Arrays;

import java.util.*;

public class _max_distance {
  public static int maximumGap(final List<Integer> list) {
    if (list.isEmpty()) return -1;
    if (list.size() == 1) return 0;
    IndexComparator comparator = new IndexComparator(list);
    Integer[] index = comparator.index();
    Arrays.sort(index, comparator);
    Collections.sort(list);

    int[] max = new int[list.size()];
    max[max.length - 1] = index[index.length - 1];
    for (int i = index.length - 2; i >= 0; i--) {
      max[i] = Math.max(max[i + 1], index[i]);
    }

    int res = Integer.MIN_VALUE;
    for (int i = 1; i < index.length; i++) {
      res = Math.max(res, max[i] - index[i - 1]);
    }

    if (res < 0) return 0;
    return res;
  }

  private static class IndexComparator implements Comparator<Integer> {
    final List<Integer> list;

    public IndexComparator(List<Integer> list) {
      this.list = list;
    }

    public Integer[] index() {
      Integer[] indexes = new Integer[list.size()];
      for (int i = 0; i < indexes.length; i++) {
        indexes[i] = i;
      }

      return indexes;
    }

    @Override
    public int compare(Integer o1, Integer o2) {
      return list.get(o1).compareTo(list.get(o2));
    }
  }

  public static void main(String[] args) {
    List<Integer> list = new ArrayList<>(Arrays.asList( 3, 2, 1));
    System.out.println(maximumGap(list));
  }
}
