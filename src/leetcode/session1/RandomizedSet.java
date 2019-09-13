package leetcode.session1;

import java.util.*;

public class RandomizedSet {
  private HashMap<Integer, Integer> values;
  private ArrayList<Integer> list;
  private int len;

  /** Initialize your data structure here. */
  public RandomizedSet() {
    values = new HashMap<>();
    list = new ArrayList<>();
    len = 0;
  }

  /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
  public boolean insert(int val) {
    if (!values.containsKey(val)) {
      values.put(val, len);
      list.add(val);
      len++;
      return true;
    }
    return false;
  }

  /** Removes a value from the set. Returns true if the set contained the specified element. */
  public boolean remove(int val) {
    if (values.containsKey(val)) {
      int index = values.get(val), elem = list.get(len - 1);
      list.set(index, elem);
      list.remove(len - 1);
      values.put(elem, index);
      values.remove(val);
      len--;
      return true;
    }
    return false;
  }

  /** Get a random element from the set. */
  public int getRandom() {
    int index = (int) (Math.random() * len);
    return list.get(index);
  }

  public static void main(String[] args) {
  }
}
