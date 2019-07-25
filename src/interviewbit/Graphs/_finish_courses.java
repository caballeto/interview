package interviewbit.Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class _finish_courses {
  static class Graph {
    int V;
    boolean[] marked;
    boolean[] onStack;
    boolean hasCycle;
    LinkedList<Integer>[] adj;

    @SuppressWarnings("unchecked")
    Graph(int V) {
      this.V = V;
      marked = new boolean[V];
      onStack = new boolean[V];
      adj = (LinkedList<Integer>[]) new LinkedList[V];
      for (int i = 0; i < adj.length; i++) {
        adj[i] = new LinkedList<>();
      }
    }

    void cycle() {
      for (int v = 0; v < V; v++)
        if (!marked[v] && !hasCycle)
          dfs(v);
    }

    void addEdge(int v, int w) {
      adj[v].add(w);
    }

    Iterable<Integer> adj(int v) {
      return adj[v];
    }

    boolean hasCycle() {
      return hasCycle;
    }

    private void dfs(int v) {
      marked[v] = true;
      onStack[v] = true;
      for (int w : adj(v)) {
        if (hasCycle) return;
        if (!marked[w])
          dfs(w);
        else if (onStack[w]) {
          hasCycle = true;
        }
      }

      onStack[v] = false;
    }
  }


  public static int solve(int n, int[] prerequisite, int[] course) {
    HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

    for (int i = 0; i < prerequisite.length; i++) {
      int p = prerequisite[i], c = course[i];

      if (map.containsKey(c)) {
        map.get(c).add(p);
      } else {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(p);
        map.put(c, list);
      }
    }
    Graph G = new Graph(n);
    for (int v = 1; v <= n; v++) {
      if (map.containsKey(v)) {
        for (int w : map.get(v)) {
          G.addEdge(w - 1, v - 1);
        }
      }
    }

    G.cycle();
    return G.hasCycle() ? 0 : 1;
  }

  public static void main(String[] args) {
    System.out.println(solve(66, new int[]{36, 53, 1, 12, 16, 2, 21, 8, 57, 37, 19, 33, 33, 19, 30, 18, 6, 63, 46, 23, 42, 13, 22, 32, 9, 9, 36, 46, 63, 66, 28, 58, 31, 43, 44, 15, 45, 54, 50, 64, 16, 51, 54, 17, 60, 8, 22, 6, 32, 12, 7, 40, 50, 13, 29, 3, 42, 58, 20, 52, 26, 28, 49, 13, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43}, new int[]{17, 64, 30, 48, 41, 57, 56, 65, 47, 23, 15, 66, 37, 41, 59, 45, 4, 4, 34, 2, 62, 51, 24, 20, 3, 11, 43, 39, 56, 34, 9, 47, 65, 14, 35, 10, 27, 31, 5, 24, 38, 5, 53, 10, 38, 55, 35, 39, 26, 38, 14, 52, 27, 25, 55, 40, 28, 59, 18, 7, 21, 29, 8, 48, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}));
  }
}
