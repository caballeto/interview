package leetcode;

import java.util.Arrays;

public class _468_validate_ip_addr {
  public String validIPAddress(String IP) {
    int choice;
    if (IP.contains(".")) {
      String[] parts = IP.split("\\.");
      try {
        if (parts.length == 4 && count(IP, '.') == 3) {
          System.out.println(Arrays.toString(parts));
          for (String part : parts) {
            if (part.length() != 1 && (part.startsWith("0") || part.startsWith("-")))
              throw new NumberFormatException();
            int x = Integer.parseInt(part);
            System.out.println(part + " " + x);
            if (x < 0 || x > 255) {
              throw new NumberFormatException();
            }
          }

          choice = 1;
        } else throw new NumberFormatException();
      } catch (NumberFormatException e) {
        choice = 3;
      }
    } else if (IP.contains(":")) {
      try {
        String[] parts = IP.split(":");
        if (parts.length == 8 && count(IP, ':') == 7) {
          for (String part : parts) {
            if (part.length() > 4 || part.startsWith("-")) throw new NumberFormatException();
            int x = Integer.parseInt(part, 16);
            if (x < 0 || x > 65535)
              throw new NumberFormatException();
          }

          choice = 2;
        } else throw new NumberFormatException();
      } catch (NumberFormatException e) {
        choice = 3;
      }
    } else {
      choice = 3;
    }

    return (choice == 1) ? "IPv4" : (choice == 2) ? "IPv6" : "Neither";
  }

  private int count(String s, char c) {
    int count = 0;
    for (int i = 0; i < s.length(); i++)
      if (s.charAt(i) == c) count++;
    return count;
  }

  public static void main(String[] args) {
    String IP = "0.0.0.-0";
    System.out.println(new _468_validate_ip_addr().validIPAddress(IP));
    //System.out.println(Integer.parseInt("-0"));
  }
}
