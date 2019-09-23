import java.awt.*;
import java.util.ArrayList;

public abstract class Tower {

    int damage_per_shot, range, speed_of_shot, x, y;

    abstract void draw(Graphics2D g2);
    abstract int update(ArrayList<Sprite> enemies);

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
