
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class Chat {

    public String id;
    public Map<String, Inbox> inboxes;
    public Map<String, User> users; // usuários que estão no chat

    public Chat(String id) {
        this.id = id;
        this.inboxes = new TreeMap<>();
        this.users = new TreeMap<>();
    }

    public void readMessages(String userId) {
        for (Inbox inbox : inboxes.values()) {
            inbox.read(userId);
        }
    }

    public void notifyAllUsers(String userId) {
        for (User user : users.values()) {
            if (!user.id.equals(userId)) {
                user.getNotifyUser(this.id).addUnReadCount();
            }
        }
    }

    public String toStringAllUsers() {
        return Arrays.toString(users.keySet().toArray()).replaceAll("(, )", " - ");
    }

    public String toStringAllMessages(String userId) {

        StringBuilder builder = new StringBuilder();

        for (Inbox inbox : inboxes.values()) {
            for (Message message : inbox.messages) {
                if (!message.existUser(userId) && !userId.equals(inbox.user.id)) {
                    builder.append(message).append("\n");
                }
            }
        }

        if (builder.toString().isEmpty()) {
            return "Nenhuma mensagem";
        }

        return builder.toString();
    }

    public Inbox getInbox(String userId) {
        if (inboxes.containsKey(userId)) {
            return inboxes.get(userId);
        }

        return null;
    }

    public void addUser(User user) {
        users.computeIfAbsent(user.id, k -> {

            inboxes.computeIfAbsent(user.id, a -> new Inbox(user));

            user.addChat(this);
            user.addNotify(new Notify(this.id));

            return user;
        });
    }

    public void removeUser(User user) {
        if (users.containsKey(user.id)) {
            user.removeChat(this.id);
            users.remove(user.id);
        }
    }

    public boolean existUser(String userId) {
        return this.users.containsKey(userId);
    }

}
