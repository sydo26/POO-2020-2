import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import static java.util.stream.Collectors.joining;

public class UserData {
  private String username;
  private int unreads;
  private List<Tweet> timeline;
  private List<Tweet> myTweets;
  private Map<String, User> followers;
  private Map<String, User> followeds;

  public UserData(String username) {
    this.username = username;
    this.unreads = 0;
    this.timeline = new ArrayList<>();
    this.myTweets = new ArrayList<>();
    this.followeds = new TreeMap<>();
    this.followers = new TreeMap<>();
  }

  public int existMyTweet(int tweetId) {
    for (int i = 0; i < this.myTweets.size(); i++) {
      if (this.myTweets.get(i).getId() == tweetId)
        return i;
    }
    return -1;
  }

  public boolean alreadyFollow(String username) {
    return this.followeds.containsKey(username);
  }

  public boolean alreadyFollowMe(String username) {
    return this.followers.containsKey(username);
  }

  public void addFollower(User user) {
    this.followers.put(user.getUsername(), user);
  }

  public void addFollowed(User user) {
    this.followeds.put(user.getUsername(), user);
  }

  public Map<String, User> getFolloweds() {
    return this.followeds;
  }

  public Map<String, User> getFollowers() {
    return this.followers;
  }

  public List<Tweet> getMyTweets() {
    return this.myTweets;
  }

  public List<Tweet> getTimeline() {
    return this.timeline;
  }

  public int getUnreads() {
    return unreads;
  }

  public String getUsername() {
    return username;
  }

  @Override
  public String toString() {
    return (new StringBuilder()).append(this.getUsername()).append("\n").append("  ").append("seguidos\t").append("[ ")
        .append(this.getFolloweds().entrySet().stream().map(e -> e.getKey()).collect(joining(" "))).append(" ]\n")
        .append("  ").append("seguidores\t").append("[ ")
        .append(this.getFollowers().entrySet().stream().map(e -> e.getKey()).collect(joining(" "))).append(" ]")
        .toString();
  }
}
