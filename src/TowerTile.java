import java.awt.*;

public class TowerTile extends Tile{

    boolean filled;
    int x,y;

    public TowerTile (int x, int y){
        filled=false;
        this.x=x;
        this.y=y;
    }

    @Override
    void draw(Graphics2D g2) {
        g2.setColor(new Color(34,149,34));
        g2.drawRect(x,y,Main.WIDTH,Main.WIDTH);
    }
}
