package interviewbit.TwoPointers;

import java.util.ArrayList;

public class _remove_val {
    public int removeElement(ArrayList<Integer> list, int value) {
      ArrayList<Integer> aux = new ArrayList<>();
      for (int val : list) {
        if (val != value) {
          aux.add(val);
        }
      }

      list.clear();
      list.addAll(aux);
      return list.size();
    }
}
