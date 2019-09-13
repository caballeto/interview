package leetcode.session1;

import java.util.*;

public class _word_ladder2 {
  static List<List<String>> finalResult;

  public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    if (beginWord == null || endWord == null || wordList == null || !wordList.contains(endWord))
      return new ArrayList<>();

    Set<String> used = new HashSet<>();
    Map<String, List<String>> edges = new HashMap<>();
    Map<String, Integer> dists = new HashMap<>();

    Queue<Pair> q = new LinkedList<>();
    q.add(new Pair(beginWord, 0));

    while (!q.isEmpty()) {
      Pair pair = q.poll();
      List<String> adj = getAdj(pair.word, wordList);
      for (String word : adj) {
        if (edges.containsKey(word) && dists.get(word) == 1 + pair.distance) {
          edges.get(word).add(pair.word);
        }

        if (!used.contains(word)) {
          q.add(new Pair(word, 1 + pair.distance));
          if (!dists.containsKey(word))
            dists.put(word, 1 + pair.distance);
          used.add(word);
          edges.put(word, new ArrayList<>(Arrays.asList(pair.word)));
        }
      }
    }

    System.out.println(edges);
    List<List<String>> result = new ArrayList<>();
    dfs(beginWord, endWord, used, edges, dists, new ArrayList<>(), result);
    return result;
  }

  private static void dfs(String cur, String end, Set<String> dict, Map<String, List<String>> edges, Map<String, Integer> distance, List<String> solution, List<List<String>> res) {
    solution.add(cur);
    if (end.equals(cur)) {
      res.add(new ArrayList<>(solution));
    } else {
      System.out.println(cur + " " + distance.get(cur));
      for (String next : edges.get(cur)) {
        if (distance.get(next) == distance.get(cur) + 1) {
          dfs(next, end, dict, edges, distance, solution, res);
        }
      }
    }
    solution.remove(solution.size() - 1);
  }

  private static void combine(List<List<String>> result, List<String> path, Map<String, List<String>> edges, String word) {
    if (!edges.containsKey(word)) {
      result.add(path);
      return;
    }

    path.add(word);
    List<String> adj = edges.get(word);
    Iterator<String> it = adj.iterator();
    String value = it.next();

    while (it.hasNext())
      combine(result, new ArrayList<>(path), edges, it.next());
    combine(result, path, edges, value);
  }

  private static List<String> getAdj(String word, List<String> wordList) {
    List<String> adj = new ArrayList<>();
    for (String w : wordList)
      if (distance(word, w) == 1)
        adj.add(w);
    return adj;
  }


  private static int distance(String a, String b) {
    int count = 0;
    for (int i = 0; i < a.length(); i++)
      count += a.charAt(i) == b.charAt(i) ? 0 : 1;
    return count;
  }
  private static class Pair {
    String word;

    int distance;
    Pair(String word, int distance) {
      this.word = word;
      this.distance = distance;
    }

  }

  // reference
  class Solution {
    public List<List<String>> findLadders(String start, String end, List<String> wordList) {
      HashSet<String> dict = new HashSet<>(wordList);
      List<List<String>> res = new ArrayList<>();
      HashMap<String, ArrayList<String>> nodeNeighbors = new HashMap<>();// Neighbors for every node
      HashMap<String, Integer> distance = new HashMap<>();// Distance of every node from the start node
      ArrayList<String> solution = new ArrayList<>();

      dict.add(start);
      bfs(start, end, dict, nodeNeighbors, distance);
      dfs(start, end, dict, nodeNeighbors, distance, solution, res);
      return res;
    }

    // BFS: Trace every node's distance from the start node (level by level).
    private void bfs(String start, String end, Set<String> dict, HashMap<String, ArrayList<String>> nodeNeighbors, HashMap<String, Integer> distance) {
      for (String str : dict)
        nodeNeighbors.put(str, new ArrayList<>());

      Queue<String> queue = new LinkedList<>();
      queue.offer(start);
      distance.put(start, 0);

      while (!queue.isEmpty()) {
        int count = queue.size();
        boolean foundEnd = false;
        for (int i = 0; i < count; i++) {
          String cur = queue.poll();
          int curDistance = distance.get(cur);
          ArrayList<String> neighbors = getNeighbors(cur, dict);

          for (String neighbor : neighbors) {
            nodeNeighbors.get(cur).add(neighbor);
            if (!distance.containsKey(neighbor)) {// Check if visited
              distance.put(neighbor, curDistance + 1);
              if (end.equals(neighbor))// Found the shortest path
                foundEnd = true;
              else
                queue.offer(neighbor);
            }
          }
        }

        if (foundEnd)
          break;
      }
    }

    // Find all next level nodes.
    private ArrayList<String> getNeighbors(String node, Set<String> dict) {
      ArrayList<String> res = new ArrayList<String>();
      char chs[] = node.toCharArray();

      for (char ch ='a'; ch <= 'z'; ch++) {
        for (int i = 0; i < chs.length; i++) {
          if (chs[i] == ch) continue;
          char old_ch = chs[i];
          chs[i] = ch;
          if (dict.contains(String.valueOf(chs))) {
            res.add(String.valueOf(chs));
          }
          chs[i] = old_ch;
        }

      }
      return res;
    }

    // DFS: output all paths with the shortest distance.
    private void dfs(String cur, String end, Set<String> dict, HashMap<String, ArrayList<String>> nodeNeighbors, HashMap<String, Integer> distance, ArrayList<String> solution, List<List<String>> res) {
      solution.add(cur);
      if (end.equals(cur)) {
        res.add(new ArrayList<>(solution));
      } else {
        for (String next : nodeNeighbors.get(cur)) {
          if (distance.get(next) == distance.get(cur) + 1) {
            dfs(next, end, dict, nodeNeighbors, distance, solution, res);
          }
        }
      }
      solution.remove(solution.size() - 1);
    }
  }

  public static void main(String[] args) {
    System.out.println(findLadders("a", "c", new ArrayList<>(Arrays.asList("a", "b", "c"))));
  }
}
