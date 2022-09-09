import java.util.Scanner;
import java.util.Locale;

public class River extends BattleLocation{
    Scanner scanner=new Scanner(System.in);
    public River(Player player) {
        super(player, "River", new Bear(), "Water", 3);
    }


}
