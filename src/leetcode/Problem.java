package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Problem {
  private static final int LEFT = 0;
  private static final int UP = 1;
  private static final int RIGHT = 2;
  private static final int DOWN = 3;

  static class Graph {
    List<Integer>[] adj;
    int w;
    int h;
    int V;

    Graph(int w, int h) {
      this.w = w;
      this.h = h;
      this.V = (w + 1) * (h + 1);
      this.adj = (ArrayList<Integer>[]) new ArrayList[V];
      for (int i = 0; i < V; i++) {
        adj[i] = new ArrayList<>();
      }
    }

    void add(int x1, int y1, int x2, int y2) {
      int coord1 = getCoordNum(x1, y1), coord2 = getCoordNum(x2, y2);
      adj[coord1].add(coord2);
      adj[coord2].add(coord1);
    }

    int check(int x1, int y1, int direction) {
      int score = 0;
      switch (direction) {
        case LEFT: {
          int right = getCoordNum(x1, y1), left = getCoordNum(x1 - 1, y1);
          int topLeft = getCoordNum(x1 - 1, y1 + 1), topRight = getCoordNum(x1, y1 + 1);
          int botLeft = getCoordNum(x1 - 1, y1 - 1), botRight = getCoordNum(x1, y1 - 1);

          if (adj[right].contains(topRight) && adj[topRight].contains(topLeft) && adj[topLeft].contains(left)) score++;
          if (adj[right].contains(botRight) && adj[botRight].contains(botLeft) && adj[botLeft].contains(botRight)) score++;

          break;
        }
        case UP: {
          int bot = getCoordNum(x1, y1), top = getCoordNum(x1, y1 + 1);
          int leftTop = getCoordNum(x1 - 1, y1 + 1), leftBot = getCoordNum(x1 - 1, y1);
          int rightTop = getCoordNum(x1 + 1, y1 + 1), rightBot = getCoordNum(x1 + 1,  y1);

          if (adj[bot].contains(leftBot) && adj[leftBot].contains(leftTop) && adj[leftTop].contains(top)) score++;
          if (adj[bot].contains(rightBot) && adj[rightBot].contains(rightTop) && adj[rightTop].contains(top)) score++;

          break;
        }
        case RIGHT: {
          int right = getCoordNum(x1 + 1, y1), left = getCoordNum(x1, y1);
          int topLeft = getCoordNum(x1, y1 + 1), topRight = getCoordNum(x1 + 1, y1 + 1);
          int botLeft = getCoordNum(x1, y1 - 1), botRight = getCoordNum(x1 + 1, y1 - 1);

          if (adj[right].contains(topRight) && adj[topRight].contains(topLeft) && adj[topLeft].contains(left)) score++;
          if (adj[right].contains(botRight) && adj[botRight].contains(botLeft) && adj[botLeft].contains(botRight)) score++;

          break;
        }
        case DOWN: {
          int bot = getCoordNum(x1, y1 - 1), top = getCoordNum(x1, y1);
          int leftTop = getCoordNum(x1 - 1, y1), leftBot = getCoordNum(x1 - 1, y1 - 1);
          int rightTop = getCoordNum(x1 + 1, y1), rightBot = getCoordNum(x1 + 1,  y1 - 1);

          if (adj[bot].contains(leftBot) && adj[leftBot].contains(leftTop) && adj[leftTop].contains(top)) score++;
          if (adj[bot].contains(rightBot) && adj[rightBot].contains(rightTop) && adj[rightTop].contains(top)) score++;

          break;
        }
      }

      return score;
    }

    int getCoordNum(int x, int y) {
      return x + (w + 1) * (h - y);
    }
  }

  private static boolean validate(int w, int h, String[] moves, List<List<Integer>> processedMoves) {
    try {
      HashSet<List<Integer>> set = new HashSet<>();

      for (String move : moves) {
        String[] parts = move.split(" ");
        int x = Integer.parseInt(parts[0]);
        int y = Integer.parseInt(parts[1]);

        if (x < 0 || x > w || y < 0 || y > h) return false;
        if (x == 0 && parts[2].equals("L")) return false;
        if (x == w && parts[2].equals("R")) return false;
        if (y == 0 && parts[2].equals("D")) return false;
        if (y == h && parts[2].equals("U")) return false;

        List<Integer> moveAsList = new ArrayList<>(Arrays.asList(x, y));
        switch (parts[2]) {
          case "L": moveAsList.add(LEFT); break; // 0
          case "U": moveAsList.add(UP); break; // 1
          case "R": moveAsList.add(RIGHT); break; // 2
          case "D": moveAsList.add(DOWN); break; // 3
          default:
            return false;
        }

        if (set.contains(moveAsList))
          return false;
        else {
          set.add(moveAsList);
          processedMoves.add(moveAsList);
        }
      }
    } catch (Exception e) {
      return false;
    }

    return true;
  }

  static String score(int w, int h, String[] moves) {
    List<List<Integer>> processedMoves = new ArrayList<>();
    if (moves == null || !validate(w, h, moves, processedMoves)) {
      return "invalid";
    }

    int scoreRed = 0, scoreBlue = 0, i = 0;
    Graph G = new Graph(w, h);
    for (List<Integer> move : processedMoves) {
      int x = move.get(0), y = move.get(1), direction = move.get(2);

      int currentScore = 0;
      switch (direction) {
        case LEFT:  G.add(x, y, x - 1, y); currentScore = G.check(x, y, LEFT);   break;
        case UP:    G.add(x, y, x, y + 1); currentScore = G.check(x, y, UP);     break;
        case RIGHT: G.add(x, y, x + 1, y); currentScore = G.check(x, y,  RIGHT); break;
        case DOWN:  G.add(x, y, x, y - 1); currentScore = G.check(x, y, DOWN);   break;
      }

      if (i % 2 == 0) {
        scoreRed += currentScore;
      } else {
        scoreBlue += currentScore;
      }

      i++;
    }

    return "player 1 scored " + scoreRed + ", player 2 scored " + scoreBlue;
  }

  public static void main(String[] args) {

  }
}
