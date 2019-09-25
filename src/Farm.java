import java.awt.*;
import java.util.ArrayList;

public class Farm extends Tower {

    //generates gold each turn

    private int goldGen = 10;
    private int bank = 0;
    private int x,y,a;


    public Farm(int x, int y){
        super (0);
        this.x = x;
        this.y = y;
    }

    @Override
    void draw(Graphics2D g2) {
        g2.setColor(new Color(0,255,0));
        g2.fillRect(x*Main.WIDTH+Main.qWIDTH,y*Main.WIDTH+Main.qWIDTH,Main.WIDTH+Main.hWIDTH,Main.WIDTH+Main.hWIDTH); //decide this later
        g2.setColor(new Color(139,69,19));
        g2.setStroke(new BasicStroke(2));
        g2.drawRect(x*Main.WIDTH+Main.qWIDTH,y*Main.WIDTH+Main.qWIDTH,Main.WIDTH+Main.hWIDTH,Main.WIDTH+Main.hWIDTH);
        g2.setStroke(new BasicStroke(1));
    }

    @Override
    int update(ArrayList<Enemy> enemies) {
        if(a==0){
            bank += goldGen;
            a=10;
            return -1;
        }
        else
            a--;
        return -1;
    }
}
