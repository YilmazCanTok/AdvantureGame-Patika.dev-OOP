public abstract class Weapon extends Item{
    private int id;
    private int damage;
    private int amount;

    Characters character;

    public Weapon(int id, int damage, int amount) {
        this.id = id;
        this.damage = damage;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Characters getCharacter() {
        return character;
    }

    public void setCharacter(Characters character) {
        this.character = character;
    }
}
