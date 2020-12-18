package listeners;

public interface GameListeners {
    public void addPoints(int value);
    public long getPoints(); 
    public void removePoints(int value);
    public void upBooster();
    public int getBooster();
    public String playerNickName();
}
