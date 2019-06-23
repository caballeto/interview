package interviewbit.Backtracking;

import java.util.*;

public class _subsets2 {
  private static final ListComparator LIST_COMPARATOR = new ListComparator();

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

  public static ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> list) {
    if (list == null || list.isEmpty()) {
      ArrayList<ArrayList<Integer>> res = new ArrayList<>();
      res.add(new ArrayList<>());
      return res;
    }

    Collections.sort(list);
    ArrayList<ArrayList<Integer>> res = new ArrayList<>(new HashSet<>(backtrack(list)));
    res.sort(LIST_COMPARATOR);
    return res;
  }

  private static ArrayList<ArrayList<Integer>> backtrack(ArrayList<Integer> list) {
    if (list.size() == 1) {
      ArrayList<Integer> l = new ArrayList<>();
      l.add(list.get(0));
      return new ArrayList<>(Arrays.asList(new ArrayList<>(), l));
    }

    Integer elem = list.remove(list.size() - 1);
    ArrayList<ArrayList<Integer>> subsets = backtrack(list), copy = new ArrayList<>();

    for (ArrayList<Integer> subset : subsets)
      copy.add(new ArrayList<>(subset));
    for (ArrayList<Integer> s : copy)
      s.add(elem);

    subsets.addAll(copy);
    return subsets;
  }
}
