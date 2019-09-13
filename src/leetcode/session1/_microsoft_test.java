package leetcode.session1;

import leetcode.ListNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _microsoft_test {
  /* ------- MIN STRING ---------- */
  public static String lexMinString(String s) {
    if (s == null) throw new IllegalArgumentException();
    StringBuilder sb = new StringBuilder(s);
    for (int i = 0; i < s.length() - 1; i++) {
      if (s.charAt(i) > s.charAt(i + 1)) {
        sb.deleteCharAt(i);
        return sb.toString();
      }
    }

    sb.deleteCharAt(s.length() - 1);
    return sb.toString();
  }

  /* ------- MIN SWAP ---------- */
  public static int minSwapPalindrome(String s) {
    if (s == null) throw new IllegalArgumentException();
    if (!canFormPalindrome(s)) return -1;

    int n = s.length(), swaps = 0;
    StringBuilder sb = new StringBuilder(s);

    for (int i = 0; i < n / 2; i++) {
      boolean found = false;
      for (int j = n - i - 1; j > i; j--) {
        //System.out.println(i + ":" + j);
        if (sb.charAt(j) == sb.charAt(i)) {
          found = true;
          for (int k = j; k < n - i - 1; k++) {
            swap(sb, k, k + 1);
            swaps++;
          }
          break;
        }
      }

      if (!found && n % 2 != 0) {
        for (int k = i; k < n/2; k++) {
          swap(sb, k, k + 1);
          swaps++;
        }
      }
    }
/*
    int i = 0;
    while (i < n/2) {
      int j = n - i - 1;
      while (sb.charAt(i) != sb.charAt(j)) j--;
      sb.deleteCharAt(j);
      sb.insert(n - i - 1, sb.charAt(i));
      swaps += (n - i - 1) - j;
      i++;
    }
 */
    System.out.println(sb);
    return swaps;
  }

  private static void swap(StringBuilder sb, int i, int j) {
    char c = sb.charAt(i);
    sb.setCharAt(i, sb.charAt(j));
    sb.setCharAt(j, c);
  }

  // only for lowercase letter
  private static boolean canFormPalindrome(String s) {
    int[] counts = new int[26];
    for (char c : s.toCharArray())
      counts[c - 'a']++;

    boolean hasOdd = false;
    for (int count : counts) {
      if (count % 2 != 0) {
        if (hasOdd)
          return false;
        hasOdd = true;
      }
    }

    return true;
  }

  /* ------- MAX EQUAL SUM ---------- */
  public static int maxSum(int[] array) {
    if (array == null) return -1;
    Map<Integer, Integer> elems = new HashMap<>();
    int maxSum = -1;
    for (int val1 : array) {
      int sum = digitSum(val1);
      if (elems.containsKey(sum)) {
        int val2 = elems.get(sum);
        maxSum = Math.max(maxSum, val1 + val2);
        elems.put(sum, Math.max(val1, val2));
      } else {
        elems.put(sum, val1);
      }
    }

    return maxSum;
  }

  private static int digitSum(int num) {
    int sum = 0;
    num = Math.abs(num);
    while (num > 0) {
      sum += num % 10;
      num /= 10;
    }

    return sum;
  }

  /* ------- RECURSIVE STRING REVERSE ---------- */
  public static void reverse(char[] s) {
    if (s == null) return;
    reverseRecursive(s, 0, s.length - 1);
  }

  private static void reverseRecursive(char[] s, int start, int end) {
    if (start >= end) return;
    char c = s[start];
    s[start] = s[end];
    s[end] = c;
    reverseRecursive(s, start + 1, end - 1);
  }

  /* ------- PRINT NUM VERTICALLY ---------- */
  public static void printNumVertically(int num) {
    num = Math.abs(num);
    int reversed = 0, cnt = 0;
    while (num % 10 == 0) {
      cnt++;
      num /= 10;
    }

    while (num > 0) {
      reversed = reversed * 10 + num % 10;
      num /= 10;
    }

    while (reversed > 0) {
      System.out.println(reversed % 10);
      reversed /= 10;
    }

    while (cnt-- > 0) {
      System.out.println(0);
    }
  }

  /* ------- REMOVE PRIME NUMS ---------- */
  public static ListNode removePrimes(ListNode node) {
    if (node == null) return null;
    while (node != null && isPrime(node.val))
      node = node.next;

    if (node == null) return null;
    ListNode cur = node.next, prev = node;
    while (cur != null) {
      if (isPrime(cur.val)) {
        prev.next = cur.next;
        cur = cur.next;
      } else {
        prev = cur;
        cur = cur.next;
      }
    }

    return node;
  }

  private static boolean isPrime(int num) {
    if (num == 1 || num == 2) return true;
    for (int i = 2; i < Math.sqrt(num); i++)
      if (num % i == 0)
        return false;
    return true;
  }

  /* ------- MIN STEPS PILE ---------- */
  public static int minSteps(int[] piles) {
    if (piles == null || piles.length == 0 || piles.length == 1) return 0;
    Arrays.sort(piles);
    int n = piles.length, count = 0;
    for (int i = 1; i < n; i++) {
      if (piles[i] > piles[i - 1]) {
        count += (n - i);
      }
    }

    return count;
  }

  /* ------- MIN CHAR REPLACEMENT ---------- */
  public static int minRepl(String s) {
    if (s == null || s.isEmpty()) return 0;
    int count = 1, forRemove = 0;

    for (int i = 1; i < s.length(); i++) {
      if (s.charAt(i) == s.charAt(i - 1)) {
        count++;
      } else {
        forRemove += (count > 2) ? count - 2 : 0;
        count = 1;
      }
    }

    return forRemove + ((count > 2) ? count - 2 : 0);
  }

  /* ------- MIN SUBSTRING ---------- */
  public static String minContiguousSubstring(String s) {
    int maxLen = 0, maxStart = 0, len = 1, start = 0, currCount = 1;
    int n = s.length();
    for (int i = 1; i < n; i++) {
      if (s.charAt(i) == s.charAt(i - 1)) {
        currCount++;
        len += (currCount <= 2) ? 1 : 0;
      } else {
        if (currCount <= 2) {
          currCount = 1;
          len++;
        } else {
          if (len > maxLen) {
            maxLen = len;
            maxStart = start;
          }
          len = 3;
          start = i - 2;
        }
      }
    }

    if (len > maxLen) {
      maxLen = len;
      maxStart = start;
    }

    return s.substring(maxStart, maxStart + maxLen);
  }

  /* Print vertical simple */
  public static void PrintVertical(int num) {
    int copy = num;

    int length = 0;
    while (copy > 0) {
      copy = copy / 10;
      length++;
    }

    for (int i = length - 1; i >= 0; i--) {
      int pow = (int) Math.pow(10 * 1.0, i);
      System.out.println(num / pow);
      num %= pow;
    }
  }

  static int[][] moves = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
  static int pathCount = 0;

  public static int uniquePaths3(int[][] grid) {
    if (grid == null) return 0;

    int count = 0, x = 0, y = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 1) {
          x = i;
          y = j;
        } else if (grid[i][j] == 0) {
          count++;
        }
      }
    }

    pathCount = 0;
    backtrackPaths(grid, count + 1, x, y);
    return pathCount;
  }

  private static void backtrackPaths(int[][] grid, int count, int i, int j) {
    if (grid[i][j] == 2) {
      if (count == 0)
        pathCount++;
      return;
    }

    int val = grid[i][j];
    for (int[] move : moves) {
      int x = i + move[0];
      int y = j + move[1];
      if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == -1) continue;
      grid[i][j] = -1;
      backtrackPaths(grid, count - 1, x, y);
      grid[i][j] = val;
    }
  }

  public static void main(String[] args) {
    //System.out.println(lexMinString("abczd"));

    //System.out.println(minSwapPalindrome("mamad"));
    //System.out.println(minSwapPalindrome("asflkj"));
    //System.out.println(minSwapPalindrome("aabb"));
    //System.out.println(minSwapPalindrome("ntiin"));

    //System.out.println(maxSum(new int[]{51, 71, 17, 42, 33, 44, 24, 62}));
    //System.out.println(maxSum(new int[]{51, 71, 17, 42}));
    //System.out.println(maxSum(new int[]{42, 33, 60}));
    //System.out.println(maxSum(new int[]{51, 32, 43}));

    //printNumVertically(1023456000);

    //System.out.println(minSteps(new int[]{5, 2, 1}));
    //System.out.println(minSteps(new int[]{4,5,5,4,2}));

    //System.out.println(minRepl("abababababab"));

    //System.out.println(minContiguousSubstring("aabbaabbaabbaa"));
    //System.out.println(minContiguousSubstring("aabbaaaaabb"));

    // 1 0 0 0
    // 0 0 0 0
    // 0 0 2 -1
    //

    System.out.println(uniquePaths3(new int[][]{
      {1, 0, 0, 0},
      {0, 0, 0, 0},
      {0, 0, 2, -1}
    }));
  }
}
