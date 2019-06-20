package interviewbit.BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _search_range {
  /*
  public static ArrayList<Integer> searchRange(final List<Integer> list, int target) {
    int lo = 0, hi = list.size() - 1;
    int res = -1;
    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;

      if (list.get(mid) < target) {
        lo = mid + 1;
      } else if (list.get(mid) > target) {
        hi = mid - 1;
      } else {
        res = mid;
        break;
      }
    }

    if (res < 0) {
      return new ArrayList<>(Arrays.asList(-1, -1));
    }

    int left = res, right = res;

    while (left > 0 && list.get(left - 1) == target)
      left--;

    while (right < list.size() - 1 && list.get(right + 1) == target)
      right++;

    return new ArrayList<>(Arrays.asList(left, right));
  }*/

  public static ArrayList<Integer> searchRange(final List<Integer> list, int target) {
    int left = first(list, 0, list.size() - 1, target, list.size());
    int right = last(list, 0, list.size() - 1, target, list.size());
    if (left < 0 || right < 0) return new ArrayList<>(Arrays.asList(-1, -1));
    return new ArrayList<>(Arrays.asList(left, right));
  }

  private static int first(List<Integer> arr, int low, int high, int x, int n)
  {
    if(high >= low)
    {
      int mid = low + (high - low)/2;
      if( ( mid == 0 || x > arr.get(mid-1)) && arr.get(mid) == x)
        return mid;
      else if(x > arr.get(mid))
        return first(arr, (mid + 1), high, x, n);
      else
        return first(arr, low, (mid -1), x, n);
    }

    return -1;
  }

  /* if x is present in arr[] then returns the index of
  LAST occurrence of x in arr[0..n-1], otherwise
  returns -1 */
  private static int last(List<Integer> arr, int low, int high, int x, int n)
  {
    if (high >= low) {
      int mid = low + (high - low)/2;
      if (( mid == n-1 || x < arr.get(mid+1)) && arr.get(mid) == x)
        return mid;
      else if (x < arr.get(mid))
        return last(arr, low, (mid -1), x, n);
      else
        return last(arr, (mid + 1), high, x, n);
    }
    return -1;
  }
}
