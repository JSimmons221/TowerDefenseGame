import java.awt.*;

public class Path extends Tile{

    boolean walled;
    int x,y;

    public Path (int x, int y){
        walled = false;
        this.x=x;
        this.y=y;
    }

    @Override
    void draw(Graphics2D g2) {
        g2.setColor(new Color(245,222,179));
        g2.drawRect(x,y,Main.WIDTH,Main.WIDTH);
    }

}
