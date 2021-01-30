import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static java.util.stream.Collectors.joining;

public class User extends UserData {

  public User(String username) {
    super(username);
  }

  public boolean follow(User user) {
    if (!alreadyFollow(user.getUsername())) {
      addFollowed(user);
      return true;
    }
    return false;
  }

  public String timeline() {
    List<String> timelineList = new ArrayList<>();
    for (Tweet t : this.getMyTweets()) {
      timelineList.add(t.toString());
    }
    for (Tweet t : this.getTimeline()) {
      timelineList.add(t.toString());
    }

    Collections.sort(timelineList, (a, b) -> a.compareTo(b));

    return timelineList.stream().map(s -> s).collect(joining("\n"));
  }

  public boolean like(int tweetId) {
    int i;
    if ((i = existMyTweet(tweetId)) < 0)
      return false;

    this.getMyTweets().get(i).like(this.getUsername());
    return true;
  }

}
