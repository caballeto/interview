package interviewbit.Greedy;

import java.util.Arrays;

public class _distribute_candy {
  public static int candy(int[] ratings) {
    int[] count = new int[ratings.length];
    Arrays.fill(count, 1);

    for (int i = 1; i < ratings.length; i++)
      if (ratings[i] > ratings[i - 1])
        count[i] = Math.max(count[i], count[i - 1] + 1);

    for (int i = ratings.length - 2; i >= 0; i--)
      if (ratings[i] > ratings[i + 1])
        count[i] = Math.max(count[i], count[i + 1] + 1);

    return sum(count);
  }

  private static int sum(int[] count) {
    int s = 0;
    for (int v : count)
      s += v;
    return s;
  }

  public static void main(String[] args) {
    System.out.println(candy(new int[]{1, 3, 2}));
  }
}
