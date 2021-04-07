import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Inbox {
    public User user;
    public List<Message> messages;

    public Inbox(User user) {
        this.user = user;
        this.messages = new ArrayList<>();
    }

    public void addMessage(String message) {
        this.messages.add(new Message(user.id, message));
    }

    public void read(String userId) {
        for (Message message : messages) {
            if (!message.existUser(userId)) {
                message.addUser(userId);
            }
        }
    }

    @Override
    public String toString() {
        if (messages.isEmpty()) {
            return "";
        }

        return Arrays.toString(messages.toArray()).replaceAll("(, )", "\n").replace("[", "").replace("]", "");
    }
}
