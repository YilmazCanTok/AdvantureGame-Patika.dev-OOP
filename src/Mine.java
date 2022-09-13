import java.util.Random;
import java.util.Scanner;

public class Mine extends BattleLocation{

    private String award;
    private Obstacle obstacle;
    private int maxObstacle;
    private Scanner scanner = new Scanner(System.in);
    private int chance;
    private int obstacleNumber;
    private Player player;

    public Mine(Player player) {
        super(player, "Mine", new Snake(), "Nothing", 5);
        this.player=player;
    }

    @Override
    public String getAward() {
        return award;
    }

    @Override
    public void setAward(String award) {
        this.award = award;
    }

    @Override
    public Obstacle getObstacle() {
        return obstacle;
    }

    @Override
    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    @Override
    public int getMaxObstacle() {
        return maxObstacle;
    }

    @Override
    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }

    @Override
    public int getChance() {
        return chance;
    }

    @Override
    public void setChance(int chance) {
        this.chance = chance;
    }

    public int getObstacleNumber() {
        return obstacleNumber;
    }

    public void setObstacleNumber(int obstacleNumber) {
        this.obstacleNumber = obstacleNumber;
    }
    public boolean onLocation() {

        this.setObstacle(new Snake());
        this.setMaxObstacle(5);
        this.setName("Mine");
        this.setAward("Nothing");
        System.out.println(this.player.getHealthPoint());
        int oNumber = obstacleNumber();
        System.out.println("You are in "+this.getName()+" Right Now");
        System.out.println("You are in danger zone, Be careful, there are "+oNumber+" "+this.getObstacle().getName()+" living here");
        System.out.print("You want to Fight or Run?"+"F/R");
        String chose = scanner.nextLine().toUpperCase();
        if (chose.equals("F")&&(combat(oNumber))){
            System.out.println("Congratulations, You have defeated all the enemies");
            return true;
        }
        if (this.player.getHealthPoint()<=0) {
            System.out.println("You died");
            return false;
        }
        return true;
    }
    public boolean combat(int oNumber) {
        Random hitFirst = new Random();
        for (int i = 1; i <= oNumber; i++) {
            this.getObstacle().setHp(this.getObstacle().getOriginalHp());
            playerStatus();
            obstacleStatus(i);
            while (player.getHealthPoint()>0 && this.obstacle.getHp()>0){
                System.out.print("Hit or Run");
                String selectCombat=scanner.nextLine().toUpperCase();
                if (selectCombat.equals("H")) {
                    setChance(hitFirst.nextInt(2));
                    settingSnakeAttacks();
                    if(this.obstacle.getHp()>0 && chance==0){
                        System.out.println("The obstacle hit you " + this.obstacle.getDamage() + " damage");
                        armorCheck();
                        if (player.getHealthPoint()>0) {
                            System.out.println("You hit the obstacle " + player.getDamage()+" damage");
                            obstacle.setHp(this.obstacle.getHp()-player.getDamage());
                            System.out.println(this.obstacle.getName()+" hp is now : "+this.obstacle.getHp());
                        }
                    } else if (this.obstacle.getHp()>0 && chance==1) {
                        System.out.println("You hit the obstacle " + player.getDamage()+" damage");
                        this.obstacle.setHp(obstacle.getHp()-player.getDamage());
                        System.out.println(this.obstacle.getName()+" hp is now : "+this.obstacle.getHp());
                        if (this.obstacle.getHp()>0){
                            System.out.println("The obstacle hit you " + this.obstacle.getDamage() + " damage");
                            armorCheck();
                        }
                    }
                }else{
                    System.out.println("You ran away");
                    return false;
                }
            }
            if (this.obstacle.getHp()<player.getHealthPoint()){
                System.out.println("You defeated the enemy");
                setKillingAward();
            }else{
                return false;
            }
        }
        return true;
    }
    public void armorCheck(){
        if (player.getInventory().getArmorDefence()>this.obstacle.getDamage()){
            System.out.println("Obstacle's hit has been blocked by your armor...");
            System.out.println("Your Health Point is still : "+player.getHealthPoint());
        }else {
            player.setHealthPoint(player.getHealthPoint()-this.obstacle.getDamage());
            System.out.println("Your Health Point is now : "+player.getHealthPoint());
        }
    }
    public void playerStatus(){
        System.out.println("Your HP : "+this.player.getHealthPoint());
        System.out.println("Your Armor : "+this.player.getInventory().getArmorDefence());
        System.out.println("Your Damage : "+this.player.getDamage());
        System.out.println("Your Money : "+this.player.getMoney());
    }
    public void obstacleStatus(int i){
        System.out.println(i+". Obstacle's Name : "+this.obstacle.getName());
        System.out.println("Obstacle's HP : "+this.obstacle.getHp());
        System.out.println("Obstacle's Damage : "+this.obstacle.getDamage());
    }

    public void setKillingAward(){
        Random random1 = new Random();
        int randomChance = random1.nextInt(99)+1;
        int randomItem = random1.nextInt(99)+1;
        if(randomChance<=15){
            System.out.println("Congratulations, you have found armor from this snake");
            if(randomItem<=50){
                System.out.println("You have found light armor");
                Armor lightArmor = new LightArmor();
                inventoryCheckForArmors(lightArmor);
            }else if (randomItem>50 && randomItem<=80){
                System.out.println("You have found medium armor");
                Armor mediumArmor = new MediumArmor();
                inventoryCheckForArmors(mediumArmor);
            }else{
                System.out.println("You have found heavy armor");
                Armor heavyArmor = new HeavyArmor();
                player.getInventory().setArmor(heavyArmor);
            }
        }else if (randomChance<=30 && randomChance>15) {
            System.out.println("Congratulations, you have found weapon from this snake");
            if(randomItem<=50){
                System.out.println("You have found pistol");
                Pistol pistol = new Pistol();
                inventoryCheckForWeapons(pistol);
            }else if (randomItem>50 && randomItem<=80){
                System.out.println("You have found sword");
                Sword sword = new Sword();
                inventoryCheckForWeapons(sword);
            }else{
                System.out.println("You have found rifle");
                Rifle rifle = new Rifle();
                player.getInventory().setWeapon(rifle);
            }
        }else if(randomChance<=55 && randomChance>30){
            System.out.println("Congratulations, you have found money from this snake");
            checkAmount(randomItem);
        }else{
            System.out.println("Sorry, you haven't found anything from this snake");
        }
    }
    public void inventoryCheckForArmors(Armor armor){
        Armor armor1=player.getInventory().getArmor();
        if (armor1.getBlock()<armor.getBlock()){
            player.getInventory().setArmorDefence(armor.getBlock());
            player.getInventory().setArmor(armor);
            player.setShield(armor.getBlock());
            System.out.println("Your shield is now : "+player.getShield());
        }
    }
    public void inventoryCheckForWeapons(Weapon weapon){
        Weapon weapon1 = this.player.getInventory().getWeapon();
        if (weapon1.getDamage()<weapon.getDamage()) {
            this.player.getInventory().setWeapon(weapon);
            this.player.setDamage(this.player.getDamage()+ weapon.getDamage()-weapon1.getDamage());
            System.out.println("Your new damage is : "+this.player.getDamage());
        }
    }
    public void checkAmount(int randomItem){
        if (randomItem<=50){
            System.out.println("Congratulations, You have found 1 money from this snake");
            this.player.setMoney(this.player.getMoney()+1);
            System.out.println("Your amount is : "+this.player.getMoney());
        }else if(randomItem>50 && randomItem<=80){
            System.out.println("Congratulations, You have found 5 money from this snake");
            this.player.setMoney(this.player.getMoney()+5);
        }else{
            System.out.println("Congratulations, You have found 10 money from this snake");
            this.player.setMoney(this.player.getMoney()+10);
        }
    }

    public void settingSnakeAttacks(){
        Random random1 = new Random();
        this.obstacle.setDamage(random1.nextInt(4)+3);
    }

    @Override
    public int obstacleNumber() {
        Random random3 = new Random();
        obstacleNumber = random3.nextInt(this.maxObstacle) + 1;
        return obstacleNumber;
    }
}
