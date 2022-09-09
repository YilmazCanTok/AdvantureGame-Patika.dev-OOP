public abstract class Characters {
    private int healthPoint;

    private int shield;
    private int damage;
    private int money;
    private String name;
    private int id;

    public Characters(int healthPoint, int shield, int damage, int money, String name, int id) {
        this.healthPoint = healthPoint;
        this.damage = damage;
        this.money = money;
        this.name = name;
        this.id = id;
        this.shield = shield;
    }

    public int getShield() {
        return shield;
    }

    public void setShield(int shield) {
        this.shield = shield;
    }

    public int getHealthPoint() {
        return healthPoint;
    }

    public void setHealthPoint(int healthPoint) {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
