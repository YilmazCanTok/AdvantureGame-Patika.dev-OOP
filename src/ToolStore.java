import java.time.Year;
import java.util.Scanner;

public class ToolStore extends NormalLocation{
    Armor lightArmor = new LightArmor();
    Armor mediumArmor = new MediumArmor();
    Armor heavyArmor = new HeavyArmor();
    Weapon pistol = new Pistol();
    Weapon sword = new Sword();
    Weapon rifle = new Rifle();

    Player player;

    Weapon noWeapon = new NoWeapon();
    Scanner scanner = new Scanner(System.in);
    public ToolStore(Player player) {
        super(player, "Tool Store");
        this.player=player;
    }

    @Override
    public boolean onLocation() {
        while(true) {
            System.out.println("You are in Tool Store Right Now");
            System.out.println("Welcome to the Store");
            System.out.println("1- Armors\n" +
                    "2- Weapons\n" +
                    "3- Exit");
            System.out.println("***********************************");
            System.out.println("Your Money is : "+player.getMoney()+" now");
            System.out.print("Please enter the number to make an action : ");
            int action = scanner.nextInt();
            if (action == 1) {
                buyArmor();
            } else if (action == 2) {
                buyWeapon();
            } else if (action == 3) {
                System.out.println("You are welcome to come this shop again");
                break;
            } else {
                System.out.println("Please enter a number between 1 and 3");
                onLocation();
            }
        }
        return true;
    }
    public void buyArmor(){
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println("1. Light Armor:\t id:"+lightArmor.getId()+"\t block:"+lightArmor.getBlock()+"\t amount:"+lightArmor.getAmount());
        System.out.println("2. Medium Armor:\t id:"+mediumArmor.getId()+"\t block:"+mediumArmor.getBlock()+"\t amount:"+mediumArmor.getAmount());
        System.out.println("3. Heavy Armor:\t id:"+heavyArmor.getId()+"\t block:"+heavyArmor.getBlock()+"\t amount:"+heavyArmor.getAmount());
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.print("Please chose the armor you want to get : ");
        int chose = scanner.nextInt();
        if (chose==1){
            buyLightArmor();
        } else if (chose==2) {
            buyMediumArmor();
        } else if (chose==3) {
            buyHeavyArmor();
        }else{
            onLocation();
        }
    }
    public void buyWeapon() {
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println("1. Pistol:\t id:" + pistol.getId() + "\t damage:" + pistol.getDamage() + "\t amount:" + pistol.getAmount());
        System.out.println("2. Sword:\t id:" + sword.getId() + "\t damage:" + sword.getDamage() + "\t amount:" + sword.getAmount());
        System.out.println("3. Rifle:\t id:" + rifle.getId() + "\t damage:" + rifle.getDamage() + "\t amount:" + rifle.getAmount());
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.print("Please chose the weapon you want to get : ");
        int chose = scanner.nextInt();
        if (chose==1){
            buyPistol();
        } else if (chose==2) {
            buySword();
        } else if (chose==3) {
            buyRifle();
        }else{
            onLocation();
        }
    }
    public void dropWeapon(Weapon weapon){
        if(weapon.getId()==1 || weapon.getId()==2 || weapon.getId()==3){
            System.out.println("Do you want to drop your weapon?");
            System.out.print("For yes, click 1 for no click 0");
            int chose = scanner.nextInt();
            scanner.nextLine();
            if (chose==1){
                player.setDamage(player.getDamage()-weapon.getDamage());
                player.getInventory().setWeapon(new NoWeapon());
                player.getInventory().setWeaponName("No Weapon");
                player.getInventory().setWeaponDamage(0);
                System.out.println("Your drop process is successful");
            }else{
                System.out.println("Your drop process is unsuccessful");
            }
        }
    }
    public void buyPistol(){
        if (player.getInventory().getWeaponName().equals("No Weapon")){
            if(player.getMoney()>= pistol.getAmount()){
                player.getInventory().setWeapon(pistol);
                player.getInventory().setWeaponDamage(pistol.getDamage());
                player.getInventory().setWeaponName("Pistol");
                player.setDamage(player.getDamage() + pistol.getDamage());
                player.setMoney(player.getMoney() - pistol.getAmount());
                System.out.println("Your buying process is succeed");
                System.out.println("Your new amount is : "+player.getMoney());
                System.out.println("Your new Damage is : "+player.getDamage());
                System.out.println("Your Weapon is : "+player.getInventory().getWeaponName());
            }else{
                System.out.println("Your amount is not enough for this weapon");
                System.out.println("Your amount is : "+player.getMoney());
            }
        }else{
            System.out.println("You have to drop your gun before you access to the new weapons!");
            dropWeapon(player.getInventory().getWeapon());
        }
    }
    public void buySword(){
        if (player.getInventory().getWeaponName().equals("No Weapon")){
            if(player.getMoney()>= sword.getAmount()){
                player.getInventory().setWeapon(sword);
                player.getInventory().setWeaponDamage(sword.getDamage());
                player.getInventory().setWeaponName("Sword");
                player.setDamage(player.getDamage() + sword.getDamage());
                player.setMoney(player.getMoney() - sword.getAmount());
                System.out.println("Your buying process is succeed");
                System.out.println("Your new amount is : "+player.getMoney());
                System.out.println("Your new Damage is : "+player.getDamage());
                System.out.println("Your Weapon is : "+player.getInventory().getWeaponName());
            }else{
                System.out.println("Your amount is not enough for this weapon");
                System.out.println("Your amount is : "+player.getMoney());
            }
        }else{
            System.out.println("You have to drop your gun before you access to the new weapons!");
            dropWeapon(player.getInventory().getWeapon());
        }
    }
    public void buyRifle(){
        if (player.getInventory().getWeaponName().equals("No Weapon")){
            if(player.getMoney()>= rifle.getAmount()){
                player.getInventory().setWeapon(rifle);
                player.getInventory().setWeaponDamage(rifle.getDamage());
                player.getInventory().setWeaponName("Rifle");
                player.setDamage(player.getDamage() + rifle.getDamage());
                player.setMoney(player.getMoney() - rifle.getAmount());
                System.out.println("Your buying process is succeed");
                System.out.println("Your new amount is : "+player.getMoney());
                System.out.println("Your new Damage is : "+player.getDamage());
                System.out.println("Your Weapon is : "+player.getInventory().getWeaponName());
            }else{
                System.out.println("Your amount is not enough for this weapon");
                System.out.println("Your amount is : "+player.getMoney());
            }
        }else{
            System.out.println("You have to drop your gun before you access to the new weapons!");
            dropWeapon(player.getInventory().getWeapon());
        }
    }
    public void buyLightArmor(){
        if (player.getMoney()>=lightArmor.getAmount()) {
            player.getInventory().setArmor(lightArmor);;
            player.getInventory().setArmorDefence(lightArmor.getBlock());
            player.getInventory().setArmorName("Light Armor");
            player.setShield(lightArmor.getBlock());
            player.setMoney(player.getMoney()-lightArmor.getAmount());
            System.out.println("Your buying process is succeed");
            System.out.println("Your new amount is "+player.getMoney());
            System.out.println("Your new Shield Protection is "+player.getShield());
            System.out.println("Your Shield is : "+player.getInventory().getArmorName());
        }else{
            System.out.println("Your amount is not enough for this armor");
            System.out.println("Your amount is : "+player.getMoney());
        }
    }
    public void buyMediumArmor(){
        if (player.getMoney()>=mediumArmor.getAmount()) {
            player.getInventory().setArmor(mediumArmor);
            player.getInventory().setArmorDefence(mediumArmor.getBlock());
            player.getInventory().setArmorName("Medium Armor");
            player.setShield(mediumArmor.getBlock());
            player.setMoney(player.getMoney()-mediumArmor.getAmount());
            System.out.println("Your buying process is succeed");
            System.out.println("Your new amount is "+player.getMoney());
            System.out.println("Your new Shield Protection is "+player.getShield());
            System.out.println("Your Shield is : "+player.getInventory().getArmorName());
        }else{
            System.out.println("Your amount is not enough for this armor");
            System.out.println("Your amount is : "+player.getMoney());
        }
    }
    public void buyHeavyArmor(){
        if (player.getMoney()>=heavyArmor.getAmount()) {
            player.getInventory().setArmor(heavyArmor);
            player.getInventory().setArmorDefence(heavyArmor.getBlock());
            player.getInventory().setArmorName("Heavy Armor");
            player.setShield(heavyArmor.getBlock());
            player.setMoney(player.getMoney()-heavyArmor.getAmount());
            System.out.println("Your buying process is succeed");
            System.out.println("Your new amount is "+player.getMoney());
            System.out.println("Your new Shield Protection is "+player.getShield());
            System.out.println("Your Shield is : "+player.getInventory().getArmorName());
        }else{
            System.out.println("Your amount is not enough for this armor");
            System.out.println("Your amount is : "+player.getMoney());
        }
    }
}

