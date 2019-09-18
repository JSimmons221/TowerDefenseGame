import java.awt.*;

public class TowerTile extends Tile{

    boolean filled;
    boolean selcted;
    int x,y;

    public TowerTile (int x, int y){
        filled=false;
        this.x=x;
        this.y=y;
    }

    @Override
    void draw(Graphics2D g2) {
        g2.setColor(new Color(105,105,105));
        g2.fillRect(x,y,Main.WIDTH,Main.WIDTH);
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
