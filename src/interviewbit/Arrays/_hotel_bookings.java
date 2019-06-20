package interviewbit.Arrays;

import java.util.*;

public class _hotel_bookings {
  public static boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int k) {
    if (arrive.size() == 0 && k > 0) return true;
    List<Booking> list = new ArrayList<>();
    for (int i = 0; i < arrive.size(); i++)
      list.add(new Booking(arrive.get(i), depart.get(i)));
    Collections.sort(list);

    PriorityQueue<Booking> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.depart));

    pq.add(list.get(0));

    for (int i = 1; i < list.size(); i++) {
      while (pq.size() > 0 && pq.peek().depart <= list.get(i).arrive) pq.remove();
      Booking b = list.get(i);
      if (b.arrive != b.depart)
        pq.add(list.get(i));
      if (pq.size() > k) return false;
    }

    return true;
  }

  private static class Booking implements Comparable<Booking> {
    int arrive, depart;

    Booking(int arrive, int depart) {
      this.arrive = arrive;
      this.depart = depart;
    }

    @Override
    public int compareTo(Booking o) {
      return this.arrive - o.arrive;
    }

    @Override
    public String toString() {
      return "(" + arrive + "," + depart + ")";
    }
  }

  public static void main(String[] args) {
    //ArrayList<Integer> arrive = new ArrayList<>(Arrays.asList(1, 2, 3));
    //ArrayList<Integer> depart = new ArrayList<>(Arrays.asList(2, 3, 4));

    ArrayList<Integer> arrive = new ArrayList<>(Arrays.asList(41, 10, 12, 30, 0, 17, 38, 36, 45, 2, 33, 36, 39, 25, 22, 5, 41, 24, 12, 33, 19, 30, 25, 12, 36, 8));
    ArrayList<Integer> depart = new ArrayList<>(Arrays.asList(47, 20, 15, 65, 35, 51, 38, 36, 94, 30, 50, 38, 67, 64, 67, 24, 62, 38, 18, 59, 20, 74, 33, 43, 56, 32));
    int k = 12;
    System.out.println(hotel(arrive, depart, k));
  }
}
