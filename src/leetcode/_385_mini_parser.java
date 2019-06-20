package leetcode;

import java.util.List;

public class _385_mini_parser {
   class NestedInteger {
     public NestedInteger() {

     }

     public NestedInteger(int value) {

     }

     public boolean isInteger() {
       return true;
     }

     public Integer getInteger() {
       return null;
     }

     public void setInteger(int value) {
       return;
     }

     public void add(NestedInteger ni) {
       return;
     }

     public List<NestedInteger> getList() {
       return null;
     }
  }

  public NestedInteger deserialize(String s) {
     if (s.charAt(0) == '[') {
       NestedInteger list = new NestedInteger();
       add(list, s.substring(1, s.length() - 1));
       return list;
     } else {
       return new NestedInteger(Integer.parseInt(s));
     }
  }

  private void add(NestedInteger list, String s) {
    int i = 0;
    while (i < s.length()) {
      if (s.charAt(i) == '[') {
        int index = getArrayIndex(i + 1, s);
        NestedInteger ni = new NestedInteger();
        add(ni, s.substring(i + 1, index));
        list.add(ni);
        i = index;
      } else if (s.charAt(i) == ',' || s.charAt(']') == ']') {
        i++;
      } else {
        int index = getIndex(i, s);
        list.add(new NestedInteger(Integer.parseInt(s.substring(i, index))));
        i = index;
      }
    }
  }

  private int getArrayIndex(int i, String s) {
     int count = 1;
     while (count != 0) {
       if      (s.charAt(i) == '[') count++;
       else if (s.charAt(i) == ']') count--;
       i++;
     }

     return i;
  }

  private int getIndex(int i, String s) {
    if (s.charAt(i) == '-') i++;
    while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
      i++;
    }

    return i;
  }
}
