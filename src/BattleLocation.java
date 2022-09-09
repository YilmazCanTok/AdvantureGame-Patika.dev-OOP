import java.util.Random;
import java.util.Scanner;

public abstract class BattleLocation extends Location {
    private String award;
    private Obstacle obstacle;
    private int maxObstacle;
    Scanner scanner = new Scanner(System.in);

    private int obstacleNumber;

    public BattleLocation(Player player, String name, Obstacle obstacle, String award, int maxObstacle) {
        super(player, name);
        this.obstacle = obstacle;
        this.award = award;
        this.maxObstacle = maxObstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }

    public int obstacleNumber() {
        Random random = new Random();
        obstacleNumber = random.nextInt(this.maxObstacle) + 1;
        return obstacleNumber;
    }

    @Override
    public boolean onLocation() {
        int oNumber = obstacleNumber();
        System.out.println("You are in "+this.getName()+" Right Now");
        System.out.println("You are in danger zone, Be careful, there are "+oNumber+" "+this.getObstacle().getName()+" living here");
        System.out.println("If you conquer here, your award will  be : "+this.getAward());
        System.out.print("You want to Fight or Run?"+"F/R");
        String chose = scanner.nextLine().toUpperCase();
        if (chose.equals("F")&&(combat(oNumber))){
                System.out.println("Congratulations, You have defeated all the enemies");
                switch (this.getName()){
                    case ("River"):
                        if (!player.getInventory().isWater()){
                            System.out.println("Congratulations, You conquered the River!, You have the Water now");
                            player.getInventory().setWater(true);
                        }
                        else{
                            System.out.println("Congratulations, You conquered the River!, You already had the Water");
                        }
                        break;
                    case("Cave"):
                        if (!player.getInventory().isFood()){
                            System.out.println("Congratulations, You conquered the Cave!, You have the Food");
                            player.getInventory().setFood(true);
                        }
                        else{
                            System.out.println("Congratulations, You conquered the Cave!, You already had the Food");
                        }
                        break;
                    case ("Forest"):
                        if (!player.getInventory().isFirewood()){
                            System.out.println("Congratulations, You conquered the Cave!, You have the Firewood");
                            player.getInventory().setFirewood(true);
                        }
                        else{
                            System.out.println("Congratulations, You conquered the Forest!, You already had the Firewood");
                        }
                        break;
                }
                return true;
        }
        if (this.player.getHealthPoint()<=0) {
            System.out.println("You died");
            return false;
        }
        return true;
    }

    public boolean combat(int oNumber) {
        for (int i = 1; i <= oNumber; i++) {
            this.getObstacle().setHp(this.getObstacle().getOriginalHp());
            playerStatus();
            obstacleStatus(i);
            while (player.getHealthPoint()>0 && this.obstacle.getHp()>0){
                System.out.print("Hit or Run");
                String selectCombat=scanner.nextLine().toUpperCase();
                if (selectCombat.equals("H")) {
                    System.out.println("You hit the "+obstacle.getName());
                    obstacle.setHp(obstacle.getHp()-player.getDamage());
                    afterHit();
                    System.out.println("--------------------------------");
                    if (obstacle.getHp()<=0){
                        System.out.println("You killed the "+obstacle.getName());
                    } else{
                        System.out.println(obstacle.getName()+" hit you");
                        armorCheck();
                    }
                }else{
                    System.out.println("You ran away");
                    return false;
                }
            }
            if (obstacle.getHp()<player.getHealthPoint()){
                System.out.println("You defeated the enemy");
                System.out.println("You earned "+obstacle.getAward()+" money");
                player.setMoney(player.getMoney()+obstacle.getAward());
            }else{
                return false;
            }
        }
        return true;
    }

    public void afterHit(){
        System.out.println("Your Hp: "+player.getHealthPoint());
        System.out.println(obstacle.getName()+" Hp: "+obstacle.getHp());
        System.out.println();
    }

    public void armorCheck(){
        if (player.getInventory().getArmorDefence()>obstacle.getDamage()){
            System.out.println("Obstacle's hit has been blocked by your armor...");
            System.out.println("Your Health Point is still : "+player.getHealthPoint());
        }else {
            player.setHealthPoint(player.getHealthPoint()-obstacle.getDamage());
            System.out.println("Your Health Point is now : "+player.getHealthPoint());
        }
    }

    public void playerStatus(){
        System.out.println("Your HP : "+player.getHealthPoint());
        System.out.println("Your Armor : "+player.getInventory().getArmorDefence());
        System.out.println("Your Damage : "+player.getDamage());
        System.out.println("Your Money : "+player.getMoney());
    }
    public void obstacleStatus(int i){
        System.out.println(i+". Obstacle's Name : "+obstacle.getName());
        System.out.println("Obstacle's HP : "+obstacle.getHp());
        System.out.println("Obstacle's Damage : "+obstacle.getDamage());
        System.out.println("Award When Obstacle Killed : "+obstacle.getAward());
    }
}