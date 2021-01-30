import java.util.Map;

public class Twitter {
  private TweetGenerator generatorTweets;
  private UsersControl usersControl;

  public Twitter() {
    this.generatorTweets = new TweetGenerator();
    this.usersControl = new UsersControl();
  }

  public TweetGenerator getGeneratorTweets() {
    return this.generatorTweets;
  }

  public UsersControl getUsersControl() {
    return this.usersControl;
  }

  public Map<String, User> getAllUsers() {
    return this.getUsersControl().getAllUsers();
  }

  public boolean createUser(String username) {
    return this.getUsersControl().addUser(username);
  }

  public void showUsers(Map<String, User> users) {
    this.getUsersControl().show(users);
  }

  public int followUser(String username, String target) {
    return this.getUsersControl().follow(username, target);
  }

  public boolean twittar(String username, String message) {
    if (!this.getUsersControl().getAllUsers().containsKey(username))
      return false;
    Tweet tweet = this.getGeneratorTweets().create(username, message);
    this.getUsersControl().getUser(username).getMyTweets().add(tweet);
    for (Map.Entry<String, User> user : this.getUsersControl().getUser(username).getFollowers().entrySet()) {
      this.getUsersControl().getAllUsers().get(user.getKey()).getTimeline().add(tweet);
    }
    return true;
  }

  public boolean timeline(String username) {
    return this.getUsersControl().timeline(username);
  }

  public int like(String username, int tweetId) {

    if (!this.getUsersControl().getAllUsers().containsKey(username))
      return 0;
    try {
      this.getGeneratorTweets().getTweets().get(tweetId);
    } catch (IndexOutOfBoundsException e) {
      return -1;
    }

    boolean approved = this.generatorTweets.getTweets().get(tweetId).like(username);
    if (!approved)
      return 1;

    return 2;
  }

}
