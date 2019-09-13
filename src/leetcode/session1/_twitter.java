package leetcode.session1;

import java.util.*;

public class _twitter {
  static class Twitter {
    private static final int MAX_COUNT = 10;

    private int time = 0;
    private Map<Integer, Set<Integer>> followers;
    private Map<Integer, List<Tweet>> tweets;

    /** Initialize your data structure here. */
    public Twitter() {
      followers = new HashMap<>();
      tweets = new HashMap<>();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
      if (!tweets.containsKey(userId)) {
        tweets.put(userId, new ArrayList<>());
      }
      tweets.get(userId).add(new Tweet(userId, tweetId, time++));
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
      List<Tweet> feed = tweets.getOrDefault(userId, new ArrayList<>());
      PriorityQueue<Tweet> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x.time));

      for (int i = feed.size() - 1; i >= 0 && i >= feed.size() - 10; i--) {
        pq.add(feed.get(i));
        if (pq.size() > MAX_COUNT) {
          pq.poll();
          break;
        }
      }

      for (int followee : followers.getOrDefault(userId, new HashSet<>())) {
        List<Tweet> followeeTweets = tweets.getOrDefault(followee, new ArrayList<>());

        for (int i = followeeTweets.size() - 1; i >= 0 && i >= (followeeTweets.size() - 10); i--) {
          Tweet tweet = followeeTweets.get(i);
          pq.add(tweet);
          if (pq.size() > MAX_COUNT) {
            pq.poll();
          }
        }
      }

      List<Integer> result = new ArrayList<>();
      while (!pq.isEmpty())
        result.add(pq.poll().tweetId);
      Collections.reverse(result);
      return result;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
      if (followeeId == followerId) return;
      if (!followers.containsKey(followerId)) {
        followers.put(followerId, new HashSet<>());
      }
      followers.get(followerId).add(followeeId);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
      if (followeeId == followerId) return;
      if (followers.containsKey(followerId)) {
        followers.get(followerId).remove(followeeId);
      }
    }

    private class Tweet {
      int userId;
      int tweetId;
      int time;

      Tweet(int userId, int tweetId, int time) {
        this.userId = userId;
        this.tweetId = tweetId;
        this.time = time;
      }
    }
  }

  public static void main(String[] args) {
    Twitter twitter = new Twitter();

// User 1 posts a new tweet (id = 5).
    twitter.postTweet(1, 5);

    twitter.follow(1, 2);
    twitter.follow(2, 1);

// User 1's news feed should return a list with 1 tweet id -> [5].
    System.out.println(twitter.getNewsFeed(2));

// User 2 posts a new tweet (id = 6).
    twitter.postTweet(2, 6);

// User 1's news feed should return a list with 2 tweet ids -> [6, 5].
// Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
    System.out.println(twitter.getNewsFeed(1));
    System.out.println(twitter.getNewsFeed(2));

// User 1 unfollows user 2.
    twitter.unfollow(1, 2);

// User 1's news feed should return a list with 1 tweet id -> [5],
// since user 1 is no longer following user 2.
    System.out.println(twitter.getNewsFeed(1));
  }
}
