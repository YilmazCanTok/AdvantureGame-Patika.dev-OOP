import java.util.Scanner;

public class Player {
    private Inventory inventory;
    private int healthPoint;
    private int shield;
    private int damage;
    private int money;
    private String playerName;
    private String characterName;

    private Characters character;
    Scanner scanner = new Scanner(System.in);

    public Player(Inventory inventory) {
        this.inventory = inventory;
        Characters character;
    }

    public Characters getCharacter() {
        return character;
    }

    public void setCharacter(Characters character) {
        this.character = character;
    }

    public int getShield() {return shield; }

    public void setShield(int shield) {this.shield = shield; }
    public Player(String playerName){
        this.playerName=playerName;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getHealthPoint() {
        return healthPoint;
    }

    public void setHealthPoint(int healthPoint) {
        if (healthPoint<0){
            healthPoint=0;
        }
        this.healthPoint = healthPoint;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getPlayerName() {return playerName; }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public void selectCharacter(){
        System.out.print("Please Select a Character to Start Your Journey : ");
        int selection = scanner.nextInt();
        if (selection == 1) {
            this.setCharacter(new Samurai());
            System.out.println("You have chosen "+this.character.getName());
        }else if (selection == 2){
            this.setCharacter(new Archer());
            System.out.println("You have chosen "+this.character.getName());
        }else if (selection == 3) {
            this.setCharacter(new Knight());
            System.out.println("You have chosen "+this.character.getName());
        }else {
            System.out.println("Please enter a correct number to chose character");
            selectCharacter();
        }
        initPlayer(character);
    }

   public void initPlayer(Characters character){
        this.setDamage(character.getDamage());
        this.setMoney(character.getMoney());
        this.setCharacterName(character.getName());
        this.setHealthPoint(character.getHealthPoint());
        this.setShield(character.getShield());
        this.setInventory(inventory);
        this.getInventory().setWeapon(new NoWeapon());
        this.getInventory().setWeaponName("No Weapon");
        this.getInventory().setWeaponDamage(0);
        this.getInventory().setArmor(new NoArmor());
        this.getInventory().setArmorName("No Armor");
        this.getInventory().setArmorDefence(0);
        this.getInventory().setFirewood(false);
        this.getInventory().setFood(false);
        this.getInventory().setWater(false);
       System.out.println("Your Hp : "+this.getHealthPoint());
       System.out.println("Your Money : "+this.getMoney());
       System.out.println("Your Character's Name : "+this.getCharacterName());
       System.out.println("Your Shield : "+this.getShield());
       System.out.println("Your Damage : "+this.getDamage());
       System.out.println("Your Items : "+this.getInventory().getWeaponName()+" +  "+this.getInventory().getArmorName());
   }

}
