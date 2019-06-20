package leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class _341_flatten_list {
  private class NestedInteger {
    public boolean isInteger() { return false; }
    public Integer getInteger() { return null; }
    public List<NestedInteger> getList() { return null; }
  }

  class NestedIterator implements Iterator<Integer> {
    private Iterator<Integer> iterator;

    public NestedIterator(List<NestedInteger> nestedList) {
      ArrayList<Integer> elems = new ArrayList<>();
      for (NestedInteger ni : nestedList) {
        addAll(elems, ni);
      }

      iterator = elems.iterator();
    }

    @Override
    public Integer next() {
      return iterator.next();
    }

    @Override
    public boolean hasNext() {
      return iterator.hasNext();
    }
  }

  private void addAll(List<Integer> list, NestedInteger i) {
    if (i.isInteger()) {
      list.add(i.getInteger());
    } else {
      for (NestedInteger ni : i.getList()) {
        addAll(list, ni);
      }
    }
  }
}
