public class SafeHouse extends NormalLocation{
    public SafeHouse(Player player) {
        super(player, "Safe House");
    }

    @Override
    public boolean onLocation() {
        System.out.println("You are in Safe House Right Now");
        System.out.println("Your health has been regenerated");
        if (player.getCharacterName().equals("Samurai")){
            player.setHealthPoint(player.getCharacter().getHealthPoint());
            System.out.println("Your Hp is : "+player.getHealthPoint());
        }
        else if(player.getCharacterName().equals("Knight")){
            player.setHealthPoint(player.getCharacter().getHealthPoint());
            System.out.println("Your Hp is : "+player.getHealthPoint());
        }
        else if(player.getCharacterName().equals("Archer")){
            player.setHealthPoint(player.getCharacter().getHealthPoint());
            System.out.println("Your Hp is : "+player.getHealthPoint());
        }
        return true;
    }
}
