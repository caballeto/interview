package interviewbit.Bits;

public class _divide_integers {
  public static int divide(int a, int b) {
    long A = (long)a;
    long B = (long)b;
    long sign = ((A<0)^(B<0))?-1:1;
    A = Math.abs(A);
    B = Math.abs(B);
    long quot = 0,temp = 0;
    for(int i=31;i>=0;--i){
      if((temp+(B<<i))<=A){
        temp += (B<<i);
        quot = quot|((long)1<<i);
      }
    }
    long result = (sign*quot);
    if(result>Integer.MAX_VALUE||result<Integer.MIN_VALUE){
      return Integer.MAX_VALUE;
    }
    return (int)result;
  }

  public static void main(String[] args) {
    System.out.println(divide(-2147483648, 1));
  }
}
