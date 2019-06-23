package interviewbit.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class _subsets {
  private static class ListComparator implements Comparator<ArrayList<Integer>> {
    @Override
    public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
      if (o1.isEmpty()) return -1;
      if (o2.isEmpty()) return 1;

      int size = Math.min(o1.size(), o2.size());

      for (int i = 0; i < size; i++) {
        if (o1.get(i) < o2.get(i)) {
          return -1;
        } else if (o1.get(i) > o2.get(i)) {
          return 1;
        }
      }

      return o1.size() - o2.size();
    }
  }

  public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> set) {
    if (set == null || set.size() == 0) {
      ArrayList<ArrayList<Integer>> s = new ArrayList<>();
      s.add(new ArrayList<>());
      return s;
    }
    Collections.sort(set);
    ArrayList<ArrayList<Integer>> res = subsets2(set);
    res.sort(new ListComparator());
    return res;
  }

  private static ArrayList<ArrayList<Integer>> subsets2(ArrayList<Integer> set) {
    if (set.size() == 1) {
      ArrayList<Integer> list = new ArrayList<>();
      list.add(set.get(0));
      return new ArrayList<>(Arrays.asList(new ArrayList<>(), list));
    }

    Integer val = set.remove(set.size() - 1);
    ArrayList<ArrayList<Integer>> subsets = subsets(set), subsetCopy = new ArrayList<>();

    for (ArrayList<Integer> subset : subsets)
      subsetCopy.add(new ArrayList<>(subset));
    for (ArrayList<Integer> subset : subsetCopy)
      subset.add(val);

    subsets.addAll(subsetCopy);
    return subsets;
  }

  public static void main(String[] args) {
    System.out.println(subsets(new ArrayList<>(Arrays.asList(1, 2, 2))));
  }
}
