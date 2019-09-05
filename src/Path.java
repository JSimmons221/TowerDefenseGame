import java.awt.*;

public class Path extends Tile{

    boolean walled;
    int x,y;

    public Path (){
        boolean walled = false;
    }

    @Override
    void draw(Graphics2D g2) {
        g2.setColor(new Color(245,222,179));
        g2.drawRect(x,y,Main.TWIDTH,Main.TWIDTH);
    }
}
