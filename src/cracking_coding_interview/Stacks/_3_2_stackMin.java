package cracking_coding_interview.Stacks;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class _3_2_stackMin implements Iterable<Integer> {
  private Node head;
  private int size;

  public _3_2_stackMin() {
    head = null;
    size = 0;
  }

  private class Node {
    private int min;
    private int val;
    private Node next;

    private Node(int val) {
      this.val = val;
    }
  }

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public void push(int key) {
    if (head == null) {
      head = new Node(key);
      head.min = key;
    } else {
      Node node = new Node(key);
      node.min = Math.min(key, head.min);
      node.next = head;
      head = node;
    }
    size++;
  }

  public int pop() {
    if (head == null) throw new NoSuchElementException("Stack underflow.");
    int val = head.val;
    head = head.next;
    size--;
    return val;
  }

  public int peek() {
    if (head == null) throw new NoSuchElementException("Stack underflow.");
    return head.val;
  }

  public int min() {
    if (head == null) throw new NoSuchElementException("Stack underflow.");
    return head.min;
  }

  @Override
  public Iterator<Integer> iterator() {
    return new StackIterator();
  }

  private class StackIterator implements Iterator<Integer> {
    private Node node;

    private StackIterator() {
      node = head;
    }

    @Override
    public boolean hasNext() {
      return node != null;
    }

    @Override
    public Integer next() {
      if (!hasNext()) throw new NoSuchElementException();
      int val = node.val;
      node = node.next;
      return val;
    }

    @Override
    public void remove() {
      throw new UnsupportedOperationException("remove is not supported");
    }
  }
}
