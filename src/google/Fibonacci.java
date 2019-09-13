package google;

public class Fibonacci {
  static class Matrix {
    long m_00;
    long m_01;
    long m_10;
    long m_11;

    Matrix() {}

    Matrix(long m_00, long m_01, long m_10, long m_11) {
      this.m_00 = m_00;
      this.m_01 = m_01;
      this.m_10 = m_10;
      this.m_11 = m_11;
    }
  }

  Matrix matrixMultiply(Matrix a, Matrix b) {
    Matrix matrix = new Matrix();

    matrix.m_00 = a.m_00 * b.m_00 + a.m_01 * b.m_10;
    matrix.m_01 = a.m_00 * b.m_01 + a.m_01 * b.m_11;
    matrix.m_10 = a.m_10 * b.m_00 + a.m_11 * b.m_10;
    matrix.m_11 = a.m_10 * b.m_01 + a.m_11 * b.m_11;

    return matrix;
  }

  Matrix power(int n) {
    Matrix result = new Matrix(), unit = new Matrix(1, 1, 1, 0);

    if (n == 1) {
      result = unit;
    } else if (n % 2 == 0) {
      result = power(n / 2);
      result = matrixMultiply(result, result);
    } else if (n % 2 == 1) {
      result = power((n - 1) / 2);
      result = matrixMultiply(result, result);
      result = matrixMultiply(result, unit);
    }

    return result;
  }

  long fib(int n) {
    return power(n - 1).m_00;
  }

  public static void main(String[] args) {
    System.out.println(new Fibonacci().fib(100)); // overflow not checked
  }
}
