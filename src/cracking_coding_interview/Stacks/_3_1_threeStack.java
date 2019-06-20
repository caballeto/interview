package cracking_coding_interview.Stacks;

import java.util.NoSuchElementException;

// # TODO add resize(...) when all stacks are less then cellSize / 2
public class _3_1_threeStack {
  private static final int DEFAULT_SIZE = 3;

  private int cellSize;
  private int p1, p2, p3;
  private int[] data;

  public _3_1_threeStack() {
    this(DEFAULT_SIZE);
  }

  public _3_1_threeStack(int capacity) {
    if (capacity <= 0) throw new IllegalArgumentException("Capacity should be positive.");
    cellSize = capacity;
    data = new int[cellSize*3];
    p1 = 0;
    p2 = cellSize;
    p3 = cellSize*2;
  }

  public void pushFirst(int elem) {
    if (p1 > cellSize) resize(2*cellSize);
    data[p1++] = elem;
  }

  public void pushSecond(int elem) {
    if (p2 > cellSize*2) resize(2*cellSize);
    data[p2++] = elem;
  }

  public void pushThird(int elem) {
    if (p3 > cellSize*3) resize(2*cellSize);
    data[p3++] = elem;
  }

  public int popFirst() {
    if (p1 == 0) throw new NoSuchElementException("Stack underflow");
    return data[--p1];
  }

  public int popSecond() {
    if (p2 == cellSize) throw new NoSuchElementException("Stack underflow");
    return data[--p2];
  }

  public int popThird() {
    if (p3 == 2*cellSize) throw new NoSuchElementException("Stack underflow");
    return data[--p3];
  }

  public int peekFirst() {
    if (p1 == 0) throw new NoSuchElementException("Stack underflow");
    return data[p1 - 1];
  }

  public int peekSecond() {
    if (p2 == cellSize) throw new NoSuchElementException("Stack underflow");
    return data[p2 - 1];
  }

  public int peekThird() {
    if (p3 == 2*cellSize) throw new NoSuchElementException("Stack underflow");
    return data[p3 - 1];
  }

  public int sizeFirst() {
    if (p1 == cellSize) return cellSize;
    return p1;
  }

  public int sizeSecond() {
    if (p3 == cellSize * 2) return cellSize;
    return p2 % cellSize;
  }

  public int sizeThird() {
    if (p3 == cellSize * 3) return cellSize;
    return p3 % cellSize;
  }

  private void resize(int capacity) {
    int[] newArray = new int[capacity*3];
    System.arraycopy(data, 0, newArray, 0, p1);
    System.arraycopy(data, cellSize, newArray, capacity, p2 % cellSize);
    System.arraycopy(data, 2*cellSize, newArray, 2*capacity, p3 % cellSize);
    cellSize = capacity;
    data = newArray;
    p1 = (p1 % cellSize);
    p2 = (p2 % cellSize) + capacity;
    p3 = (p3 % cellSize) + 2*capacity;
  }

  public static void main(String[] args) {
    _3_1_threeStack stack = new _3_1_threeStack();

    stack.pushFirst(5);
    stack.pushFirst(6);
    stack.pushSecond(1);
    stack.pushThird(2);
    stack.pushThird(3);
    stack.pushThird(4);

    System.out.println("Sizes.");
    System.out.println(stack.sizeFirst());
    System.out.println(stack.sizeSecond());
    System.out.println(stack.sizeThird());
    System.out.println("Peeks.");
    System.out.println(stack.peekFirst());
    System.out.println(stack.peekSecond());
    System.out.println(stack.peekThird());
    System.out.println("Pops.");
    System.out.println(stack.popFirst());
    System.out.println(stack.popSecond());
    System.out.println(stack.popThird());
    System.out.println("After pops.");
    System.out.println(stack.peekFirst());
    System.out.println(stack.peekThird());

    System.out.println("Resize.");

    stack.pushFirst(4);
    stack.pushFirst(3);
    stack.pushFirst(2);
    stack.pushFirst(1);
    stack.pushSecond(2);

    System.out.println(stack.peekFirst());
    System.out.println(stack.peekSecond());
    System.out.println(stack.peekThird());
  }
}
