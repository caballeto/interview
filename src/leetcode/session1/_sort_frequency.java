package leetcode.session1;

import java.util.*;

public class _sort_frequency {
  static class Pair implements Comparable<Pair> {
    char c;
    int freq;

    Pair(char c, int freq) {
      this.c = c;
      this.freq = freq;
    }

    @Override
    public boolean equals(Object obj) {
      if (obj == null) return false;
      if (obj == this) return true;
      if (obj.getClass() != this.getClass()) return false;
      Pair that = (Pair) obj;
      return this.c == that.c && this.freq == that.freq;
    }

    @Override
    public int hashCode() {
      return Objects.hash(c, freq);
    }

    @Override
    public int compareTo(Pair o) {
      return freq - o.freq;
    }
  }

  public static String frequencySort(String s) {
    if (s == null || s.length() <= 2) return s;
    int[] chars = new int[256];

    for (char c : s.toCharArray())
      chars[c]++;

    PriorityQueue<Character> pq = new PriorityQueue<>(s.length(), new Comparator<Character>() {
      @Override
      public int compare(Character c1, Character c2) {
        return chars[c2] - chars[c1];
      }
    });

    for (int i = 0; i < 256; i++)
      if (chars[i] != 0) pq.offer((char) i);

    StringBuilder sb = new StringBuilder();
    while (!pq.isEmpty()) {
      char c = pq.poll();
      int count = chars[c];
      for (int i = 0; i < count; i++)
        sb.append(c);
    }

    return sb.toString();
  }

  public static void main(String[] args) {
    System.out.println(frequencySort("tree"));
    System.out.println(frequencySort("cccaaa"));
    System.out.println(frequencySort("Aabb"));
  }
}
