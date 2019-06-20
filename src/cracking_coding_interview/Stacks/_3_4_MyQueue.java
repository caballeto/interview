package cracking_coding_interview.Stacks;

import java.util.NoSuchElementException;
import java.util.Stack;

public class _3_4_MyQueue {
  private int size = 0;
  private Stack<Integer> stack1 = new Stack<>();
  private Stack<Integer> stack2 = new Stack<>();

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public void push(int elem) {
    stack1.push(elem);
    size++;
  }

  public int pop() {
    if (isEmpty()) throw new NoSuchElementException("Queue underflow.");
    if (stack2.isEmpty()) {
      stack2.addAll(stack1);
      stack1.clear();
    }
    size--;
    return stack2.pop();
  }

  public int peek() {
    if (isEmpty()) throw new NoSuchElementException("Queue underflow.");
    if (stack2.isEmpty()) {
      stack2.addAll(stack1);
      stack1.clear();
    }
    return stack2.peek();
  }
}
