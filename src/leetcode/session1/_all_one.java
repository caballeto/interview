package leetcode.session1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _all_one {
  class AllOne {
    class Node {
      int size;
      Set<String> keySet;
      Node prev, next;

      public Node(int size, String key) {
        this.size = size;
        keySet = new HashSet<>();
        keySet.add(key);
      }
    }

    private Node head, tail;
    Map<String, Node> dataMap;

    /** Initialize your data structure here. */
    public AllOne() {
      dataMap = new HashMap<>();
      head = new Node(-1, "");
      tail = new Node(-1, "");
      head.next = tail;
      tail.prev = head;
    }

    private void addAfterNode(Node node, Node newNode) {
      newNode.next = node.next;
      newNode.prev = node;
      node.next.prev = newNode;
      node.next = newNode;
    }

    private void remove(Node node) {
      node.prev.next = node.next;
      node.next.prev = node.prev;
    }

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
      if (!dataMap.containsKey(key)) {
        if (head.next.size == 1)
          head.next.keySet.add(key);
        else
          addAfterNode(head, new Node(1, key));
        dataMap.put(key, head.next);
      } else {
        Node forUpdate = dataMap.get(key);
        forUpdate.keySet.remove(key);
        if (forUpdate.size + 1 == forUpdate.next.size)
          forUpdate.next.keySet.add(key);
        else
          addAfterNode(forUpdate, new Node(forUpdate.size + 1, key));
        dataMap.put(key, forUpdate.next);
        if (forUpdate.keySet.isEmpty())
          remove(forUpdate);
      }
    }

    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
      if (dataMap.containsKey(key)) {
        Node forUpdate = dataMap.get(key);
        forUpdate.keySet.remove(key);
        if (forUpdate.size == 1)
          dataMap.remove(key);
        else {
          if (forUpdate.size - 1 == forUpdate.prev.size)
            forUpdate.prev.keySet.add(key);
          else addAfterNode(forUpdate.prev, new Node(forUpdate.size - 1, key));
          dataMap.put(key, forUpdate.prev);
        }
        if (forUpdate.keySet.isEmpty())
          remove(forUpdate);
      }
    }

    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
      return tail.prev == head ? "" : tail.prev.keySet.iterator().next();
    }

    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
      return head.next == tail ? "" : head.next.keySet.iterator().next();
    }
  }
}
