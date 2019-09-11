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

    @Override
    void draw(Graphics2D g2){ //FINISH THIS SHITAKI MUSHROOM LATER
        g2.setColor(new Color(153,93,51));
        g2.fillOval(x,y,10,10); //decide x and y later
    }

    @Override
    int update(ArrayList<Sprite> enemies){
        boolean shot = false;
        if (a == 0){
            for(int i=0; i<enemies.size(); i++){
                int xdist=(int)(enemies.get(i).getCenterPoint().getX()-x);
                int ydist=(int)(enemies.get(i).getCenterPoint().getY()-y);
                int distance = (int)(Math.sqrt((xdist*xdist) + (ydist*ydist)));
                if (distance<=range){
                    shot = true;
                    a = 30;
                    return y;
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
