package cracking_coding_interview.Graphs;

import java.util.List;

public class _4_7_buildOrder {
  public Iterable<Integer> order(List<Integer> projects, List<int[]> dependencies) {
    DirectedGraph G = new DirectedGraph(projects.size());
    for (var dependency : dependencies) {
      G.addEdge(dependency[0], dependency[1]);
    }

    DirectedCycleFinder finder = new DirectedCycleFinder(G);

    if (finder.hasCycle()) {
      return null;
    } else {
      return new DirectedDFS(G).reversePost();
    }
  }
}
