public abstract class Obstacle {
    private int id;
    private int hp;
    private int damage;
    private String name;
    private int award;
    private int originalHp;



    public Obstacle(int id, int hp, int damage, String name, int award) {
        this.id = id;
        this.hp = hp;
        this.damage = damage;
        this.name = name;
        this.originalHp = hp;
        this.award = award;
    }

    public int getOriginalHp() {
        return originalHp;
    }

    public void setOriginalHp(int originalHp) {
        this.originalHp = originalHp;
    }

    public int getAward() {return award;}

    public void setAward(int award) {this.award = award;}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        if (hp < 0) {
            hp=0;
        }
        this.hp = hp;
    }

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
