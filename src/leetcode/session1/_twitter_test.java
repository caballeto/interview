package leetcode.session1;

import java.util.*;

public class _twitter_test {
  public static int restock(List<Integer> itemCount, int target) {
    int sum = 0;
    int i = 0;
    while (i < itemCount.size() && sum < target) {
      sum += itemCount.get(i);
      i++;
    }

    return Math.abs(sum - target);
  }

  public static int minPrice(List<List<Integer>> cost) {
    int n = cost.size();
    int[][] dp = new int[n][3];

    for (int i = 0; i < 3; i++)
      dp[0][i] = cost.get(0).get(i);

    for (int i = 1; i < n; i++) {
      for (int j = 0; j < 3; j++) {
        dp[i][j] = cost.get(i).get(j) + Math.min(dp[i - 1][(j + 1) % 3], dp[i - 1][(j + 2) % 3]);
      }
    }

    return Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2]));
  }

  public static long carParkingRoof(List<Long> cars, int k) {
    if (k == 1) return 1;
    Collections.sort(cars);
    long len = cars.get(k - 1) - cars.get(0) + 1, minLen = len;
    int i = k, j = 1;
    while (i < cars.size()) {
      len = cars.get(i) - cars.get(j) + 1;
      i++;
      j++;

      if (len < minLen) {
        minLen = len;
      }
    }

    return minLen;
  }

  public static void finalPrice(List<Integer> prices) {
    Deque<Integer> deque = new ArrayDeque<>();
    List<Integer> fullPriced = new ArrayList<>();
    long totalCost = 0;
    for (int i = prices.size() - 1; i >= 0; i--) {
      int price = prices.get(i);
      while (!deque.isEmpty() && price < deque.peekFirst())
        deque.pollFirst();

      if (deque.isEmpty()) {
        totalCost += price;
        fullPriced.add(i);
      } else {
        totalCost += (price - deque.peekFirst());
      }
      deque.addFirst(price);
    }

    System.out.println(totalCost);
    for (int i = fullPriced.size() - 1; i >= 0; i--) {
      if (i == 0)
        System.out.println(fullPriced.get(i));
      else
        System.out.print(fullPriced.get(i) + " ");
    }
  }

  public static void main(String[] args) {
    List<Long> longs = new ArrayList<>();
    longs.add(1L);
    longs.add(3L);
    longs.add(6L);
    longs.add(10L);
    System.out.println(carParkingRoof(longs, 4));
  }
}
