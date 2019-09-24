import java.awt.*;
import java.util.ArrayList;

public class Farm extends Tower {

    //generates gold each turn

    private int goldGen = 10;
    private int bank = 0;
    private int x,y,a;


    public Farm(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    void draw(Graphics2D g2) {
        g2.setColor(new Color(255,102,102));
        g2.fillRect(10,10,10,10); //decide this later
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
