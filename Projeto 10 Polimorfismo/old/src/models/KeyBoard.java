package src.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class KeyBoard {

    private List<Integer> keysPressed;
    private Map<Integer, Boolean> keysUp;

    public KeyBoard() {
        this.keysPressed = new ArrayList<>();
        this.keysUp = new TreeMap<>();
    }

    public List<Integer> getKeysPressed() {
        return keysPressed;
    }

    public void addKeyPressed(int keyCode) {
        if (!keyIsPressed(keyCode))
            keysPressed.add(keyCode);
    }

    public void removeKeyPressed(Integer keyCode) {
        if (keyIsPressed(keyCode)) {
            keysPressed.remove(keyCode);
            keysUp.put(keyCode, false);
        }
    }

    public void updateInFrameKeyUp() {
        List<Integer> keysRemove = new ArrayList<>();
        for (Map.Entry<Integer, Boolean> value : keysUp.entrySet()) {
            if (value.getValue().booleanValue())
                keysRemove.add(value.getKey());
            else
                value.setValue(true);
        }

        for (int key : keysRemove) {
            keysUp.remove(key);
        }
    }

    public boolean keyIsPressed(int keyCode) {
        return keysPressed.contains(keyCode);
    }

    public boolean keyIsUp(int keyCode) {
        return keysUp.containsKey(keyCode);
    }
}
