package interviewbit.Math;

import java.util.*;
// not solved
public class _city_tour {
  public static int solve(int n, ArrayList<Integer> b) {
    Set<Integer> set = new HashSet<>(b);
    long ways = 1;

    List<List<Integer>> groups = new ArrayList<>();
    List<Integer> group = new ArrayList<>();
    for (int val : b) {
      if (set.contains(val)){
        if (!group.isEmpty()) {
          groups.add(group);
          group = new ArrayList<>();
        }
      } else {
        group.add(val);
      }
    }

    for (List<Integer> g : groups)
      ways *= factorial(g.size());

    return (int) (ways % 1000000007);
  }

  private static long factorial(int n) {
    long val = 1;
    for (int i = 2; i <= n; i++)
      val *= i;
    return val;
  }

  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<>();
    list.add(3);
    list.add(1);
    System.out.println(solve(4, list));
  }
}
