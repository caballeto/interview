package leetcode;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import sun.misc.Unsafe;

public class _fibonnacci_logn {
  private static BigInteger[] values;

  public static BigInteger fib(int n) {
    BigDecimal a = new BigDecimal((1 + Math.sqrt(5.0)) / 2), b = new BigDecimal((1 - Math.sqrt(5.0)) / 2);
    BigDecimal dv = new BigDecimal(Math.sqrt(5));
    return a.pow(n)
      .subtract(b.pow(n))
      .divide(dv, RoundingMode.CEILING)
      .setScale(0, RoundingMode.DOWN)
      .toBigInteger();
  }

  public static BigInteger fib_iter(int n) {
    // in reasonable time for n <= 5_000_000;
    BigInteger prev = BigInteger.ONE;
    BigInteger pprev = BigInteger.ONE;
    BigInteger num = BigInteger.ONE;

    for (int v = 2; v < n; v++) {
      if (v % 1000 == 0) System.out.println(v);
      num = prev.add(pprev);
      pprev = prev;
      prev = num;
    }

    return num;
  }

  public static BigInteger fib_iter_mut(int n)
    throws
    NoSuchMethodException,
    IllegalAccessException,
    InvocationTargetException,
    InstantiationException,
    ClassNotFoundException
  {
    Constructor<?> constructor = Class.forName("java.math.MutableBigInteger").getDeclaredConstructor(int.class);
    constructor.setAccessible(true);

    Object num = constructor.newInstance(1);
    Object prev = constructor.newInstance(1);
    Object next = constructor.newInstance(1);

    Method m = num.getClass().getDeclaredMethod("add", num.getClass());
    m.setAccessible(true);

    Constructor<?> constructor2 = Class.forName("java.math.MutableBigInteger").getDeclaredConstructor(num.getClass());
    constructor2.setAccessible(true);

    for (int v = 1; v < n - 1; v++) {
      if (v % 1000 == 0) System.out.println(v);
      num = constructor.newInstance(0);
      m.invoke(num, prev);
      m.invoke(num, next);
      prev = next;
      next = num;
    }

    Method toBigInteger = num.getClass().getDeclaredMethod("toBigInteger");
    toBigInteger.setAccessible(true);

    return (BigInteger) toBigInteger.invoke(num);
  }

  public static void precompute(int maxN) {
    // OutOfMemmoryError for large numbers
    values = new BigInteger[maxN];
    values[0] = BigInteger.ZERO;
    values[1] = BigInteger.ONE;

    for (int v = 2; v < maxN; v++) {
      if (v % 1000 == 0) System.out.println(v);
      values[v] = values[v - 1].add(values[v - 2]);
    }
  }

  public static BigInteger get(int N) {
    if (N < 0) throw new IllegalArgumentException();
    if (N >= values.length) return fib(N);
    return values[N];
  }

  public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException {
    long start, end;

    int N = 2000000;

    //start = System.currentTimeMillis();
    //System.out.println(fib_iter_mut(N));
    //end = System.currentTimeMillis();
    //System.out.println("Execution time: " + (end - start) + "ms."); // 35s

    //start = System.currentTimeMillis();
    //System.out.println(fib_iter(N));
    //end = System.currentTimeMillis();
    //System.out.println("Execution time: " + (end - start) + "ms."); // 18s

    Class<?> clazz = Class.forName("leetcode.Printer");
    Method method = clazz.getDeclaredMethod("print");
    method.setAccessible(true);
    method.invoke(null);

    Field f = Unsafe.class.getDeclaredField("theUnsafe");
    f.setAccessible(true);
    Unsafe unsafe = (Unsafe) f.get(null);

    long address = unsafe.allocateMemory(100);
    unsafe.freeMemory(address);
  }
}
