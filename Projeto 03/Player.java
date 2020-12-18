import java.io.Serializable;

public class Player {
    private String nickname;
    private long points;

    public Player(String nickName) {
        this.nickname = nickName;
        this.points = 0;
    }

    public String getNickname() {
        return this.nickname;
    }

    public long getPoints() {
        return this.points;
    }

    public void setPoints(long points) {
        this.points = points;
    }
}
