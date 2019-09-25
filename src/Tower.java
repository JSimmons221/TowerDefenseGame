import java.awt.*;
import java.util.ArrayList;

public abstract class Tower {

    int damage_per_shot, x, y;
    boolean selected;

    public Tower (int damage_per_shot){
        selected=false;
        this.damage_per_shot=damage_per_shot;
    }

    abstract void draw(Graphics2D g2);
    abstract int update(ArrayList<Enemy> enemies);

    public int getDamage_per_shot() {
        return damage_per_shot;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
