package interviewbit.Graphs;

import java.util.*;

public class _clone_graph {
  class UndirectedGraphNode {
      int label;
      List<UndirectedGraphNode> neighbors;
      UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<>(); }
  }

  public UndirectedGraphNode cloneGraph(UndirectedGraphNode start) {
    UndirectedGraphNode root = new UndirectedGraphNode(start.label);
    HashMap<Integer, UndirectedGraphNode> map = new HashMap<>();
    HashSet<UndirectedGraphNode> onQueue = new HashSet<>();
    Queue<UndirectedGraphNode> queue = new ArrayDeque<>();

    for (UndirectedGraphNode node : start.neighbors) {
      if (node != start) {
        queue.add(node);
        onQueue.add(node);
      } else {
        root.neighbors.add(root);
      }
    }

    map.put(root.label, root);

    while (!queue.isEmpty()) {
      UndirectedGraphNode node = queue.poll();
      UndirectedGraphNode copy = new UndirectedGraphNode(node.label);

      for (UndirectedGraphNode n : node.neighbors) {
        if (n == node) copy.neighbors.add(copy);
        else if (map.containsKey(n.label)) {
          copy.neighbors.add(map.get(n.label));
          map.get(n.label).neighbors.add(copy);
        } else if (!onQueue.contains(n)) {
          queue.add(n);
          onQueue.add(n);
        }
      }

      onQueue.remove(node);
      map.put(copy.label, copy);
    }

    return root;
  }

  public static void main(String[] args) {

  }
}
