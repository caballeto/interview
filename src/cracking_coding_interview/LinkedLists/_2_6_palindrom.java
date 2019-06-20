package cracking_coding_interview.LinkedLists;

import leetcode.ListNode;

import java.util.ArrayList;
import java.util.List;

public class _2_6_palindrom {
  private static boolean isPalindrome(List<Integer> array) {
    for (int i = 0; i < array.size()/2; i++) {
      if (!array.get(i).equals(array.get(array.size() - i - 1))) {
        return false;
      }
    }

    return true;
  }

  public static boolean isPalindrome(ListNode node) {
    if (node == null) return false;
    List<Integer> array = new ArrayList<>();
    while (node != null) {
      array.add(node.val);
      node = node.next;
    }

    return isPalindrome(array);
  }
}
