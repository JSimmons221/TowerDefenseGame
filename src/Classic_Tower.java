import java.awt.*;
import java.awt.color.*;

public class Classic_Tower extends Tower {

    int x,y; //edit later when we have a working grid? (this is location)
    int damage_per_shot, range;

    public Classic_Tower(int x, int y){
        this.x = x;
        this.y = y;
        damage_per_shot = 2;
        range = 60; //change this later (if 20 pixels is the width of one tile
    }

    @Override
    void draw(Graphics2D g2){
        g2.setColor(new Color(153,93,51));
        g2.fillOval(x,y,10,10); //decide x and y later

    }

}
