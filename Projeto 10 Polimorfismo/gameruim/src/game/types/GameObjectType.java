package game.types;

public enum GameObjectType {

    ENTITY(1);

    int value;

    GameObjectType(int type) {
        this.value = type;
    }

    public int getValue() {
        return value;
    }
}
