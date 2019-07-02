package interviewbit.Greedy;

@SuppressWarnings("ALL")
public class _gas_stations {
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
}
