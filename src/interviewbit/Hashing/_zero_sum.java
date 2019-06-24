package interviewbit.Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class _zero_sum {
  public static ArrayList<Integer> lszero(ArrayList<Integer> list) {
    int maxI = Integer.MAX_VALUE, maxJ = Integer.MAX_VALUE;

    int[] sum = new int[list.size()];
    for (int i = 0; i < list.size(); i++)
      sum[i] = (i == 0) ? list.get(0) : sum[i - 1] + list.get(i);

    HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

    for (int i = 0; i < list.size(); i++) {
      int val = sum[i];
      if (map.containsKey(val)) {
        map.get(val).add(i);
      } else {
        ArrayList<Integer> l = new ArrayList<>();
        l.add(i);
        map.put(val, l);
      }
    }

    for (int k = 0; k < list.size(); k++) {
      int val = sum[k];
      ArrayList<Integer> l = map.get(val);
      if (val == 0) {
        int i = -1;
        if (k - i + 1 > maxJ - maxI + 1 || (k - i + 1 == maxJ - maxI + 1 && i < maxI)) {
          maxI = i;
          maxJ = k;
        }
      } else if (l.size() > 1) {
        int i = l.get(0), j = l.get(l.size() - 1);
        if (j - i + 1 > maxJ - maxI + 1 || (j - i + 1 == maxJ - maxI + 1 && i < maxI)) {
          maxI = i;
          maxJ = j;
        }
      }
    }

    if (maxI == Integer.MAX_VALUE) return new ArrayList<>();
    ArrayList<Integer> r = new ArrayList<>();
    for (int i = maxI + 1; i <= maxJ; i++)
      r.add(list.get(i));
    return r;
  }

  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, -3, 3));
    System.out.println(lszero(list));
  }
}
