package leetcode.session1;

public class _weird_faculty {
  public static int weirdFaculty(int[] grades) {
    int sum = 0;
    for (int val : grades) {
      if (val == 1) {
        sum++;
      } else {
        sum--;
      }
    }

    int myResult = 0;
    for (int k = 0; k < grades.length; k++) {
      if (myResult > sum) return k;
      if (grades[k] == 1) {
        sum--;
        myResult++;
      } else {
        sum++;
        myResult--;
      }
    }

    return grades.length;
  }

  public static void main(String[] args) {
    System.out.println(weirdFaculty(new int[]{1, 1, 1, 0, 1}));
  }
}
