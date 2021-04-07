package game.types;

public enum EntityType {
    PLAYER(1), MONSTER(2);

    int value;

    EntityType(int type) {
        this.value = type;
    }

    public int getValue() {
        return value;
    }
}
