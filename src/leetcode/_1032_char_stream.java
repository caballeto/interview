package leetcode;

public class _1032_char_stream {
  private static final int R = 26;

  private Node root;
  private StringBuilder builder;

  public _1032_char_stream(String[] words) {
    builder = new StringBuilder();
    root = new Node();
    for (String word : words) {
      add(reverse(word));
    }
  }

  public boolean query(char letter) {
    builder.append(letter);
    int i = builder.length() - 1;
    Node current = root;
    while (i >= 0) {
      int c = builder.charAt(i) - 'a';
      current = current.next[c];
      if (current == null) return false;
      if (current.isWord) return true;
      i--;
    }

    return false;
  }

  private void add(String word) {
    int c = word.charAt(0) - 'a';
    root.next[c] = add(root.next[c], word, 1);
  }

  private Node add(Node node, String word, int i) {
    if (node == null) node = new Node();
    if (i == word.length()) {
      node.isWord = true;
      return node;
    } else {
      int c = word.charAt(i) - 'a';
      node.next[c] = add(node.next[c], word, ++i);
      return node;
    }
  }

  private String reverse(String word) {
    return new StringBuilder(word).reverse().toString();
  }

  private class Node {
    private Node[] next = new Node[R];
    private boolean isWord = false;
  }
}
