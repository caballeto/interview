import java.util.*;

public class Test {
  static final int TEST_SIZE = 15000000;

  static class Foo implements Comparable<Foo> {
    int val;

    Foo(int val) {
      this.val = val;
    }

    @Override
    public int compareTo(Foo o) {
      return val - o.val;
    }

    @Override
    public String toString() {
      return "(" + val + ")";
    }

    @Override
    public int hashCode() {
      return Objects.hash(val);
    }
  }

  public static void benchmark_array_sort() {
    Foo[] foos = new Foo[TEST_SIZE];
    for (int i = 0; i < foos.length; i++) {
      foos[i] = new Foo((i * 10) % 147);
    }

    long start = System.currentTimeMillis();
    Arrays.sort(foos);
    long end = System.currentTimeMillis();
    System.out.println("Sorted Foo[]: " + foos.length + ": " + (end - start) / 1000.);
  }

  public static void benchmark_list_sort_reserved() {
    List<Foo> foos = new ArrayList<>(TEST_SIZE);
    for (int i = 0; i < TEST_SIZE; i++) {
      foos.add(new Foo((i * 10) % 147));
    }

    long start = System.currentTimeMillis();
    Collections.sort(foos);
    long end = System.currentTimeMillis();
    System.out.println("Sorted List<Foo>(TEST_SIZE): " + foos.size() + ": " + (end - start) / 1000.);
  }

  public static void benchmark_list_sort_dynamic() {
    List<Foo> foos = new ArrayList<>();
    for (int i = 0; i < TEST_SIZE; i++) {
      foos.add(new Foo((i * 10) % 147));
    }

    long start = System.currentTimeMillis();
    Collections.sort(foos);
    long end = System.currentTimeMillis();
    System.out.println("Sorted List<Foo>: " + foos.size() + ": " + (end - start) / 1000.);
  }

  public static void benchmark_sort_primitive()  {
    int[] array = new int[TEST_SIZE];
    for (int i = 0; i < TEST_SIZE; i++) {
      array[i] = (i * 10) % 147;
    }

    long start = System.currentTimeMillis();
    Arrays.sort(array);
    long end = System.currentTimeMillis();
    System.out.println("Sorted int[]: " + array.length + ": " + (end - start) / 1000.);
  }

  public static void benchmark_sort_primitive_wrap()  {
    Integer[] array = new Integer[TEST_SIZE];
    for (int i = 0; i < TEST_SIZE; i++) {
      array[i] = (i * 10) % 147;
    }

    long start = System.currentTimeMillis();
    Arrays.sort(array);
    long end = System.currentTimeMillis();
    System.out.println("Sorted Integer[]: " + array.length + ": " + (end - start) / 1000.);
  }

  public static void benchmark_sort_primitive_list()  {
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < TEST_SIZE; i++) {
      list.add((i * 10) % 147);
    }

    long start = System.currentTimeMillis();
    Collections.sort(list);
    long end = System.currentTimeMillis();
    System.out.println("Sorted List<Integer>: " + list.size() + ": " + (end - start) / 1000.);
  }

  private static int missing(int[] smaller, int[] bigger) {
    if (smaller == null || smaller.length == 0) return 0;
    int val = smaller[0];
    for (int i = 1; i < smaller.length; i++)
      val ^= smaller[i];
    for (int i = 0; i < bigger.length; i++)
      val ^= bigger[i];
    return val;
  }

  public static void main(String[] args) {
    System.out.println("Benchmark objects.");
    benchmark_array_sort();
    benchmark_list_sort_dynamic();
    benchmark_list_sort_reserved();

    System.out.println("Benchmark primitives.");
    benchmark_sort_primitive();
    benchmark_sort_primitive_wrap();
    benchmark_sort_primitive_list();
  }
}
