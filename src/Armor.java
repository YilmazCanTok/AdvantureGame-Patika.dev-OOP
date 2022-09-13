public abstract class Armor extends Item{
    private int id;
    private int block;
    private int amount;

    public Armor(int id, int block, int amount) {
        this.id = id;
        this.block = block;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public int getBlock() {
        return block;
    }

    public int getAmount() {
        return amount;
    }

}

