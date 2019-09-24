import java.awt.*;

public class TowerTile extends Tile{

    int x,y;

    public TowerTile (int x, int y){
        filled=false;
        selcted=false;
        this.x=x;
        this.y=y;
    }

    @Override
    void draw(Graphics2D g2) {
        g2.setColor(new Color(105,105,105));
        if (selcted){
            g2.setColor(Color.green);
        }
        g2.fillRect(x,y,Main.WIDTH,Main.WIDTH);

    }


}
