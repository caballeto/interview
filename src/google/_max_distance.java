package google;

import java.util.*;

public class _max_distance {
  public static int maximumGap(final List<Integer> list) {
    if (list == null || list.isEmpty()) return -1;
    if (list.size() == 1) return 0;

    IndexComparator comparator = new IndexComparator(list);
    Integer[] index = comparator.index();
    Arrays.sort(index, comparator);

    int max = 0;
    PriorityQueue<Integer> minPQ = new PriorityQueue<>(Comparator.comparingInt(a -> a)),
      maxPQ = new PriorityQueue<>((a, b) -> b - a);

    minPQ.add(index[0]);
    for (int i = 1; i < index.length; i++)
      maxPQ.add(index[i]);

    for (int i = 1; i < index.length; i++) {
      int num = index[i];
      max = Math.max(max, maxPQ.peek() - minPQ.peek());
      maxPQ.remove(num);
      minPQ.add(num);
    }

    return max;
  }

  private static class IndexComparator implements Comparator<Integer> {
    private List<Integer> list;

    IndexComparator(List<Integer> list) {
      this.list = list;
    }

    Integer[] index() {
      Integer[] index = new Integer[list.size()];
      for (int i = 0; i < index.length; i++)
        index[i] = i;
      return index;
    }

    @Override
    public int compare(Integer o1, Integer o2) {
      return list.get(o1).compareTo(list.get(o2));
    }
  }

  public static void main(String[] args) {
    System.out.println(maximumGap(new ArrayList<>(Arrays.asList(1, 10))));
  }
}
