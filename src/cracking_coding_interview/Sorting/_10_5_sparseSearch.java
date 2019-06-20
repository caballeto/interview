package cracking_coding_interview.Sorting;

public class _10_5_sparseSearch {
  public static int sparseSearch(String[] strings, String target) {
    int lo = 0, hi = strings.length - 1, mid, nonempty;
    while (lo <= hi) {
      mid = (lo + hi) / 2;
      nonempty = mid;
      String s = strings[mid];
      if (s.isEmpty()) {
        int i = mid - 1, j = mid + 1;
        while (i >= 0 || j < strings.length) {
          if (i >= 0 && !strings[i].isEmpty()) {
            s = strings[i];
            nonempty = i;
            break;
          } else if (j < strings.length && !strings[i].isEmpty()) {
            s = strings[j];
            nonempty = j;
            break;
          } else {
            i--;
            j++;
          }
        }

        if (s.isEmpty()) return -1;
      }

      if (s.equals(target)) return nonempty;
      else if (s.compareTo(target) > 0) hi = mid - 1;
      else lo = mid + 1;
    }

    return -1;
  }

  public static void main(String[] args) {
    String target = "ball";
    String[] strings = {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""};
    System.out.println(sparseSearch(strings, target));
  }
}
