package leetcode;

public class _134_gas_station {
  public int canCompleteCircuit(int[] gas, int[] cost) {
    if (gas == null || cost == null) return -1;
    int n = gas.length, sum;
    for (int start = 0; start < gas.length; ) {
      sum = gas[start];
      for (int next = start + 1; ; next++) {
        sum -= cost[(next - 1) % n];
        if (sum < 0) {
          start = next;
          break;
        }
        if (next % n == start) return start;
        sum += gas[next % n];
      }
    }

    return -1;
  }

  public static void main(String[] args) {
    int[] gas = new int[]{5, 1, 2, 3, 4};
    int[] cost = new int[]{4, 4, 1, 5, 1};
    System.out.println(new _134_gas_station().canCompleteCircuit(gas, cost));
  }
}
