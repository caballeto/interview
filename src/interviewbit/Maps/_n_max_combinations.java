package interviewbit.Maps;

import java.util.*;

// DONT WORK
public class _n_max_combinations {
  static class Entry {
    private int i;
    private int j;
    private int val;

    Entry(int i, int j, int val) {
      this.i = i;
      this.j = j;
      this.val = val;
    }

    @Override
    public boolean equals(Object obj) {
      if (obj == this) return true;
      if (obj == null) return false;
      if (obj.getClass() != this.getClass()) return false;
      Entry that = (Entry) obj;
      return that.i == this.i && that.j == this.j && that.val == this.val;
    }

    @Override
    public int hashCode() {
      return Objects.hash(i, j, val);
    }
  }

  public static ArrayList<Integer> solve(ArrayList<Integer> a, ArrayList<Integer> b) {
    if (a.isEmpty() || b.isEmpty()) return new ArrayList<>();
    a.sort(Comparator.naturalOrder());
    b.sort(Comparator.naturalOrder());

    PriorityQueue<Entry> queue = new PriorityQueue<>(Comparator.comparingInt(e -> e.val));

    int i = a.size() - 1, j = a.size() - 1;
    Entry last = new Entry(i, j, a.get(i) + b.get(j));
    queue.add(last);
    HashSet<Entry> set = new HashSet<>();
    set.add(last);
    int count = 0;
    ArrayList<Integer> result = new ArrayList<>();
    while (count < a.size()) {
      Entry e = queue.poll();
      System.out.println(e.val);
      result.add(e.val);
      count++;
        Entry left = new Entry(i - 1, j, a.get(i - 1) + b.get(j)), right = new Entry(i, j - 1, a.get(i) + b.get(j - 1));
      System.out.println("sum: " + (a.get(i - 1) + b.get(j)) + " " + (a.get(i) + b.get(j - 1)));
      if (!set.contains(left)) {
        set.add(left);
        queue.add(left);
        i--;
      }

      if (!set.contains(right)) {
        set.add(right);
        queue.add(right);
        j--;
      }
    }

    return result;
  }

  public static void main(String[] args) {
    System.out.println(solve(new ArrayList<>(Arrays.asList( 3, 2, 4, 2)), new ArrayList<>(Arrays.asList(4, 3, 1, 2))));
  }
}
