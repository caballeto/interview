package interviewbit.Graphs;

import java.util.*;

public class _world_ladder2 {
  @SuppressWarnings("Duplicates")
  public static ArrayList<ArrayList<String>> findLadders(String start, String end, ArrayList<String> dict) {
    if (start.equals(end)) return new ArrayList<>(Arrays.asList(new ArrayList<>(Arrays.asList(start))));

    Queue<String> queue = new ArrayDeque<>();
    queue.add(start);
    HashMap<String, ArrayList<String>> edgeTo = new HashMap<>();
    edgeTo.put(start, new ArrayList<>(Arrays.asList("")));
    HashMap<String, Integer> distTo = new HashMap<>();
    distTo.put(start, 0);

    while (!queue.isEmpty()) {
      String word = queue.poll();
      if (diff(word, end) == 1) {
        if (edgeTo.containsKey(end) && distTo.get(word) == distTo.get(end) - 1) {
          edgeTo.get(end).add(word);
        } else if (!edgeTo.containsKey(end)) {
          ArrayList<String> list = new ArrayList<>();
          list.add(word);
          edgeTo.put(end, list);
          distTo.put(end, distTo.get(word) + (word.equals(end) ? 0 : 1));
        }
      }

      for (String w : adj(word, dict)) {
        if (!edgeTo.containsKey(w)) {
          queue.add(w);
          distTo.put(w, distTo.get(word) + 1);
          ArrayList<String> list = new ArrayList<>();
          list.add(word);
          edgeTo.put(w, list);
        } else if (!edgeTo.get(w).contains(word) && distTo.get(w) == distTo.get(word) + 1) {
          edgeTo.get(w).add(word);
        }
      }
    }

    if (edgeTo.containsKey(end)) {
      return new ArrayList<>(new HashSet<>(combine(edgeTo, start, end)));
    } else {
      return new ArrayList<>();
    }
  }

  private static ArrayList<ArrayList<String>> combine(Map<String, ArrayList<String>> map, String start, String end) {
    if (end.equals(start)) return new ArrayList<>(Arrays.asList(new ArrayList<>(Arrays.asList(start))));
    ArrayList<ArrayList<String>> list = new ArrayList<>();
    for (String s : map.get(end)) {
      ArrayList<ArrayList<String>> combinations = combine(map, start, s);
      for (ArrayList<String> comb : combinations) {
        comb.add(end);
        list.add(comb);
      }
    }

    return list;
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

  private static ArrayList<String> toSetList(String[] parts) {
    ArrayList<String> list = new ArrayList<>();
    for (int i = 0; i < parts.length - 2; i++) {
      list.add(parts[i]);
    }
    return new ArrayList<>(new HashSet<>(list));
  }

  public static void main(String[] args) {
    String[] parts = "bb aa bb ba ab aa ab bb aa aa ab bb ba aa ba ab ba ab ab aa bb ab aa aa ba bb ab ba ab aa aa aa ba ab ab aa aa ab ba ba bb".split(" ");
    String start = "ba", end = "bb";
    System.out.println(findLadders("ba", "bb", toSetList(parts)));
    //ArrayList<String> words = new ArrayList<>(new HashSet<>(new ArrayList<>(Arrays.asList("bb aa bb ba ab aa ab bb aa aa ab bb ba aa ba ab ba ab ab aa bb ab aa aa ba bb ab ba ab aa aa aa ba ab ab aa aa ab ba ba bb".split(" ")))))
    //System.out.println(findLadders("hit", "cog", new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log"))));
  }
}
