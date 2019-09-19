import java.awt.*;

public abstract class Tile {

    boolean filled;
    boolean selcted;
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

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public boolean isSelcted() {
        return selcted;
    }

    public void setSelcted(boolean selcted) {
        this.selcted = selcted;
    }
}
