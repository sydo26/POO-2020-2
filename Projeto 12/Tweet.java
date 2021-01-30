import java.util.Map;
import java.util.TreeMap;
import static java.util.stream.Collectors.joining;

public class Tweet {
  private int id;
  private int likes;
  private String username;
  private String message;
  private Map<String, User> likedUsers;

  public Tweet(int id, String username, String message) {
    this.id = id;
    this.username = username;
    this.message = message;
    this.likedUsers = new TreeMap<>((a, b) -> b.compareTo(a));
    this.likes = 0;
  }

  public int getId() {
    return id;
  }

  public int getLikes() {
    return likes;
  }

  public boolean like(String username) {
    boolean approved = this.likedUsers.computeIfAbsent(username, u -> new User(username)) != null;
    if (approved)
      this.likes++;
    return approved;
  }

  public String getMessage() {
    return message;
  }

  public String getUsername() {
    return username;
  }

  @Override
  public String toString() {
    return (new StringBuilder()).append(this.getId()).append(":").append(this.getUsername()).append("( ")
        .append(this.getMessage()).append(" )").toString()
        + (likedUsers.size() > 0
            ? ("[ " + likedUsers.entrySet().stream().map(s -> s.getKey()).collect(joining(" ")) + " ]")
            : "");
  }
}
