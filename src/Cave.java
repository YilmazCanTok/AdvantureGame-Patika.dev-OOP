import java.util.Locale;
import java.util.Scanner;

public class Cave extends BattleLocation{

    Scanner scanner = new Scanner(System.in);
    public Cave(Player player) {
        super(player, "Cave", new Zombie(), "Food",3);
    }


}
