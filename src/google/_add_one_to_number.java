package google;

import java.util.ArrayList;
import java.util.List;

public class _add_one_to_number {
  public static ArrayList<Integer> plusOne(ArrayList<Integer> num) {
    if (num == null || num.size() == 0) return new ArrayList<>();
    int carry = 0, n = num.size();
    num.set(n - 1, num.get(n - 1) + 1);
    for (int i = n - 1; i >= 0; i--) {
      int temp = num.get(i) + carry;
      if (temp >= 10) {
        carry = 1;
        temp -= 10;
      } else {
        carry = 0;
      }

      num.set(i, temp);
      if (carry == 0) break;
    }

    if (carry != 0)
      num.add(0, 1);

    int i = 0;
    while (i < num.size() - 1 & num.get(i) == 0) i++;
    return copyList(num, i);
  }

  private static ArrayList<Integer> copyList(List<Integer> num, int index) {
    ArrayList<Integer> copy = new ArrayList<>();
    for (int i = index; i < num.size(); i++) {
      copy.add(num.get(i));
    }

    return copy;
  }
}
