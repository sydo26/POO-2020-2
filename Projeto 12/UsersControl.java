import java.util.Map;
import java.util.TreeMap;

public class UsersControl {
  private Map<String, User> allUsers;

  public UsersControl() {
    this.allUsers = new TreeMap<>();
  }

  public Map<String, User> getAllUsers() {
    return this.allUsers;
  }

  public User getUser(String username) {
    return this.allUsers.get(username);
  }

  public boolean addUser(String username) {
    return this.allUsers.computeIfAbsent(username, u -> new User(username)) != null;
  }

  public int follow(String username, String target) {
    // 2 - ok
    // 1 - username não encontrado
    // 0 - username target não encontrado
    // -1 - você já segue este usuário

    if (!this.allUsers.containsKey(username))
      return 1;
    if (!this.allUsers.containsKey(target))
      return 0;

    boolean approved = this.allUsers.get(username).follow(this.getUser(target));
    if (!approved)
      return 0;

    this.allUsers.get(target).addFollower(this.getUser(username));

    return 2;
  }

  public void show(Map<String, User> users) {
    for (Map.Entry<String, User> user : users.entrySet()) {
      System.out.println(user.getValue().toString());
    }
  }

  public boolean timeline(String username) {
    if (!this.allUsers.containsKey(username))
      return false;

    System.out.println(this.getUser(username).timeline());
    return true;
  }
}
