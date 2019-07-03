package interviewbit.Dp;

public class _longest_subseq {
  public static int longestSubsequenceLength(final int[] array) {
    int[] inc = new int[array.length], dec = new int[array.length];
    inc[0] = 1;
    for (int i = 1; i < array.length; i++) {
      int max = 0;
      for (int j = i - 1; j >= 0; j--) {
        if (array[i] > array[j] && inc[j] > max) {
          max = inc[j];
        }
      }

      inc[i] = max + 1;
    }

    dec[array.length - 1] = 1;
    for (int i = array.length - 2; i >= 0; i--) {
      int max = 0;
      for (int j = i + 1; j < array.length; j++) {
        if (array[i] > array[j] && dec[j] > max) {
          max = dec[j];
        }
      }

      dec[i] = max + 1;
    }

    int max = 1;
    for (int i = 0; i < array.length - 1; i++)
      max = Math.max(max, inc[i] + dec[i] - 1);
    return Math.max(max, inc[array.length - 1]);
  }

  public static void main(String[] args) {
    System.out.println(longestSubsequenceLength(new int[]{5, 4, 3, 2, 1}));
  }
}
