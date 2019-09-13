package leetcode.session1;

public class _time_in_mall {
  static int findBusiestPeriod(int[][] data) {
    if (data == null || data.length == 0) return 0;
    int currentInside = 0, max = Integer.MIN_VALUE, maxTimestamp = 0;
    int i = 0;

    while (i < data.length) {
      int[] entry = data[i];
      int currentTime = entry[0];

      while (i < data.length && currentTime == data[i][0]) {
        if (data[i][2] == 1) {
          currentInside += data[i][1]; // 14
        } else {
          currentInside -= data[i][1]; // 14 - 4 = 10
        }

        i++;
      }

      if (currentInside > max) {
        max = currentInside;
        maxTimestamp = currentTime;
      }
    }

    return maxTimestamp;
  }
}
