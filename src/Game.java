import java.util.Scanner;

public class Game {
    private Scanner scanner=new Scanner(System.in);
    private Player player;
    private Location location;

    public Game(Player player) {
        this.player=player;
    }

    public void start(){
        System.out.println("Welcome to Adventure Game");
        System.out.print("Please Enter a Nickname ");
        String name = scanner.nextLine();
        player.setPlayerName(name);
        System.out.println("Log in process is completed for "+player.getPlayerName());
        Characters[] characters = {new Samurai(), new Archer(), new Knight()};
        System.out.println("**************************************************");
        for (Characters characters1: characters) {
            System.out.println("--------------------------------------------------");
            System.out.println(characters1.getId()+" "+characters1.getName());
            System.out.println("Damage per hit : "+characters1.getDamage());
            System.out.println("HP : "+characters1.getHealthPoint());
            System.out.println("Money : "+characters1.getMoney());
            System.out.println("--------------------------------------------------");
        }
        System.out.println("**************************************************");
        player.selectCharacter();


        String locations = ("********** Locations *********\n" +
                "1.Safe House\n" +
                "2.ToolStore\n" +
                "3.Cave\n" +
                "4.River\n" +
                "5.Forest");
        while (true) {
            System.out.println(locations);
            System.out.print("Please enter a number to select your area : ");
            int selection = scanner.nextInt();
            switch (selection){
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                case 3:
                    location = new Cave(player);
                    break;
                case 4:
                    location = new River(player);
                    break;
                case 5:
                    location = new Forest(player);
                    break;
/*                case 6:
                    location = new Mine(player);*/
                default:
                    location = new SafeHouse(player);
            }
            if (!location.onLocation()){
                System.out.println("Game Over");
                break;
            }
            if (player.getInventory().isWater() && player.getInventory().isFood() && player.getInventory().isFirewood()){
                System.out.println("Congratulations, You are a SUrvivor. You finished all the Maps!");
                System.out.println("Game Over");
                break;
            }
        }
    }
}
