package interviewbit.Graphs;

import java.util.*;

public class _world_ladder {
  public static int ladderLength(String start, String end, ArrayList<String> dict) {
    if (start.equals(end)) return 1;
    Queue<String> queue = new ArrayDeque<>();
    queue.add(start);
    HashMap<String, String> edgeTo = new HashMap<>();
    edgeTo.put(start, "");
    while (!queue.isEmpty()) {
      String word = queue.poll();

      if (word.equals(end) || diff(word, end) == 1) {
        int c = (word.equals(end)) ? 0 : 1;
        edgeTo.put(end, word);
        String key = end;
        while (!edgeTo.get(key).equals(start)) {
          key = edgeTo.get(key);
          c++;
        }

        return c + 1;
      }

      for (String w : adj(word, dict)) {
        if (!edgeTo.containsKey(w)) {
          queue.add(w);
          edgeTo.put(w, word);
        }
      }
    }

    return 0;
  }

  private static Iterable<String> adj(String word, ArrayList<String> dict) {
    ArrayList<String> next = new ArrayList<>();
    for (String s : dict) {
      if (diff(s, word) == 1) {
        next.add(s);
      }
    }

    return next;
  }

  private static int diff(String a, String b) {
    int count = 0;
    for (int i = 0; i < a.length(); i++) {
      if (a.charAt(i) != b.charAt(i)) {
        count++;
      }
    }

    return count;
  }

  public static void main(String[] args) {
    System.out.println(ladderLength("hit", "cog", new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log"))));
  }
}
