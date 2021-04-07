import java.util.ArrayList;
import java.util.List;

public class Message {

    public String userId;
    public String text;

    public List<String> users;

    public Message(String userId, String text) {
        this.userId = userId;
        this.text = text;
        this.users = new ArrayList<>();
    }

    public boolean existUser(String userId) {
        return users.indexOf(userId) > -1;
    }

    public void addUser(String userId) {
        users.add(userId);
    }

    @Override
    public String toString() {
        return " - " + userId + " => " + text;
    }
}
