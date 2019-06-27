package interviewbit.Maps;

import java.util.HashMap;

public class LRUCache {
  static class Node {
    int key;
    int value;
    Node next;
    Node prev;

    Node(int key, int value) {
      this.key = key;
      this.value = value;
      this.next = null;
      this.prev = null;
    }
  }

  private int capacity;
  private int size = 0;
  private Node head;
  private Node tail;
  private HashMap<Integer, Node> map = new HashMap<>();

  public LRUCache(int capacity) {
    this.capacity = capacity;
  }

  int get(int key) {
    if (map.containsKey(key)) {
      Node node = map.get(key);
      if (node == head) {
        return node.value;
      } else if (node == tail) {
        node.prev.next = null;
        tail = node.prev;
        node.prev = null;
        node.next = head;
        head.prev = node;
        head = node;
      } else {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.prev = null;
        node.next = head;
        head.prev = node;
        head = node;
      }

      return node.value;
    } else {
      return -1;
    }
  }

  void put(int key, int value) {
    if (map.containsKey(key)) {
      map.get(key).value = value;
      get(key);
    } else if (size < capacity) {
      Node node = new Node(key, value);
      if (head == null) {
        head = node;
        tail = node;
      } else {
        node.next = head;
        head.prev = node;
        head = node;
      }

      map.put(key, node);
      size++;
    } else {
      Node node = new Node(key, value);
      Node del = tail;
      map.remove(del.key);
      map.put(key, node);
      if (capacity == 1) {
        head = tail = node;
      } else {
        tail = tail.prev;
        tail.next = null;
        node.next = head;
        head.prev = node;
        head = node;
      }
    }
  }

  static void printList(Node node) {
    while (node != null) {
      System.out.println(node.key + " " + node.value + "|" +  node + " (" + node.prev + "," + node.next + ")");
      node = node.next;
    }
  }

  public static void main(String[] args) {
    LRUCache cache = new LRUCache(2);
    cache.put(1, 1);
    cache.put(2, 2);
    System.out.println(cache.get(1));
    cache.put(3, 3);
    System.out.println(cache.get(2));
    cache.put(4, 4);
    System.out.println(cache.get(1));
    System.out.println(cache.get(3));
    System.out.println(cache.get(4));
  }
}
