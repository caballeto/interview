package interviewbit.Trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _shortes_prefix {
  private static final int R = 26;

  public static ArrayList<String> prefix(ArrayList<String> words) {
    Trie trie = new Trie(words);
    ArrayList<String> prefixes = new ArrayList<>();
    for (String word : words) {
      prefixes.add(trie.prefix(word));
    }

    return prefixes;
  }

  static class Trie {
    Node root;

    Trie(List<String> words) {
      root = new Node();
      for (String word : words) {
        add(word);
      }
    }

    String prefix(String word) {
      return uniquePrefix(root, word);
    }

    void add(String s) {
      add(root, s, 0);
    }

    private String uniquePrefix(Node node, String word) {
      int i = 0;
      StringBuilder builder = new StringBuilder();
      while (i < word.length()) {
        if (node.nwords == 1) break;
        builder.append(word.charAt(i));
        node = node.next[word.charAt(i) - 'a'];
        i++;
      }

      return builder.toString();
    }

    private Node add(Node node, String s, int index) {
      if (index == s.length()) return null;
      if (node == null) node = new Node();
      int c = s.charAt(index) - 'a';
      node.next[c] = add(node.next[c], s, index + 1);
      node.nwords++;
      return node;
    }

    class Node {
      Node[] next;
      int nwords;

      Node() {
        next = new Node[R];
        nwords = 0;
      }
    }
  }

  public static void main(String[] args) {
    System.out.println(prefix(new ArrayList<>(Arrays.asList("zebra", "dog", "duck", "dove"))));
  }
}
