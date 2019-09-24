import java.awt.*;
import java.awt.color.*;
import java.util.ArrayList;

public class Classic_Tower extends Tower {

    int x,y; //edit later when we have a working grid? (this is location)
    int damage_per_shot, range;
    int a  = 0;

    public Classic_Tower(int x, int y){
        this.x = x;
        this.y = y;
        damage_per_shot = 2;
        range = Main.WIDTH*3; //change this later (if 20 pixels is the width of one tile)
    }

    public int getDamage_per_shot() {
        return damage_per_shot;
    }

    @Override
    void draw(Graphics2D g2){
        g2.setColor(new Color(153,93,51));
        g2.fillOval(x*Main.WIDTH+Main.qWIDTH,y*Main.WIDTH+Main.qWIDTH,
                Main.WIDTH*2-Main.hWIDTH,Main.WIDTH*2-Main.hWIDTH);
    }

    @Override
    int update(ArrayList<Enemy> enemies){
        boolean shot = false;
        if (a == 0){
            for(int i=0; i<enemies.size(); i++){
                int xdist=(int)(enemies.get(i).getCenterPoint().getX()-x);
                int ydist=(int)(enemies.get(i).getCenterPoint().getY()-y);
                int distance = (int)(Math.sqrt((xdist*xdist) + (ydist*ydist)));
                if (distance<=range && !shot && a<30){
                    shot = true;
                    a = 30;
                    return i;
                }
                else{
                    return -1;
                }
            }
        }
        else
            a--;
        return -1;
    }
}
