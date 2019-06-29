package interviewbit.Trees;

import java.util.*;

public class _hotel_reviews {
  static class Entry {
    String value;
    int count;
    int index;

    Entry(String value, int count, int index) {
      this.value = value;
      this.count = count;
      this.index = index;
    }

    @Override
    public String toString() {
      return value + " (" + count + "," + index + ")";
    }
  }

  public static ArrayList<Integer> solve(String s, ArrayList<String> list) {
    String[] parts = s.split("_");
    Set<String> good = new HashSet<>();
    Collections.addAll(good, parts);
    Entry[] entries = new Entry[list.size()];
    int i = 0;
    for (String review : list) {
      int count = 0;
      for (String word : review.split("_"))
        if (good.contains(word)) count++;
      entries[i] = new Entry(review, count, i);
      i++;
    }

    Arrays.sort(entries, Comparator.comparingInt((Entry e) -> e.count).reversed());
    ArrayList<Integer> index = new ArrayList<>();
    for (Entry e : entries) index.add(e.index);
    return index;
  }

  public static void main(String[] args) {
    System.out.println(solve("cool_ice_wifi", new ArrayList<>(Arrays.asList("water_is_cool", "cold_ice_drink", "cool_wifi_speed"))));
  }
}
