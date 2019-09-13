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
        g2.setColor(new Color(105,105,105));
        g2.fillRect(x,y,Main.WIDTH,Main.WIDTH);
    }
}
