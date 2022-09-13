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
        selection();
    }
    public void selection(){
        Location SafeHouse = new SafeHouse(player);
        Location ToolStore = new ToolStore(player);
        Location Cave = new Cave(player);
        Location River = new River(player);
        Location Forest = new Forest(player);
        Location Mine = new Mine(player);
        String locations = ("********** Locations *********\n" +
                "1.Safe House\n" +
                "2.ToolStore\n" +
                "3.Cave\n" +
                "4.River\n" +
                "5.Forest\n" +
                "6.Mine");
        while (true) {
            System.out.println(locations);
            System.out.print("Please enter a number to select your area : ");
            int selection = scanner.nextInt();
           if(selection == 1){
               location = SafeHouse;
           }else if(selection==2){
               location = ToolStore;
           }else if(selection==3){
               if (!player.getInventory().isFood()) {
                   location = Cave;
               }else{
                   System.out.println("You already conquered te cave. Please select somewhere else");
                   selection();
               }
           }else if(selection==4){
               if (!player.getInventory().isWater()) {
                   location = River;
               }else{
                   System.out.println("You already conquered te river. Please select somewhere else");
                   selection();
               }
           }else if(selection==5){
               if (!player.getInventory().isFirewood()) {
                   location = Forest;
               }else{
                   System.out.println("You already conquered te forest. Please select somewhere else");
                   selection();
               }
           }else if(selection==6){
               location = Mine;
           } else{
               location = SafeHouse;
           }
           if (!location.onLocation()){
               System.out.println("Game Over");
           }
           if (player.getInventory().isWater() && player.getInventory().isFood() && player.getInventory().isFirewood() && location.getName().equals("Safe House")){
                System.out.println("Congratulations, You are a Survivor. You finished all the Maps!");
                System.out.println("Game Over");
                break;
           }
        }
    }
}
