package interviewbit.Hashing;

import java.util.*;

public class _equal {
  private static final ListComparator LIST_COMPARATOR = new ListComparator();

  private static class ListComparator implements Comparator<ArrayList<Integer>> {
    @Override
    public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
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

  public static ArrayList<Integer> equal2(ArrayList<Integer> list) {
    HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();

    for (int i = 0; i < list.size() - 1; i++) {
      for (int j = i + 1; j < list.size(); j++) {
        int sum = list.get(i) + list.get(j);
        if (map.containsKey(sum) && map.get(sum).size() == 2) {
          int a = map.get(sum).get(0), b = map.get(sum).get(1);
          if (valid(a, b, i, j)) {
            res.add(new ArrayList<>(Arrays.asList(a, b, i, j)));
            map.put(sum, new ArrayList<>());
          }
        } else if (!map.containsKey(sum)) {
          map.put(sum, new ArrayList<>(Arrays.asList(i, j)));
        }
      }
    }

    if (res.isEmpty()) return new ArrayList<>();
    res.sort(LIST_COMPARATOR);
    return res.get(0);
  }

  public static ArrayList<Integer> equal(ArrayList<Integer> list) {
    HashMap<Integer, ArrayList<int[]>> map = new HashMap<>();

    for (int i = 0; i < list.size() - 1; i++) {
      for (int j = i + 1; j < list.size(); j++) {
        int sum = list.get(i) + list.get(j);
        if (map.containsKey(sum)) {
          map.get(sum).add(new int[]{i, j});
        } else {
          ArrayList<int[]> l = new ArrayList<>();
          l.add(new int[]{i, j});
          map.put(sum, l);
        }
      }
    }

    HashSet<ArrayList<Integer>> set = new HashSet<>();
    for (Map.Entry<Integer, ArrayList<int[]>> entry : map.entrySet()) {
      ArrayList<int[]> array = entry.getValue();
      for (int i = 0; i < array.size() - 1; i++) {
        for (int j = i + 1; j < array.size(); j++) {
          int[] first = array.get(i), second = array.get(j);
          if (valid(first[0], first[1], second[0], second[1])) {
            set.add(new ArrayList<>(Arrays.asList(first[0], first[1], second[0], second[1])));
          }
        }
      }
    }

    if (set.isEmpty()) return new ArrayList<>();
    ArrayList<ArrayList<Integer>> result = new ArrayList<>(set);
    result.sort(LIST_COMPARATOR);
    return result.get(0);
  }

  private static boolean valid(int a, int b, int c, int d) {
    return a < b && c < d && a < c && b != d && b != c;
  }

  public static void main(String[] args) {
    System.out.println(equal(new ArrayList<>(Arrays.asList(3, 4, 7, 1, 2, 9, 8))));
  }
}
