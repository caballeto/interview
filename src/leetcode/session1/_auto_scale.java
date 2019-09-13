package leetcode.session1;

public class _auto_scale {
  private static final int UPPER_LIMIT = (int) (2*Math.pow(10, 8));
  private static final int LOWER_LIMIT = 1;

  public static int scale(int instances, int[] util) {
    int lowerUtil = 25, upperUtil = 60;
    int time = 0;
    while (time < util.length) {
      if (util[time] > upperUtil && instances <= UPPER_LIMIT) {
        instances *= 2;
        time += 10;
      } else if (util[time] < lowerUtil && instances > LOWER_LIMIT) {
        instances = (instances + 1) / 2;
        time += 10;
      }
      time++;
    }

    return instances;
  }

  public static void main(String[] args) {
    System.out.println(scale(1, new int[]{5, 10, 80}));
  }
}
