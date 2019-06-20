package cracking_coding_interview.Stacks;

import java.util.NoSuchElementException;

public class _3_3_stackOfPlates {
  private static final int DEFAULT_SIZE = 5;

  private Node head;
  private int size;
  private int stackSize;

  public _3_3_stackOfPlates() {
    this(DEFAULT_SIZE);
  }

  public _3_3_stackOfPlates(int capacity) {
    if (capacity <= 0) throw new NoSuchElementException("Capacity should be positive number.");
    size = 0;
    stackSize = capacity;
    head = new Node();
  }

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public void push(int elem) {
    if (head.isFull()) {
      Node node = new Node();
      node.push(elem);
      node.next = head;
      head = node;
    } else {
      head.push(elem);
    }
    size++;
  }

  public int pop() {
    if (isEmpty()) throw new NoSuchElementException("Stack underflow.");
    if (head.isEmpty()) head = head.next;
    size--;
    return head.pop();
  }

  public int peek() {
    if (isEmpty()) throw new NoSuchElementException("Stack underflow.");
    if (head.isEmpty()) head = head.next;
    return head.peek();
  }

  private class Node {
    private Node next;
    private int[] data;
    private int index;

    Node() {
      index = 0;
      data = new int[stackSize];
    }

    private void push(int elem) {
      if (isFull()) throw new NoSuchElementException("Stack overflow.");
      data[index++] = elem;
    }

    private int pop() {
      if (isEmpty()) throw new NoSuchElementException("Stack underflow.");
      return data[--index];
    }

    private int peek() {
      if (isEmpty()) throw new NoSuchElementException("Stack underflow.");
      return data[index - 1];
    }

    private boolean isEmpty() {
      return index == 0;
    }

    private boolean isFull() {
      return index == stackSize;
    }
  }
}
