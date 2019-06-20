package leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

public class _295_median_stream {
  private Queue<Integer> minHeap;
  private Queue<Integer> maxHeap;

  public _295_median_stream() {
    this.minHeap = new PriorityQueue<>(Integer::compareTo);
    this.maxHeap = new PriorityQueue<>((a, b) -> (b - a));
  }

  public void addNum(int num) {
    if (maxHeap.size() == 0) {
      maxHeap.add(num);
      return;
    }

    if (maxHeap.size() == 1 && minHeap.size() == 0) {
      if (num > maxHeap.peek()) minHeap.add(num);
      else {
        minHeap.add(maxHeap.remove());
        maxHeap.add(num);
      }

      return;
    }

    int s1 = maxHeap.size(), s2 = minHeap.size();
    int hmin = maxHeap.peek(), lmax = minHeap.peek();
    if (s1 == s2) {
      if (num > lmax) {
        maxHeap.add(minHeap.remove());
        minHeap.add(num);
      } else {
        maxHeap.add(num);
      }
    } else {
      if (num > hmin) {
        minHeap.add(num);
      } else {
        minHeap.add(maxHeap.remove());
        maxHeap.add(num);
      }
    }
  }

  public double findMedian() {
    if (minHeap.size() == maxHeap.size()) {
      return ((double) maxHeap.peek() + minHeap.peek()) / 2;
    } else {
      return maxHeap.peek();
    }
  }
}
