package leetcode;

import java.util.*;

public class _355_design_twitter {
  private Map<Integer, Set<Integer>> users;
  private List<Tweet> tweets;

  public _355_design_twitter() {
    this.users = new HashMap<>();
    this.tweets = new ArrayList<>();
  }

  public void postTweet(int userId, int tweetId) {
    if (!users.containsKey(userId)) {
      users.put(userId, new TreeSet<>());
    }

    tweets.add(new Tweet(userId, tweetId));
  }

  public List<Integer> getNewsFeed(int userId) {
    if (!users.containsKey(userId)) return new ArrayList<>();
    List<Integer> chosen = new ArrayList<>();
    Set<Integer> followers = users.get(userId);
    for (int i = tweets.size() - 1; i >= 0; i--) {
      Tweet tweet = tweets.get(i);
      if (userId == tweet.userId || followers.contains(tweet.userId))
        chosen.add(tweet.tweetId);
      if (chosen.size() == 10)
        return chosen;
    }

    return chosen;
  }

  public void follow(int followerId, int followeeId) {
    if (users.containsKey(followerId)) {
      users.get(followerId).add(followeeId);
    } else {
      TreeSet<Integer> set = new TreeSet<>();
      set.add(followeeId);
      users.put(followerId, set);
    }
  }

  public void unfollow(int followerId, int followeeId) {
    if (users.containsKey(followerId)) {
      users.get(followerId).remove(followeeId);
    }
  }

  private class Tweet {
    int userId;
    int tweetId;

    Tweet(int userId, int tweetId) {
      this.userId = userId;
      this.tweetId = tweetId;
    }
  }
}
