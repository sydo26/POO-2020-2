package src.models;

import java.io.Serializable;

import src.util.JSON;

public class PlayerData implements Serializable {

    private static final long serialVersionUID = 2216786584473645361L;

    private String name;
    private String displayName;
    private String UUID;

    public PlayerData(String name, String displayName) {
        this.name = name;
        this.displayName = displayName;
    }

    public String getName() {
        return name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getUUID() {
        return UUID;
    }

    public JSON toJson() {
        return (new JSON()).add("name", name).add("displayName", displayName).add("UUID", UUID);
    }
}
