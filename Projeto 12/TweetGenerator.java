import java.util.ArrayList;
import java.util.List;

public class TweetGenerator {

  private List<Tweet> tweets;
  private int nextId;

  public TweetGenerator() {
    this.tweets = new ArrayList<>();
    this.nextId = 0;
  }

  public List<Tweet> getTweets() {
    return this.tweets;
  }

  public int getNextId() {
    return nextId;
  }

  public Tweet create(String username, String message) {
    Tweet tweet = new Tweet(this.nextId++, username, message);
    this.tweets.add(tweet);
    return tweet;
  }

}