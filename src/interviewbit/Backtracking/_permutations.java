package interviewbit.Backtracking;

import java.util.ArrayList;

public class _permutations {
  public static ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> set) {
    if (set.size() == 0) {
      ArrayList<ArrayList<Integer>> res = new ArrayList<>();
      res.add(new ArrayList<>());
      return res;
    }

    Integer val = set.remove(0);
    ArrayList<ArrayList<Integer>> perms = permute(set);
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    for (ArrayList<Integer> perm : perms) {
      for (int i = 0; i <= perm.size(); i++) {
        ArrayList<Integer> temp = new ArrayList<>(perm);
        temp.add(i, val);
        res.add(temp);
      }
    }

    return res;
  }
}
