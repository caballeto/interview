package interviewbit.Math;

import java.util.ArrayList;
import java.util.Arrays;

public class _prime_sum {
  public static ArrayList<Integer> primesum(int sum) {
    for (int i = 2; i <= sum/2; i++) {
      if (isPrime(i) && isPrime(sum - i)) {
        return new ArrayList<>(Arrays.asList(i, sum - i));
      }
    }

    return null;
  }

  private static boolean isPrime(int num) {
    for (int i = 2; i <= Math.sqrt(num); i++) {
      if (num % i == 0) return false;
    }

    return true;
  }

  public static void main(String[] args) {
    System.out.println(primesum(28));
  }
}
