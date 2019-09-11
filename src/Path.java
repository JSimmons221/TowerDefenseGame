import java.awt.*;

public class Path extends Tile{

    int x,y;

    public Path (int x, int y){
        this.x=x;
        this.y=y;
    }

    @Override
    void draw(Graphics2D g2) {
        g2.setColor(new Color(245,222,179));
        g2.fillRect(x,y,Main.WIDTH,Main.WIDTH);
    }

}
