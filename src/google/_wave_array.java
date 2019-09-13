package google;

import java.util.Arrays;

public class _wave_array {
  // 1 2 3 4 5
  public static int[] wave(int[] array) {
    if (array == null || array.length == 0) return array;
    Arrays.sort(array);
    for (int i = 0; i < array.length - 1; i += 2) {
      swap(array, i, i + 1);
    }

    return array;
  }

  private static void swap(int[] array, int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
}
