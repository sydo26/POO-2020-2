public class Notify {
    public String chatId;
    public int unreadCount;

    public Notify(String chatId) {
        this.unreadCount = 0;
        this.chatId = chatId;
    }

    public void addUnReadCount() {
        this.unreadCount += 1;
    }

    public void removeUnReadCount() {
        this.unreadCount = 0;
    }

    @Override
    public int hashCode() {
        return chatId.hashCode() + 12050120;
    }

    @Override
    public boolean equals(Object obj) {

        // if(obj == null) {
        // return false;
        // } else {
        // return obj.hashCode() == this.hashCode();
        // }

        return obj == null ? false : obj.hashCode() == this.hashCode();
    }
}
