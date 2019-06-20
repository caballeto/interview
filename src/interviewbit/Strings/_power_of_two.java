package interviewbit.Strings;

import java.math.BigInteger;

public class _power_of_two {
    public static int power(String num) {
      BigInteger val = new BigInteger(num);
      return val.and(val.subtract(BigInteger.ONE)).equals(BigInteger.ZERO) ? 1 : 0;
    }

  public static void main(String[] args) {
    System.out.println(power("65536"));
  }
}
