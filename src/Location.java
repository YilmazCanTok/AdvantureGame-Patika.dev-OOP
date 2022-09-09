import java.util.Scanner;

public abstract class Location {
    Player player;
    private String name;

    public static Scanner scanner;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location(Player player, String name) {
        this.player = player;
        this.name = name;
    }

    public abstract boolean onLocation();
}
