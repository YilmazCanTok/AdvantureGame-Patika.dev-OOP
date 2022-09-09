import java.util.Scanner;
import java.util.Locale;

public class Forest extends BattleLocation{
    Scanner scanner=new Scanner(System.in);
    public Forest(Player player) {
        super(player, "Forest", new Vampire(),"Firewood",3);
    }


}
