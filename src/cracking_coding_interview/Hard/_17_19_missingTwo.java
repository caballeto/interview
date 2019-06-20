package cracking_coding_interview.Hard;

public class _17_19_missingTwo {
  public static int missingOne(int[] a) {
    int n = a.length + 1;
    int sum = 0;
    for (int num : a) {
      sum += num;
    }

    return n*(n + 1)/2 - sum;
  }

  public static void main(String[] args) {
    int[] a = {1, 2, 3, 4, 6, 7, 8, 9}; // 5 missing
    System.out.println(missingOne(a));
  }
}
