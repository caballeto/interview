package leetcode;

public class _738_monotone_number {
  public int monotoneIncreasingDigits(int N) {
    char[] arr = (N + "").toCharArray();
    int i = 1;
    while (i < arr.length && arr[i - 1] <= arr[i]) i++;
    while (0 < i && i < arr.length && arr[i - 1] > arr[i]) arr[--i]--;
    for (int j = i + 1; j < arr.length; j++) arr[j] = '9';

    return Integer.parseInt(String.valueOf(arr));
  }
}
