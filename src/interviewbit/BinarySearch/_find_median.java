package interviewbit.BinarySearch;

public class _find_median {
  public double findMedianSortedArrays(int[] A, int[] B) {
    int m = A.length;
    int n = B.length;
    if (m > n) {
      int[] temp = A; A = B; B = temp;
      int tmp = m; m = n; n = tmp;
    }

    int imin = 0, imax = m, len = (m + n + 1) / 2;
    while (imin <= imax) {
      int i = (imin + imax) / 2;
      int j = len - i;
      if      (i < imax && B[j-1] > A[i]) imin = i + 1;
      else if (i > imin && A[i-1] > B[j]) imax = i - 1;
      else {
        int left = 0;
        if      (i == 0) left = B[j-1];
        else if (j == 0) left = A[i-1];
        else             left = Math.max(A[i-1], B[j-1]);
        if ((m + n) % 2 == 1) return left;

        int right = 0;
        if      (i == m) right = B[j];
        else if (j == n) right = A[i];
        else             right = Math.min(A[i], B[j]);

        return (left + right) / 2.0;
      }
    }

    return 0;
  }
}
