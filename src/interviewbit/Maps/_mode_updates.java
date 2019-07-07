package interviewbit.Maps;

import java.util.*;

public class _mode_updates {
  private static class Entry implements Comparable<Entry> {
    int value;
    int count;

    Entry(int value, int count) {
      this.value = value;
      this.count = count;
    }

    @Override
    public int compareTo(Entry o) {
      if (this.count != o.count)
        return this.count - o.count;
      return o.value - this.value;
    }

    @Override
    public int hashCode() {
      return Objects.hash(value, count);
    }
  }

  public static ArrayList<Integer> getMode(ArrayList<Integer> array, ArrayList<ArrayList<Integer>> updates) {
    HashMap<Integer, Entry> count = new HashMap<>();
    Comparator<Entry> comparator = (a, b) -> {
      if (a.count != b.count)
        return a.count - b.count;
      return b.value - a.value;
    };

    PriorityQueue<Entry> queue = new PriorityQueue<>(comparator.reversed());

    for (int val : array) {
      if (count.containsKey(val)) {
        count.get(val).count++;
      } else {
        Entry entry = new Entry(val, 1);
        count.put(val, entry);
      }
    }

    queue.addAll(count.values());
    ArrayList<Integer> result = new ArrayList<>();
    for (ArrayList<Integer> update : updates) {
      int index = update.get(0) - 1;
      int updatedVal = array.get(index), newVal = update.get(1);

      Entry e = count.get(updatedVal);
      if (e.value != newVal) {
        if (e.count == 1) {
          queue.remove(e);
          count.remove(e.value);
        } else {
          e.count--;
          queue.remove(e);
          queue.add(e);
        }

        if (count.containsKey(newVal)) {
          Entry entry = count.get(newVal);
          entry.count++;
          queue.remove(entry);
          queue.add(entry);
        } else {
          Entry entry = new Entry(newVal, 1);
          count.put(newVal, entry);
          queue.add(entry);
        }
      }

      array.set(index, newVal);
      result.add(queue.peek().value);
    }

    return result;
  }

  public static void main(String[] args) {
    ArrayList<Integer> array = new ArrayList<>(Arrays.asList(1, 1, 2, 3, 3));
    ArrayList<ArrayList<Integer>> updates = new ArrayList<>(Arrays.asList(
      new ArrayList<>(Arrays.asList(2, 3)),
      new ArrayList<>(Arrays.asList(5, 3)),
      new ArrayList<>(Arrays.asList(3, 3)),
      new ArrayList<>(Arrays.asList(3, 2)),
      new ArrayList<>(Arrays.asList(1, 1)))
    );
    System.out.println(getMode(array, updates));
  }
}
