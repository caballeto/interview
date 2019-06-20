package leetcode;

/**
 * Task 208. Implement a trie with {@code insert}, {@code search} and {@code startsWith}
 * operations. Assume that all input strings are non-empty and all inputs consist of
 * lowercase letters a-z.
 */
public class Trie {
  private static final int R = 26;

  private Node root;

  public Trie() {
    this.root = new Node();
  }

  public void insert(String word) {
    int c = word.charAt(0) - 'a';
    root.next[c] = insert(root.next[c], word, 1);
  }

  private Node insert(Node node, String word, int i) {
    if (node == null) node = new Node();
    if (i == word.length()) {
      node.isWord = true;
      return node;
    } else {
      int c = word.charAt(i) - 'a';
      node.next[c] = insert(node.next[c], word, ++i);
      return node;
    }
  }

  public boolean search(String word) {
    int c = word.charAt(0) - 'a';
    return get(root.next[c], word, 1);
  }

  private boolean get(Node node, String word, int i) {
    if (node == null) return false;
    if (i == word.length()) return node.isWord;
    int c = word.charAt(i) - 'a';
    return get(node.next[c], word, ++i);
  }

  public boolean startsWith(String prefix) {
    int c = prefix.charAt(0) - 'a';
    return startsWith(root.next[c], prefix, 1);
  }

  private boolean startsWith(Node node, String prefix, int i) {
    if (node == null) return false;
    if (i == prefix.length()) return true;
    int c = prefix.charAt(i) - 'a';
    return startsWith(node.next[c], prefix, ++i);
  }

  private class Node {
    private boolean isWord = false;
    private Node[] next = new Node[R];
  }

  public static void main(String[] args) {
    Trie trie = new Trie();

    trie.insert("apple");
    trie.insert("app");

    System.out.println(trie.search("apple"));
    System.out.println(trie.search("app"));
    System.out.println(trie.startsWith("app"));

    System.out.println(trie.search("applllet"));
    System.out.println(trie.search("a"));
    System.out.println(trie.startsWith("appl"));
    System.out.println(trie.startsWith("apple"));
    System.out.println(trie.startsWith("vdsdsds"));
    System.out.println(trie.search("vdsdasdsds"));
  }
}
