package leetcode.session1;

import java.util.*;

public class _eval_div {
  public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
    Map<String, Map<String, Double>> graph = new HashMap<>();
    for (int i = 0; i < equations.size(); i++) {
      List<String> equation = equations.get(i);
      double value = values[i];
      String divider = equation.get(0);
      String divisor = equation.get(1);
      if (!graph.containsKey(divider)) graph.put(divider, new HashMap<>());
      graph.get(divider).put(divisor, value);
      if (!graph.containsKey(divisor)) graph.put(divisor, new HashMap<>());
      graph.get(divisor).put(divider, 1 / value);
    }

    double[] result = new double[queries.size()];
    Arrays.fill(result, -1);
    for (int i = 0; i < queries.size(); i++) {
      List<String> query = queries.get(i);
      String divider = query.get(0);
      String divisor = query.get(1);
      if (!graph.containsKey(divider) || !graph.containsKey(divisor)) continue;
      if (divider.equals(divisor)) {
        result[i] = 1.0;
        continue;
      }
      Queue<Pair<String, Double>> q = new LinkedList<>();
      q.add(new Pair<>(divider, 1.0));
      Map<String, Boolean> marked = new HashMap<>();
      while (!q.isEmpty()) {
        Pair<String, Double> pair = q.poll();
        String s = pair.getKey();
        double value = pair.getValue();
        marked.put(s, true);
        for (String key : graph.get(s).keySet()) {
          if (!marked.containsKey(key)) {
            if (key.equals(divisor)) {
              result[i] = graph.get(s).get(key) * value;
              break;
            }
            q.add(new Pair<>(key, value * graph.get(s).get(key)));
          }
        }
      }
    }

    return result;
  }

  static class Pair<T, U> {
    T key;
    U value;

    Pair(T key, U value) {
      this.key = key;
      this.value = value;
    }

    U getValue() {
      return value;
    }

    T getKey() {
      return key;
    }
  }

  public static void main(String[] args) {
    System.out.println();
  }
}
