import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class Services {
    public Map<String, User> users;
    public Map<String, Chat> chats;

    public Services() {
        this.users = new TreeMap<>();
        this.chats = new TreeMap<>();
    }

    public User getUser(String userId) {
        if (users.containsKey(userId))
            return users.get(userId);

        return null;
    }

    public int createUser(String userId) {
        if (users.containsKey(userId)) {
            return 0;
        }

        users.put(userId, new User(userId));

        return 1;
    }

    public int createChat(String userId, String chatId) {

        if (users.containsKey(userId)) {
            if (!chats.containsKey(chatId)) {
                Chat chat = new Chat(chatId);
                chat.addUser(getUser(userId));

                getUser(userId).addChat(chat);
                getUser(userId).addNotify(new Notify(chatId));

                chats.put(chatId, chat);
                return 1;
            }

            return -1;
        }

        // usuário não existe
        return 0;
    }

    public int invite(String guessid, String invitedUserId, String chatId) {

        if (!users.containsKey(guessid))
            return 0; // usuário 1 não existe

        if (!users.containsKey(invitedUserId))
            return -1; // usuário 2 não existe

        if (chats.containsKey(chatId)) {

            if (chats.get(chatId).existUser(guessid)) {
                chats.get(chatId).addUser(getUser(invitedUserId));

                return 1;
            }

            return -3;
        }

        return -2; // chat não existe
    }

    public int sendMessage(String userId, String chatId, String message) {
        if (!users.containsKey(userId))
            return 0;

        if (chats.containsKey(chatId)) {
            chats.get(chatId).notifyAllUsers(userId);
            chats.get(chatId).getInbox(userId).addMessage(message);

            return 1;
        }

        return -1;
    }

    public int leave(String userId, String chatId) {
        if (!users.containsKey(userId))
            return 0; // usuário não existe

        if (chats.containsKey(chatId)) {
            chats.get(chatId).removeUser(getUser(userId));

            return 1;
        }

        return -1; // chat não existe
    }

    public String readNotify(String userId) {
        if (!users.containsKey(userId))
            return null;

        return users.get(userId).toStringAllChatsReadNotify();
    }

    public String read(String userId, String chatId) {
        if (!users.containsKey(userId))
            return null;

        if (chats.containsKey(chatId)) {
            if (chats.get(chatId).existUser(userId)) {
                users.get(userId).removeCountNotify(chatId);
                String messages = chats.get(chatId).toStringAllMessages(userId);
                chats.get(chatId).readMessages(userId);
                return messages;
            }

            return "!@!@$!@$"; // preguiça de fazer mais planejado
        }

        return "";
    }

    public String toStringAllUsers() {
        return Arrays.toString(users.keySet().toArray()).replaceAll("(, )", " - ");
    }

    public String toStringAllChatsUser(String userId) {
        if (users.containsKey(userId)) {
            return users.get(userId).toStringAllChats();
        }

        return "";
    }

    public String toStringAllUsersChat(String chatId) {
        if (chats.containsKey(chatId)) {
            return chats.get(chatId).toStringAllUsers();
        }

        return "";
    }

}
