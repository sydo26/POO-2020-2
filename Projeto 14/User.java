import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class User {

    public String id;

    protected Map<String, Chat> chats; // chats em que o usuário está dentro
    protected List<Notify> notifys; // as notificações de todas os chats que o usuário se encontra

    public User(String id) {
        this.chats = new TreeMap<>();
        this.notifys = new ArrayList<>();
        this.id = id;
    }

    public Notify getNotifyUser(String chatId) {

        if (!chats.containsKey(chatId))
            return null;

        return notifys.get(notifys.indexOf(new Notify(chatId)));
    }

    public void removeCountNotify(String chatId) {
        if (chats.containsKey(chatId)) {
            getNotifyUser(chatId).removeUnReadCount();
        }
    }

    public void addCountNotify(String chatId) {
        if (chats.containsKey(chatId)) {
            getNotifyUser(chatId).addUnReadCount();
        }
    }

    public void addChat(Chat chat) {
        chats.computeIfAbsent(chat.id, k -> chat);
    }

    public void addNotify(Notify notify) {
        if (!notifys.contains(notify)) {
            notifys.add(notify);
        }
    }

    public void removeChat(String chatId) {
        if (chats.containsKey(chatId)) {
            chats.remove(chatId);
            notifys.remove(new Notify(chatId));
        }
    }

    public String toStringAllChats() {
        return Arrays.toString(chats.keySet().toArray()).replaceAll("(,)", " ## ");
    }

    public String toStringAllChatsReadNotify() {
        List<String> list = new ArrayList<>();

        for (String chatId : chats.keySet()) {
            Notify notify = notifys.get(notifys.indexOf(new Notify(chatId)));
            list.add(chatId + (notify.unreadCount > 0 ? ("(" + notify.unreadCount + ")") : ""));
        }

        return Arrays.toString(list.toArray()).replaceAll("(,)", " ## ");
    }
}
