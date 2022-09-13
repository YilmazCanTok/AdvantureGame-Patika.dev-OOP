import java.util.Random;

public class Snake  extends Obstacle{
    Random random = new Random();
    public Snake() {
        super(4, 12, 3, "Snake",0);
    }
}

