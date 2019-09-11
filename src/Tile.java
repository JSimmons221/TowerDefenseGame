import java.awt.*;

public abstract class Tile {

    int x,y;

    abstract void draw(Graphics2D g2);

    @Override
    public String toString(){
        return getClass().getSimpleName() + ":x=" + getX() + ",y=" + getY();
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
