import java.awt.*;

public abstract class Tower {

    int damage_per_shot, range, speed_of_shot, x, y;

    abstract void draw(Graphics2D g2);
    abstract void update();

}
