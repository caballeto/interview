package codejam.jam2018.roundA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution1 {
  private static int[] buildRcqH(char[][] matrix) {
    int[] rcq = new int[matrix[0].length + 1];
    for (int i = 1; i <= matrix[0].length; i++)
      rcq[i] = rcq[i - 1] + sumCol(matrix, i - 1);
    return rcq;
  }

  private static int[] buildRcqV(char[][] matrix) {
    int[] rcq = new int[matrix.length + 1];
    for (int i = 1; i <= matrix.length; i++)
      rcq[i] = rcq[i - 1] + sumRow(matrix, i - 1);
    return rcq;
  }

  private static int sumRow(char[][] matrix, int row) {
    int sum = 0;
    for (int i = 0; i < matrix[0].length; i++)
      sum += (matrix[row][i] == '@') ? 1 : 0;
    return sum;
  }

  private static int sumCol(char[][] matrix, int col) {
    int sum = 0;
    for (int i = 0; i < matrix.length; i++)
      sum += (matrix[i][col] == '@') ? 1 : 0;
    return sum;
  }

  private static int sum(char[][] matrix, int startRow, int startCol, int endRow, int endCol) {
    int sum = 0;
    for (int i = startRow; i < endRow; i++)
      for (int j = startCol; j < endCol; j++)
        sum += (matrix[i][j] == '@') ? 1 : 0;
    return sum;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    top:
    for (int i = 1; i <= t; ++i) {
      int R = in.nextInt();
      int C = in.nextInt();
      int H = in.nextInt();
      int V = in.nextInt();
      char[][] pie = new char[R][C];

      for (int j = 0; j < R; j++) {
        String s = in.next();
        for (int k = 0; k < C; k++) {
          pie[j][k] = s.charAt(k);
        }
      }

      int[] rcqH = buildRcqH(pie), rcqV = buildRcqV(pie);
      int N = rcqH[rcqH.length - 1];

      if (N % ((H + 1) * (V + 1)) != 0) {
        System.out.println("Case #" + i + ": IMPOSSIBLE");
        continue;
      }

      int currH = 0, currV = 0, prevV = 0, prevH = 0;
      int[] cutsV = new int[V + 2], cutsH = new int[H + 2];
      cutsV[cutsV.length - 1] = C;
      cutsH[cutsH.length - 1] = R;

      for (int j = 1; j < C; j++) {
        if (currV == V) break;
        if (rcqH[j] - rcqH[prevV] == N / (V + 1)) {
          cutsV[1 + currV++] = j;
          prevV = j;
        }
      }

      for (int j = 1; j < R; j++) {
        if (currH == H) break;
        if (rcqV[j] - rcqV[prevH] == N / (H + 1)) {
          cutsH[1 + currH++] = j;
          prevH = j;
        }
      }

      if (rcqH[C] - rcqH[prevV] != N / (V + 1) || currV != V || rcqV[R] - rcqV[prevH] != N / (H + 1) || currH != H) {
        System.out.println("Case #" + i + ": IMPOSSIBLE");
        continue;
      }

      for (int j = 0; j < cutsV.length - 1; j++) {
        int startCol = cutsV[j], endCol = cutsV[j + 1];
        for (int k = 0; k < cutsH.length - 1; k++) {
          int startRow = cutsH[k], endRow = cutsH[k + 1];
          if (sum(pie, startRow, startCol, endRow, endCol) != N / ((H + 1)*(V + 1))) {
            System.out.println("Case #" + i + ": IMPOSSIBLE");
            continue top;
          }
        }
      }

      System.out.println("Case #" + i + ": POSSIBLE");
    }
  }
}
