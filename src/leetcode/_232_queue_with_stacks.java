package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _232_queue_with_stacks {
  static class MyQueue {
    private List<Integer> stack1, stack2;

    /** Initialize your data structure here. */
    public MyQueue() {
      this.stack1 = new ArrayList<>();
      this.stack2 = new ArrayList<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
      stack1.add(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
      if (!stack2.isEmpty()) {
        return stack2.remove(stack2.size() - 1);
      } else {
        for (int i = stack1.size() - 1; i >= 0; i--)
          stack2.add(stack1.get(i));
        stack1.clear();
        return stack2.remove(stack2.size() - 1);
      }
    }

    /** Get the front element. */
    public int peek() {
      if (!stack2.isEmpty()) {
        return stack2.get(stack2.size() - 1);
      } else {
        return stack1.get(0);
      }
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
      return stack1.isEmpty() && stack2.isEmpty();
    }
  }

  public static void main(String[] args) {
    MyQueue queue = new MyQueue();
    queue.push(1);
    queue.push(2);
    System.out.println(queue.peek());
    System.out.println(queue.pop());
    System.out.println(queue.empty());
  }
}
